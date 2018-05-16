(function (ng) {

    var mod = ng.module("personaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/personas");

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

                    .state('actualizar_persona', {
                        url: '/personas/:id/put',
                        param: {
                            id: null
                        },
                        views: {
                            'post': {
                                templateUrl: "src/modules/personas/persona_update.html",
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

    mod.controller('personasController', ['$scope', '$http', 'personasContext', '$state', '$rootScope',

        function ($scope, $http, personasContext, $state, $rootScope) {

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

                if(!(data.nombre)){
                    console.log("Error en Nombre");
                    $state.go('post_persona', {}, {reload: false});
                    $scope.error_msg = "Por favor ingrese un nombre válido";
                }
                else if(data.nombre){
                    console.log("No debería entrar acá");
                    $http.post(personasContext, data).then(function (response) {
                        $scope.post_data = response.data;
                        $rootScope.id_persona = $scope.post_data.id;
                        $state.go('dietas', {}, {reload: true});
                    });
                }
            };

            //DELETE
            $scope.eliminar_persona = function (id) {
                $http.delete(personasContext + '/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                    $state.reload();
                });
            };

            //PUT
            $scope.actualizar_persona = function () {

                let data = {
                    id: $scope.id_persona,
                    nombre: $scope.new_nombre,
                    apellido: $scope.new_apellido,
                    edad: $scope.new_edad,
                    direccion: $scope.new_direccion,
                    correo: $scope.new_correo,
                    telefono: $scope.new_telefono,
                    identificacion: $scope.identificacion
                };
                $http.put('http://localhost:8080/s3_pear-web/api/personas/' + data.id, data).then(function (response) {
                    $scope.put_data = response.data;
                    $state.go('personas', {}, {reload: true});
                });
            };
        }

    ]);

})(window.angular);