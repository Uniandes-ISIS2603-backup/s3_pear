(function (ng) {

    var mod = ng.module("comentariosModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('comentarios', {
                url: "/dieta/:id/comentarios",
                param: {
                    id: null
                },
                templateUrl: "src/modules/comentarios/comentarios.html",
                controller: 'comentariosController'
            })


        ;
    }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("comentariosModule");
    mod.constant("comentariosContext", "api/comentarios");

    mod.controller('comentariosController', ['$scope', '$http', 'comentariosContext',

        function ($scope, $http, comentariosContext) {

            $http.get('src/modules/comentarios/comentarios.json').then(function (response) {

                $scope.comentarios = response.data;

            }).then(function (response) {
                console.log('FAILED GET COMENTARIOS ' + response);
            });

            $scope.enviar_comentario = function () {

                let data = {

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
