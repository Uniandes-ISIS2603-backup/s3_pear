(function (ng) {

	var mod = ng.module("semanaModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise("/dietas");

		$stateProvider
			.state('semanas', {
				url: "/semanas",
				templateUrl: "src/modules/semanas/semanas.html",
				controller: 'semanasController'
            
			}).state('semanas.detail', {
				url: "/semanas/detail",
				templateUrl: "src/modules/dietas/semana_detail.html",
				controller: 'semanasController'
			}) 	
    }]);
})(window.angular);


(function (ng) {

	var mod = ng.module("semanaModule");
	mod.constant("semanaContext", "api/semanas");

	mod.controller('semanasController', ['$scope', '$http', 'semanaContext',

        function ($scope, $http, semanaContext) {
            
            //semanaContext
           
			$http.get( 'http://localhost:8080/s3_pear-web/api/semanas').then(function (response) {
				$scope.semanas = response.data;
			}).then(function (response) {
                console.log('FAILED GET SEMANAS' + response);
            })
            ;
            
            $scope.enviar_semana = function (){
                let data = {
                    seEnvia: $scope.seEnvia,
                    recomendacion: $scope.recomendacion,
                    fecha: $scope.fecha
                };
                
                console.log(data);
        }
            
    }
    ]);
})(window.angular);

