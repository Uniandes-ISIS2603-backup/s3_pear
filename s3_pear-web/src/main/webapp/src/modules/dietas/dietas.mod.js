(function (ng) {

    var mod = ng.module("dietaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('dietas', {
                url: "/dietas",
                templateUrl: "src/modules/dietas/dietas.html",
                controller: 'dietasController'
            })

            .state('dietas.detail', {
                url: "/dieta/:id/detail",
                param: {
                    id: null
                },
                templateUrl: "src/modules/dietas/dieta_detail.html",
                controller: 'dietasController'
            })

        ;
    }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("dietaModule");
    mod.constant("dietasContext", "api/dietas");

    mod.controller('dietasController', ['$scope', '$http', 'dietasContext',

        function ($scope, $http, dietasContext) {
            //http://localhost:8080/s3_pear-web/api/dietas
            // src/modules/dietas/dietas.json
            
            $http.get(/*'http://localhost:8080/s3_pear-web/api/dietas'*/ 'src/modules/dietas/dietas.json' ).then(function (response) {
                $scope.dietas = response.data;
            });
            

            $scope.enviar_dieta = function () {

                let data = {

                    //Aqui hay que poner el identificador??
                    name: $scope.nombre,
                    descripcion: $scope.descripcion,
                    objetivo: $scope.objetivo
                };

                console.log(data);

                // DIRECCION HTTP 
                $http.post('http://localhost:8080/s3_pear-web/api/dietas', data).then(function (response) {
                    $scope.post_data = response.data;
                });
            };


            $scope.eliminar_dieta = function (id) {

                console.log(id + " < Se va a eliminar la dieta");

                // DIRECCION HTTP 
                $http.delete('http://localhost:8080/s3_pear-web/api/dietas/' + id ).then(function (response) {
                    $scope.post_data = response.data;
                });
            };
            
            


        }

    ]);
})(window.angular);
