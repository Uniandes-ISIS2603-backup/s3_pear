(function (ng) {

    var mod = ng.module("personaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider
                    .state('personas', {
                        url: "/personas",
                        templateUrl: "src/modules/personas/personas.html",
                        controller: 'personasController'
                    })
                    
                    .state('detailPersona', {
                        url: "/personas/:id/detail",
                        param: {
                            id: null
                        },
                        templateUrl: "src/modules/personas/persona_detail.html",
                        controller: 'personasController'
                    })
                    
                    .state('post_persona', {
                        url: '/persona/post',
                        views: {
                            'post': {
                                templateUrl: 'src/modules/personas/persona_add.html',
                                controller: 'personasController'
                            }
                        }
                    })
            
            ;

        }]);
})(window.angular);


//Controlador
(function (ng) {

    var mod = ng.module("personaModule");

    mod.constant("personasContext", "api/personas");

    mod.controller('personasController', ['$scope', '$http', 'personasContext', '$state',

        function ($scope, $http, personasContext, $state) {
            
            //GET
            $http.get('http://localhost:8080/s3_pear-web/api/personas').then(function (response) {
                $scope.personas = response.data;
            });
            
            //GET DETAIL
            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_persona = $state.params.id;

                $http.get('http://localhost:8080/s3_pear-web/api/personas/' + $state.params.id).then(function (response) {
                    $scope.persona = response.data;
                });
            }

            //POST
            $scope.post_persona = function () {
                
                let data = {
                    nombre: $scope.nombre,
                    apellido: $scope.apellido,
                    edad: $scope.edad,
                    direccion: $scope.direccion,
                    correo: $scope.correo,
                    subscrito: true
                };
                
                console.log('Se va a crear la siguiente persona');
                console.log(data);
                
                $http.post(personasContext, data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('personas', {}, {reload: true});
                });

            };
            
            
            $scope.eliminar_persona = function (id) {
                $http.delete(personasContext + '/' + id,).then(function (response) {
                    $scope.delete_data = response.data;
                    $state.reload();
                });
            };




        }

    ]);

})(window.angular);