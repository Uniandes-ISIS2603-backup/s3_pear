(function (ng) {

    var mod = ng.module("comentarioModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider

                    .state('dieta_specs.comentarios', {
                        url: "/dieta/:id_dieta/specs/comentarios",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comentarios/comentarios_list.html',
                                controller: 'comentarioController'
                            }
                        }
                    })
                    
                    .state('dieta_specs.comentario_post', {
                        url: "/dieta/:id_dieta/specs/comentarios/post",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/comentarios/comentario_new.html',
                                controller: 'comentarioController'
                            }
                        }
                    })

                    ;
        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("comentarioModule");
    mod.constant("comentarioContext", "api/comentarios");


    mod.controller('comentarioController', ['$scope', '$http', 'comentarioContext', '$state', '$rootScope',

        function ($scope, $http, comentarioContext, $state, $rootScope) {
            

            if ($state.params.id_dieta !== null && $state.params.id_dieta !== undefined) {
                $scope.dieta = $state.params.id_dieta;

            }

            
        } // END FUNCTION CONTROLLER
    ]);
})(window.angular);
