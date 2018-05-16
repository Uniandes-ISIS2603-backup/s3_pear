(function (ng) {

    var mod = ng.module("comidaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider

                    .state('dieta_specs.comidas', {
                        url: "/comidas/dias/:id_dia",
                        param: {
                            id_dia: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comidas/comidas_list.html',
                                controller: 'comidaController'
                            }
                        }
                    })
                    
                    .state('dieta_specs.comida_detail_almuerzo', {
                        url: "/comida/detail/almuerzo",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comidas/comida_detail_almuerzo.html',
                                controller: 'comidaController'
                            }
                        }
                    })
                     .state('dieta_specs.comida_detail_cena', {
                        url: "/comida/detail/cena",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comidas/comida_detail_cena.html',
                                controller: 'comidaController'
                            }
                        }
                    })
                     .state('dieta_specs.comida_detail_desayuno', {
                        url: "/comida/detail/desayuno",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comidas/comida_detail_desayuno.html',
                                controller: 'comidaController'
                            }
                        }
                    })
                     .state('dieta_specs.comida_detail_adicional', {
                        url: "/comida/detail/adicional",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comidas/comida_detail_adicional.html',
                                controller: 'comidaController'
                            }
                        }
                    })
                    
                    .state('dieta_specs.comida_post', {
                        url: "/comida/post",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comidas/comida_new.html',
                                controller: 'comidaController'
                            }
                        }
                    })

                    ;
        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("comidaModule");
    mod.constant("comidaContext", "api/comidas");


    mod.controller('comidaController', ['$scope', '$http', 'comidaContext', '$state', '$rootScope',

        function ($scope, $http, comidaContext, $state, $rootScope) {
            
            if ($state.params.id_dieta !== null && $state.params.id_dieta !== undefined) {
                $scope.dieta = $state.params.id_dieta;
            }          
            
            
            
            $rootScope.getDia = function ( id_dia ) {
                
                $http.get('http://localhost:8080/s3_pear-web/api/dias/' + id_dia).then(function (response) {
                    $rootScope.dia = response.data;
                    console.log($scope.dia);
                });
                
            };
            
            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_comida = $state.params.id;

                // TODO Descomentar
                $http.get('http://localhost:8080/s3_pear-web/api/comidas/' + $state.params.id ).then(function (response) {
                    $scope.comida = response.data;
                });
            }

            $scope.enviar_comida = function () {

                let data = {
                    alimentos: $scope.alimentos,
                    cantidad: $scope.cantidad,
                    TIPO: $scope.TIPO,
                   // image: $scope.image
                };

                console.log(data);

                // DIRECCION HTTP 
                $http.post('http://localhost:8080/s3_pear-web/api/comidas', data).then(function (response) {
                    $scope.post_data = response.data;
                });
            };


            $scope.eliminar_comida = function (id) {
                console.log(id + ' < Se va a eliminar la comida');

                // DIRECCION HTTP 
                $http.delete('http://localhost:8080/s3_pear-web/api/comidas/' + id).then(function (response) {
                    $scope.post_data = response.data;
                    $state.reload();
                });
            };


            $scope.actualizar_comida = function () {
                console.log($scope.id_comida + " < Se va a actualizar la comida.");
                
                let data = {
                    alimentos: $scope.new_alimentos,
                    cantidad: $scope.new_cantidad,
                    TIPO: $scope.new_TIPO
                   // image: $scope.new_image
                };
                
                //http://localhost:8080/s3_pear-web/api/comidas/3
                $http.put('http://localhost:8080/s3_pear-web/api/comidas/' + $scope.id_comida, data).then(function (response) {
                    $scope.put_data = response.data;
                    $state.go($state.current, {}, {reload: true});
                    $state.go('comidas', {}, {reload: true});
                });
            };
            
            
            
        } 
    ]);
})(window.angular);
