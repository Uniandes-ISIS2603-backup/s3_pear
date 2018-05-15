(function (ng) {

    var mod = ng.module("comentarioModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider

                    .state('dieta_specs.comentarios', {
                        url: "/comentarios",
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
                        url: "/comentarios/post",
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


    mod.controller('comentarioController', ['$scope', '$http', '$state', '$rootScope',

        function ($scope, $http, $state, $rootScope) {
            
            if ($state.params.id_dieta !== null && $state.params.id_dieta !== undefined) {
                $rootScope.dieta = $state.params.id_dieta;
            }
            
            $scope.comentario_post = function () {
                let data = {
                    asunto: $scope.asunto,
                    comentario: $scope.comentario
                    
                };
                $http.post('http://localhost:8080/s3_pear-web/api/dietas/' + $scope.dieta.id + '/quejasyreclamos', data).then(function (response) {
                    $scope.post_data = response.data;
                   $state.go('^.comentarios', {}, {
                        reload: true
                    });                    
                });
            };

            
        } // END FUNCTION CONTROLLER
    ]);
})(window.angular);
