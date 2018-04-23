(function (ng) {

    var mod = ng.module("cocinaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('cocinas', {
                url: "/cocinas",
                templateUrl: "src/modules/cocinas/cocina_list.html",
                controller: 'cocinasController'
            })
            
            .state('cocina_detail', {
                url: "/cocina/:id/detail",
                param: {
                    id: null
                },
                templateUrl: "src/modules/cocinas/cocina_detail.html",
                controller: 'cocinasController'
            });
            
    }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("cocinaModule");
    mod.constant("cocinasContext", "api/cocinas");

    mod.controller('cocinasController', ['$scope', '$http', 'cocinasContext', '$state',

        function ($scope, $http, cocinasContext, $state) {
            //http://localhost:8080/s3_pear-web/api/cocinas
            //src/modules/cocinas/cocinas.json
            $http.get('http://localhost:8080/s3_pear-web/api/cocinas').then(function (response) {
                $scope.cocinas = response.data;
                console.log($scope.cocinas);
            });
            
            
            $scope.enviar_cocina = function() {
                let data = {
                    capacidad: $scope.capacidad,
                    ubicacion: $scope.ubicacion,
                    imagen: $scope.imagen,
                    name: $scope.name
                };
                
                console.log(data);

                // DIRECCION HTTP 
                $http.post('http://localhost:8080/s3_pear-web/api/cocinas', data).then(function (response) {
                    $scope.post_data = response.data;
                
                });
            };
            
            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_cocina = $state.params.id;

                // TODO Descomentar
                $http.get('http://localhost:8080/s3_pear-web/api/cocinas/' + $state.params.id ).then(function (response) {
                    $scope.cocina = response.data;
                });
            };
            
            
            $scope.eliminar_cocina = function( id ) {
                console.log(id + ' < Se va a eliminar la cocina');

                // DIRECCION HTTP 
                $http.delete('http://localhost:8080/s3_pear-web/api/cocinas/' + id).then(function (response) {
                    $scope.post_data = response.data;
                });
            };
            
            
            $scope.actualizar_cocina = function () {
                console.log($scope.id_cocina + " < Se va a actualizar la cocina.");
                
                let data = {
                    name: $scope.new_nombre,
                    ubicacion: $scope.new_ubicacion,
                    capacidad: $scope.new_capacidad,
                    imagen: $scope.new_imagen
                };
                
                //http://localhost:8080/s3_pear-web/api/dietas/3
                $http.put('http://localhost:8080/s3_pear-web/api/cocinas/' + $scope.id_cocina, data).then(function (response) {
                    $scope.put_data = response.data;
                });
            };
            
        }

    ]);
})(window.angular);
