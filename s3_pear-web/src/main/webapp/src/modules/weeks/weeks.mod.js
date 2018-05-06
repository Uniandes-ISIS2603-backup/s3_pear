(function (ng) {

    var mod = ng.module("weekModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider

                    .state('dieta_specs.weeks', {
                        url: "/weeks",
                        param: {
                            id_dieta: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/weeks/weeks_list.html',
                                controller: 'weekController'
                            }
                        }
                    })
                    
                    

                    ;
        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("weekModule");
    mod.constant("weekContext", "api/semanas");


    mod.controller('weekController', ['$scope', '$http', 'weekContext', '$state', '$rootScope',

        function ($scope, $http, comidaContext, $state, $rootScope) {
            

            if ($state.params.id_dieta !== null && $state.params.id_dieta !== undefined) {
                $scope.dieta = $state.params.id_dieta;

            }

            
        } // END FUNCTION CONTROLLER
    ]);
})(window.angular);
