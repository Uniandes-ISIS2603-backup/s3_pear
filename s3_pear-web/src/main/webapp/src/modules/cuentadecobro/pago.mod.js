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


(function (ng) {

	var mod = ng.module("pagoModule");
	mod.constant("cuentaContext", "api/cuenta");

	mod.controller('cuentaController', ['$scope', '$http', 'cuentaContext',

        function ($scope, $http, cuentaContext) {
			
			//$http.get( http://localhost:8080/s3_pear-web/api/cuentascobro ).then(function (response) {
			//	$scope.cuentas = response.data;
			//});
        }

    ]);
})(window.angular);
