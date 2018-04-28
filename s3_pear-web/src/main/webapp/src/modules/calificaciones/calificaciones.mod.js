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
                url:'/calificaciones/createCalifiacion',
                templateUrl: 'src/modules/calificaciones/new/calificaciones.new.html',
                controller: 'calificacionesCtrl'
            }).state('calificacionesUpdate',{
                url: '/update/{calificacionesId:int}/calificaciones/update',
                param : {
                    id:null
                },
                templateUrl:'src/modules/calificaciones/new/calificaciones.new.html',
                controller: 'calificacionesCtrl'
            })
    }]);

})(window.angular);
