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
                        
                        .state('detailFactura', {
                        url: "/factura/:id/factura",
                        param: {
                            id: null
                        },
                        templateUrl: "src/modules/facturas/factura_detail.html",
                        controller: 'facturasController'
                    })
                    
                    
                       .state('postFactura', {
                        url: '/facturas/post',
                        views: {
                            'post': {
                                templateUrl: 'src/modules/facturas/factura_nueva.html',
                                controller: 'facturasController'
                            }
                        }
                    });
 
                        
    }]);

})(window.angular);

(function (ng) {

	var mod = ng.module("facturaModule");
	mod.constant("facturaContext", "api/facturas");

	mod.controller('facturasController', ['$scope', '$http', 'facturaContext', '$state',

        function ($scope, $http, facturasContext, $state) {
			//http://localhost:8080/s3_pear-web/api/facturas
                        //src/modules/facturas/facturas.json
	         $http.get('http://localhost:8080/s3_pear-web/api/facturas').then(function (response) {
		     $scope.facturas = response.data;
	         });
                        
                 if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_factura = $state.params.id;

                $http.get('http://localhost:8080/s3_pear-web/api/facturas/' + $state.params.id).then(function (response) {
                    $scope.factura = response.data;
                });
            }
            
             $scope.enviar_factura = function () {

                 let data = {
                    cantidadProductos: $scope.cantidadProductos,
                    numeroFacturaDeVenta: $scope.numeroFacturaDeVenta,
                    persona: $scope.persona_id
                };
                
                console.log(data);
                
                 $http.post('http://localhost:8080/s3_pear-web/api/facturas', data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('facturas', {}, {reload: true});
              });
           };
           
             $scope.eliminar_factura = function (id) {

                console.log(id + " < Se va a eliminar la factura");

                // DIRECCION HTTP 
                $http.delete('http://localhost:8080/s3_pear-web/api/facturas/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                    $state.reload();
                });
            };
            
             $scope.actualizar_factura = function () {
                console.log($scope.id_factura + " < Se va a actualizar la dieta.");

                let data = {
                    cantidadProductos: $scope.new_cantidadProductos,
                    numeroFacturaDeVenta: $scope.new_numeroFacturaDeVenta,
                    persona: $scope.new_persona
                };

                //http://localhost:8080/s3_pear-web/api/facturas/46
                $http.put('http://localhost:8080/s3_pear-web/api/facturas/' + $scope.id_dieta, data).then(function (response) {
                    $scope.put_data = response.data;
                    $state.go($state.current, {}, {reload: true});
                    $state.go('facturas', {}, {reload: true});
                });
            };
        }
    ]);
})(window.angular);


