(function (ng) {

    var mod = ng.module("quejasModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('quejasList', {
                url: "/dieta/:id/comentarios",
                param: {
                    id: null
                },
                templateUrl: "src/modules/quejasyreclamos/quejasList.html",
                controller: 'quejasController'
            }).state('quejasDetail', {
                url: "/{quejasId:int}/detail",
                param : {
                    id:null
                },
                templateUrl: 'src/modules/quejasyreclamos/quejasDetail.html',
                controller: 'quejasController'
            })


        ;
    }]);

})(window.angular);
