(function (ng) {

    var mod = ng.module("comidaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider

                    .state('dieta_specs.comidas', {
                        url: "/comidas",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comidas/comidas_list.html',
                                controller: 'comidaController'
                            }
                        }
                    })
                    
                    .state('dieta_specs.comida_detail', {
                        url: "/comida/detail",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comidas/comida_detail.html',
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

            
        } // END FUNCTION CONTROLLER
    ]);
})(window.angular);
