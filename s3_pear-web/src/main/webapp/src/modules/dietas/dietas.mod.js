(function (ng) {

	var mod = ng.module("dietaModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise("/dietas");

		$stateProvider
			.state('dietas', {
				url: "/dietas",
				templateUrl: "src/modules/dietas/dietas.html",
				controller: 'dietasController'
			})  ;
    }]);

})(window.angular);

(function (ng) {

	var mod = ng.module("dietaModule");
	mod.constant("dietasContext", "api/dietas");

	mod.controller('dietasController', ['$scope', '$http', 'dietasContext',

        function ($scope, $http, dietasContext) {
			$http.get('src/modules/dietas/dietas.json').then(function (response) {
				$scope.dietas = response.data;
			});
        }

    ]);
})(window.angular);
