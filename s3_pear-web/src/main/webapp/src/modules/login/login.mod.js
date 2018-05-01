(function (ng) {

	var mod = ng.module("loginModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise("/login");

		$stateProvider

			.state('login', {
				url: '/login',
				data: {
					requireLogin: false
				},
				views: {
					'post': {
						templateUrl: 'src/modules/personas/persona_add.html',
						controller: 'loginController'
					}
				}
			})
			.state('logout', {
				url: 'src/inicio.html',
				data: {
					requireLogin: false,
					roles: []
				},
				controller: 'loginController'
			})

		;


        }]);

})(window.angular);

(function (ng) {

	var mod = ng.module("loginModule");

	mod.controller('loginController', ['$scope', '$http', '$state',

        function ($scope, $http, $state) {

			$scope.usuario = true;
			$scope.admin = false;

        } // End Function Controller


    ]);
})(window.angular);
