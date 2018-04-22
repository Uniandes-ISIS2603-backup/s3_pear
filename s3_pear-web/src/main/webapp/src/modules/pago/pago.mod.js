(function (ng) {

	var mod = ng.module("pagoModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
			
                        $urlRouterProvider.otherwise("/dietas");
                        var basePath = 'src/modules/pago/'; 
			$stateProvider
				.state('pago', {
					url: '/pago',
					templateUrl:  basePath + 'hacerpago.html',
					controller: 'pagoController',

                                         
				}).state ('medioPagoDetail',{
                                        
                                        url: '/{medioPagoId:int}',
					templateUrl: basePath + 'hacerpago.html',
					controller: 'pagoDetailController',
                                  
                                        param: {
                                            medioPagoId: null
                                        }
                                     
                                });
        }
    ]);
})(window.angular);

