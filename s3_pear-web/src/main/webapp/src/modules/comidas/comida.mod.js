(function (ng) {

    var mod = ng.module("comidaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider

                    .state('dieta_specs.comidas', {
                        url: "/comidas",
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
        } 
    ]);
})(window.angular);
