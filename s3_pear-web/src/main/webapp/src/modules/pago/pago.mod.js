(function (ng) {

	var mod = ng.module("pagoModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
			$urlRouterProvider.otherwise("/cuenta");

			$stateProvider
				.state('cuenta', {
					url: "/cuenta",
					templateUrl: "src/modules/cuentadecobro/hacerpago.html",
					controller: 'cuentaController'
				})
        }
    ]);
})(window.angular);

