(function (ng) {

    var mod = ng.module("quejasModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('quejasList', {
                url: "/dieta/comentarios",
                templateUrl: "src/modules/quejasyreclamos/quejasList.html",
                controller: 'quejasController'
            }).state('quejasDetail', {
                url: "/{quejasId:int}/quejasList/detail",
                param : {
                    id:null
                },
                templateUrl: 'src/modules/quejasyreclamos/quejasDetail.html',
                controller: 'quejasController'
            }).state('quejaCreate', {
                url:'/quejas/create',
                templateUrl: 'src/modules/quejasyreclamos/new/quejas.new.html',
                controller: 'quejasController'
            })


        
    }]);
})(window.angular);
