(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagoContext", "api/pagos");
    mod.controller('pagoController', ['$scope', '$http', 'pagoContext','$state',
        
        function ($scope, $http, pagoContext, $state) {
            
            $scope.mostrar = function()
             {  
                return 'hola';
            
                        
                        
             if (($state.params.medioPagoId !== undefined)&& ($state.params.medioPagoId !== null)) {
           
                   
                $http.get("http://localhost:8080/s3_pear-web/api/mediopagos" + '/' + $state.params.medioPagoId).then(function (response) {
                    $scope.currentMedioDePago = response.data;
                });
            };
            };
            
             $http.get('http://localhost:8080/s3_pear-web/api/pagos').then(function (response) {
                 
                $scope.pagosRecords = response.data;
            });
            
            $http.get('http://localhost:8080/s3_pear-web/api/mediopagos').then(function (response) {
                $scope.medioPagoRecords = response.data;
            });     
            
            
            
        }
        
        
    ]);
}
        
        
        
        
)(window.angular);