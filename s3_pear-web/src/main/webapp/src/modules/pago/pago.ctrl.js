(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagoContext", "api/pagos");
    mod.controller('pagoController', ['$scope', '$http', 'pagoContext','$state', '$filter', 
        
        function ($scope, $http, pagoContext, $state, $filter) {
            
            
           
            
            $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro').then(function (response) {
         
                $scope.cuentaRecords = response.data;
            });
            
            
            //Aca poner el parámetro
              $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro/' + 1).then(function (response) {
         
                $scope.cuentaActual = response.data;
            });
            
            $scope.mostrar_inicial = function()
            {  
                var retorno = '';
                    if($scope.cuentaActual.pago === undefined)
                    {
                       retorno =  "Pagar:  " + $scope.cuentaActual.valorAPagar/2 +  '.000 COP';
                    }else
                    {
                       retorno = "Pagado:" + $scope.cuentaActual.pago.montoInicial;
                        
                    }
              
                  return retorno;
                    
                
            };
            
             $scope.mostrar_final = function()
            {  
                var retorno = '';
                    if($scope.cuentaActual.pago === undefined)
                    {
                       retorno =  "Pagar:  " + $scope.cuentaActual.valorAPagar/2 +  '.000 COP';
                    }else
                    {
                        if($scope.cuentaActual.pago.montoFinal!== undefined )
                        {
                            retorno = "Pagado:" + $scope.cuentaActual.pago.montoFinal;
                        }
                    }
              
                  return retorno;
                    
                
            };
            
            
            $scope.hacer_pago = function ()
            {
                
                if($scope.cuentaActual.pago === undefined)
                {
                    $http.get('http://localhost:8080/s3_pear-web/api/pagos').then(function (response) {
                 
                     $scope.pagosRecords = response.data;
            });
                    
                }
                
                
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