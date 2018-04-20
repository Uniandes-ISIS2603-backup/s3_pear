(function (ng) {

	var mod = ng.module("semanaModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise("/semanas");

		$stateProvider
			.state('semanas', {
				url: "/semanas",
				templateUrl: "src/modules/semanas/semanas.html",
				controller: 'semanasController'
			})	
    }]);

})(window.angular);

(function (ng) {

	var mod = ng.module("semanaModule");
	mod.constant("semanaContext", "api/semanas");

	mod.controller('semanasController', ['$scope', '$http', 'semanaContext',

        function ($scope, $http, semanaContext) {
			//http://localhost:8080/s3_pear-web/api/semanas
			$http.get('src/modules/semanas/semanas.json').then(function (response) {
				$scope.semanas = response.data;
			});
        }

    ]);
})(window.angular);