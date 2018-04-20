(function (ng) {

    var mod = ng.module("cocinaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('cocinas', {
                url: "/cocinas",
                templateUrl: "src/modules/cocinas/cocina_list.html",
                controller: 'cocinasController'
            });
    }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("cocinaModule");
    mod.constant("cocinasContext", "api/cocinas");

    mod.controller('cocinasController', ['$scope', '$http', 'cocinasContext',

        function ($scope, $http, cocinasContext) {
            //http://localhost:8080/s3_pear-web/api/cocinas
            $http.get('src/modules/cocinas/cocinas.json').then(function (response) {
                $scope.cocinas = response.data;
            });
            
            
            $scope.enviar_cocina = function() {
                let data = {
                    capacidad: $scope.capacidad,
                    direccion: $scope.direccion
                };
                
                console.log(data);

                // DIRECCION HTTP 
                /*$http.post(' DIRECCION HTTP DE POSTMAN', data).then(function (response) {
                    $scope.post_data = response.data;
                });*/
            }
            
        }

    ]);
})(window.angular);
