
(function (ng) {
    var mod = ng.module("quejasModule", ['ui.router']);
    
    mod.constant("quejasContext", "api/quejasyreclamos");
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
         
            $urlRouterProvider.otherwise("/quejasList");

		$stateProvider.state('quejas', {
				url: "/quejas",
                                abstract: true,
                                views:{
                                'mainView': {    
                                
				templateUrl: "src/module/quejasyreclamos/quejas.html",
				controller: 'quejasCtrl',
                                controllerAs: 'ctrl'
                                }
                            }
			}).state('quejasList',{
                            url: '/list',
                            parent: 'quejas',
                            views:{
                                'listView':
                                        {
                                            templateUrl : "src/module/quejasyreclamos/quejasList.html"
                                        }
                            }
                        }).state('quejasDetail',{
                            url: '/{quejasId:int}/detail',
                            parent: 'quejas',
                            param : {quejasId:null},
                            views: {
                                'listView':{
                                    templateUrl: "src/module/quejasyreclamos/quejasList.html"
                                    
                                },
                                'detailView':{
                                    templateUrl: "src/module/quejasyreclamos/quejasDetail.html",
                                    controller : 'quejasDetailCtrl',
                                    controllerAs: 'ctrl'
                                }
                                
                            }
                        })
        }]);
})(window.angular);
