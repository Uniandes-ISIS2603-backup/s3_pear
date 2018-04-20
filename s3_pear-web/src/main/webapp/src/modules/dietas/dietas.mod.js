(function (ng) {

	var mod = ng.module("dietaModule", ['ui.router']);

	mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise("/dietas");

		$stateProvider
			.state('dietas', {
				url: "/dietas",
				templateUrl: "src/modules/dietas/dietas.html",
				controller: 'dietasController'
			})  
        
            .state('dietas.detail', {
				url: "/dietas/detail",
				templateUrl: "src/modules/dietas/dieta_detail.html",
				controller: 'dietasController'
			}) 
        
        ;
    }]);

})(window.angular);

(function (ng) {

	var mod = ng.module("dietaModule");
	mod.constant("dietasContext", "api/dietas");

	mod.controller('dietasController', ['$scope', '$http', 'dietasContext',

        function ($scope, $http, dietasContext) {
			//http://localhost:8080/s3_pear-web/api/dietas
			$http.get('src/modules/dietas/dietas.json').then(function (response) {
				$scope.dietas = response.data;
			}).then(function (response) {
                console.log('FAILED GET DIETAS ' + response);
            })
            ;
            
            $scope.enviar_dieta = function () {
            
                let data = {
                    
                    //Aqui hay que poner el identificador??
                    nombre: $scope.nombre,
                    descripcion: $scope.descripcion,
                    objetivo: $scope.objetivos
                };
                
                console.log(data);

                // DIRECCION HTTP 
                /*$http.post(' DIRECCION HTTP DE POSTMAN', data).then(function (response) {
                    $scope.post_data = response.data;
                });*/
            }
            
            
            
        }

    ]);
})(window.angular);
