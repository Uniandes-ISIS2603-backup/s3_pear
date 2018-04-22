(function (ng) {

    var mod = ng.module("calificacionesModule", ['ui.router']);

  
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('calificacionesList', {
                url: "/dieta/:id/calificaciones",
                param: {
                    id: null
                },
                templateUrl: "src/modules/calificaciones/calificacionesList.html",
                controller: 'calificacionesCtrl'
            })


        ;
    }]);

})(window.angular);
