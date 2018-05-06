(function (ng) {

    var mod = ng.module("calificacionesModule", ['ui.router']);

  
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('calificacionesList', {
                url: "/dieta/{dietaId:int}/calificaciones",
                 param: {
                    dietaId:null
                },
                templateUrl: "src/modules/calificaciones/calificacionesList.html",
                controller: 'calificacionesCtrl'
            }).state('calificacionesDetail', {
                url: "/dieta/{idDieta:int}/calificaciones/{quejasId:int}/detail",
                param : {
                    
                    idDieta:null,
                    id:null
                    
                },
                templateUrl: 'src/modules/calificaciones/calificacionesDetail.html',
                controller: 'calificacionesCtrl'
            }).state('calificacionesCreate', {
                url:'/calificaciones/createCalifiacion',
                templateUrl: 'src/modules/calificaciones/new/calificaciones.new.html',
                controller: 'calificacionesCtrl'
            }).state('calificacionesUpdate',{
                url: '/dieta/{idDieta:int}/comentarios/update/{quejasId:int}',
                param : {
                    idDieta:null,
                    id:null
                },
                templateUrl:'src/modules/calificaciones/update/calificaciones.update.html',
                controller: 'calificacionesCtrl'
            })
    }]);

})(window.angular);
