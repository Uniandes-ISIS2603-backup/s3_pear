(function (ng) {

    var mod = ng.module("quejasModule", ['dietaModule','ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('quejasList', {
                url: "/dieta/{dietaId:int}/comentarios",
                param: {
                    dietaId:null
                },
                templateUrl: "src/modules/quejasyreclamos/quejasList.html",
                controller: 'quejasController'
            }).state('quejasDetail', {
                url: "/dieta/{idDieta:int}/comentarios/{quejasId:int}/detail",
                param : {
                    idDieta:null,
                    id:null
                    
                },
                templateUrl: 'src/modules/quejasyreclamos/quejasDetail.html',
                controller: 'quejasController'
            }).state('quejaCreate', {
                url:'/quejas/create',
                templateUrl: 'src/modules/quejasyreclamos/new/quejas.new.html',
                controller: 'quejasController'
            }).state('quejasUpdate',{
                url: '/dieta/{dietaId:int}/comentarios/{quejasId:int}/update',
                param : {
                    dietaId:null,
                    id:null
                    
                },
                templateUrl:'src/modules/quejasyreclamos/update/quejas.update.html',
                controller: 'quejasController'
            })


        
    }]);
})(window.angular);
