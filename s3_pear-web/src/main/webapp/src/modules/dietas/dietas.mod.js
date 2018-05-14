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

                    .state('dieta_update', {
                        url: "/dieta/:id/update",
                        param: {
                            id: null
                        },
                        views: {
                            'post': {
                                templateUrl: 'src/modules/dietas/dieta_update.html',
                                controller: 'dietasController'
                            }
                        }
                        //            ,
                        //                data: {
                        //                    requiereLogin: true,
                        //                    roles: ['admin', 'user']
                        //                }
                    })

                    .state('dieta_specs', {
                        url: "/dieta/:id/specs",
                        param: {
                            id: null
                        },
                        views: {
                            'post': {
                                templateUrl: 'src/modules/dietas/dieta_specs.html',
                                controller: 'dietasController'
                            }
                        }
                        //            ,
                        //                data: {
                        //                    requiereLogin: true,
                        //                    roles: ['admin', 'user']
                        //                }
                    })

                    .state('dieta_specs.dieta_specs_id', {
                        url: "/detail",
                        param: {
                            id: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/dietas/dieta_detail.html',
                                controller: 'dietasController'
                            }
                        }
                        //            ,
                        //                data: {
                        //                    requiereLogin: true,
                        //                    roles: ['admin', 'user']
                        //                }
                    })

                    .state('post_dieta', {
                        url: '/dietas/post',
                        views: {
                            'post': {
                                templateUrl: 'src/modules/dietas/dieta_new.html',
                                controller: 'dietasController'
                            }
                        }
                        //            ,
                        //                data: {
                        //                    requiereLogin: true,
                        //                    roles: ['admin']
                        //                }
                    })

                    .state('add_dieta', {
                        url: '/dietas/add_toPersona',
                        views: {
                            'post': {
                                templateUrl: 'src/modules/dietas/dieta_add_persona.html',
                                controller: 'dietasController'
                            }
                        }
                        //            ,
                        //                data: {
                        //                    requiereLogin: true,
                        //                    roles: ['admin']
                        //                }
                    })



                    ;
        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("dietaModule");
    mod.constant("dietasContext", "api/dietas");

    mod.filter('range', function () {
        return function (input, total) {
            total = parseInt(total);
            for (var i = 0; i < total; i++)
                input.push(i);
            return input;
        };
    });

    mod.controller('dietasController', ['$scope', '$http', 'dietasContext', '$state', '$rootScope',

        function ($scope, $http, dietasContext, $state, $rootScope) {
            //http://localhost:8080/s3_pear-web/api/dietas
            // src/modules/dietas/dietas.json

            $rootScope.agregando = false;

            $rootScope.estoyAgregando = function () {

                $rootScope.agregando = true;

            };


            if ($rootScope.user) {

                $http.get('http://localhost:8080/s3_pear-web/api/personas/' + $rootScope.id_persona).then(function (response) {
                    
                    $rootScope.persona = response.data;
                    
                    $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro/' + $rootScope.persona.cuenta.id).then(function (response) {
                        $rootScope.cuenta_personal = response.data;
                    });
                    
                    if ( $rootScope.cuenta_personal.cuenta.id === null || $rootScope.cuenta_personal.cuenta.id === undefined  )
                        $rootScope.definitivamente_no_tiene_dietas = true;
                    else
                        $rootScope.definitivamente_no_tiene_dietas = false;
                    
                });

            }

            $http.get('http://localhost:8080/s3_pear-web/api/dietas').then(function (response) {
                $scope.dietas = response.data;
            });


            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_dieta = $state.params.id;

                $http.get('http://localhost:8080/s3_pear-web/api/dietas/' + $state.params.id).then(function (response) {
                    $scope.dieta = response.data;
                });

            }

            $scope.enviar_dieta = function () {

                let data = {
                    name: $scope.nombre,
                    descripcion: $scope.descripcion,
                    objetivo: $scope.objetivo,
                    imagen: ($scope.imagen === null || $scope.imagen === undefined) ? 'https://images.pexels.com/photos/5317/food-salad-restaurant-person.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940' : $scope.imagen,
                    stars: $scope.stars
                };

                console.log(data);

                // DIRECCION HTTP 
                $http.post('http://localhost:8080/s3_pear-web/api/dietas', data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('dietas', {}, {
                        reload: true
                    });
                });
            };


            $scope.addDieta_toPersona = function (dieta_id) {

                $http.put('http://localhost:8080/s3_pear-web/api/personas/' + $rootScope.id_persona + '/dietas/' + dieta_id).then(function (response) {
                    $state.go('dietas', {}, {
                        reload: true
                    });
                });

            };

            $scope.cancelar_dieta = function (dieta_id) {

                $http.delete('http://localhost:8080/s3_pear-web/api/personas/' + $rootScope.id_persona + '/dietas/' + dieta_id).then(function (response) {
                    $state.go('dietas', {}, {
                        reload: true
                    });
                });
            }


            $scope.eliminar_dieta = function (id) {

                console.log(id + " < Se va a eliminar la dieta");

                // DIRECCION HTTP 
                $http.delete('http://localhost:8080/s3_pear-web/api/dietas/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                    $state.reload();
                });
            };


            $scope.actualizar_dieta = function () {
                console.log($scope.id_dieta + " < Se va a actualizar la dieta.");

                let data = {};

                if ($scope.new_nombre !== undefined || $scope.new_nombre !== null)
                    data.name = $scope.new_nombre;

                if ($scope.new_descripcion !== undefined || $scope.new_descripcion !== null)
                    data.descripcion = $scope.new_descripcion;

                if ($scope.new_objetivo !== undefined || $scope.new_objetivo !== null)
                    data.objetivo = $scope.new_objetivo;

                if ($scope.new_stars !== undefined || $scope.new_stars !== null)
                    data.stars = $scope.new_stars;

                if ($scope.new_imagen !== undefined || $scope.new_imagen !== null)
                    data.imagen = $scope.new_imagen;


                console.log(data);

                //http://localhost:8080/s3_pear-web/api/dietas/3
//                $http.put('http://localhost:8080/s3_pear-web/api/dietas/' + $scope.id_dieta, data).then(function (response) {
//                    $scope.put_data = response.data;
//                    $state.go($state.current, {}, {
//                        reload: true
//                    });
//                    $state.go('dietas', {}, {
//                        reload: true
//                    });
//                });
            };
        }
    ]);
})(window.angular);
