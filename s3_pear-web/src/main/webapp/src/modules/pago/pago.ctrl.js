(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagoContext", "api/pagos");
    mod.controller('pagoController', ['$scope', '$http', 'pagoContext','$state', '$filter', 
        
        function ($scope, $http, pagoContext, $state, $filter) {
            
            
           
           //Aca poner el parámetro
              $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro/' + 1).then(function (response) {
         
                $scope.cuentaActual = response.data;
            });
            
            $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro').then(function (response) {
         
                $scope.cuentaRecords = response.data;
            });
            
            
            $scope.get_cuentaid = function ()
            {
                     $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro/' + 1).then(function (response) {
         
                $scope.cuentaActual = response.data;
            });
            };
            
           $scope.post_medio = function () {

                let data = {
                    medioPagoActual: $scope.medioPagoAgregar
                };

                console.log(data);

                // DIRECCION HTTP 
                $http.post('http://localhost:8080/s3_pear-web/api/mediopagos', data).then(function (response) {
                 $state.go('pago', {}, {reload: true})   ;
                   
                });
            };
            
            
            $scope.delete_medio = function()
            {
                 if ($state.params.medioPagoId !== null && $state.params.medioPagoId !== undefined){
                     $http.delete('http://localhost:8080/s3_pear-web/api/mediopagos/' + $state.params.medioPagoId).then(function (response) {
                 $state.go('pago', {}, {reload: true});
                 });
                 }
                
            };
            
            
            
            $scope.mostrar_inicial = function()
            {  
                var retorno = '';
                
                if($scope.cuentaActual!== null && $scope.cuentaActual !== undefined)
                {
                    if($scope.cuentaActual.pago === undefined)
                    {
                       retorno =  "Pagar:  " + $scope.cuentaActual.valorAPagar/2 +  '.000 COP';
                    }else
                    {
                       retorno = "Pagado:" + $scope.cuentaActual.pago.montoInicial;
                        
                    }
              
                 
              }else{
                  retorno ='Algo salio mal. Haga clean and build'
              }
                 return retorno;
            };
            
             $scope.mostrar_final = function()
            {  
                var retorno = '';
                if($scope.cuentaActual!== null && $scope.cuentaActual !== undefined)
                {
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
              }else
              {
                  retorno = 'Algo salio mal. Haga clean and build';
              }
                
            };
            
            
            $scope.hacer_pago = function ()
            {
                
                if($scope.cuentaActual.pago === undefined)
                {
                    var mitad = $scope.cuentaActual/2; 
                    let data = 
                         {
                                montoInicial:mitad
                         };
                    
                    $http.post('http://localhost:8080/s3_pear-web/api/pagos', data).then(function (response) {
                 
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