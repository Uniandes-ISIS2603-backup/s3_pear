(function (ng) {

    var mod = ng.module("calificacionesModule", ['ui.router']);

  
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('calificacionesList', {
                url: "/dieta/calificaciones",
                templateUrl: "src/modules/calificaciones/calificacionesList.html",
                controller: 'calificacionesCtrl'
            }).state('calificacionesDetail', {
                url: "/{calificacionesId:int}/calificacionlesList/detail",
                param : {
                    id:null
                },
                templateUrl: 'src/modules/calificaciones/calificacionesDetail.html',
                controller: 'calificacionesCtrl'
            }).state('calificacionesCreate', {
                url:'/createCalifiacion',
                templateUrl: 'src/modules/calificaciones/new/calificacionesAdd.html',
                controller: 'calificacaionNewCtrl'
            })
    }]);

})(window.angular);
