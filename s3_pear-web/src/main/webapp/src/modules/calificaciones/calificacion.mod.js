(function (ng) {

    var mod = ng.module("calificacionModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider

                    .state('dieta_specs.calificaciones', {
                        url: "/calificaciones",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/calificaciones/calificaciones_list.html',
                                controller: 'calificacionController'
                            }
                        }
                    })

                    .state('dieta_specs.calificacion_post', {
                        url: "/calificaciones/post",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/calificaciones/calificacion_new.html',
                                controller: 'calificacionController'
                            }
                        }
                    })

                    ;
        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContext", "api/calificaciones");


    mod.controller('calificacionController', ['$scope', '$http', 'calificacionesContext', '$state', '$rootScope',

        function ($scope, $http, calificacionesContext, $state, $rootScope) {


            if ($state.params.id_dieta !== null && $state.params.id_dieta !== undefined) {
                $scope.dieta = $state.params.id_dieta;
            }
            ;


            $rootScope.cargarCalificaciones = function (dieta) {
                console.log('Buscando calificaciones d ela dieta con id : ' + dieta);
                $http.get('http://localhost:8080/s3_pear-web/api/dietas/' + dieta + '/calificaciones').then(function (response) {
                    $scope.calificaciones = response.data;

                });
            };


        } // END FUNCTION CONTROLLER
    ]);
})(window.angular);
