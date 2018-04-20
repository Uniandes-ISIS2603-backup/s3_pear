(function (ng) {

	var mod = ng.module("facturaModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise("/dietas");
		$stateProvider
			.state('facturas', {
				url: "/facturas",
				templateUrl: "src/modules/facturas/facturas.html",
				controller: 'facturasController'
			})
    }]);

})(window.angular);

(function (ng) {

	var mod = ng.module("facturaModule");
	mod.constant("facturaContext", "api/facturas");

	mod.controller('facturasController', ['$scope', '$http', 'facturaContext',

        function ($scope, $http, facturasContext) {
			//http://localhost:8080/s3_pear-web/api/facturas
			$http.get('src/modules/facturas/facturas.json').then(function (response) {
				$scope.facturas = response.data;
			});
        }

    ]);
})(window.angular);


