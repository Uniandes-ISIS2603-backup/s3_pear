(function (ng) {
    
    var mod = ng.module("pagoModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/cuentadecobro/';
            
            $urlRouterProvider.otherwise("/hacerpago");
            
            $stateProvider.state('hacerpago', {
                
                url: '/hacerpago',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'hacerpago.html',
                        controller: 'pagoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);
