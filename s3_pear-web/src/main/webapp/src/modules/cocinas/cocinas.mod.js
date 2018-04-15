(function (ng) {

	var mod = ng.module("cocinaModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise("/dietas");

		$stateProvider
			.state('cocinas', {
				url: "/cocinas",
				templateUrl: "src/modules/cocinas/cocinas.html",
				controller: 'cocinasController'
			})  ;
    }]);

})(window.angular);

(function (ng) {

	var mod = ng.module("cocinaModule");
	mod.constant("cocinasContext", "api/cocinas");

	mod.controller('cocinasController', ['$scope', '$http', 'cocinasContext',

        function ($scope, $http, cocinasContext) {
			//http://localhost:8080/s3_pear-web/api/cocinas
			$http.get('src/modules/cocinas/cocinas.json').then(function (response) {
				$scope.cocinas = response.data;
			});
        }

    ]);
})(window.angular);
