(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagoContext", "api/pagos");
    mod.controller('pagoController', ['$scope', '$http', 'pagoContext','$state', '$filter', 
        
        function ($scope, $http, pagoContext, $state, $filter) {
            
           
           
           //Aca poner el parámetro
              $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro/' + 1).then(function (response) {
         
                $scope.cuentaActual = response.data;
            });
            
             
            
            
            
              $http.get('http://localhost:8080/s3_pear-web/api/mediopagos').then(function (response) {
                $scope.medioPagoRecords = response.data;
                
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

                console.log(data.medioPagoActual);

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
                
                if($scope.cuentaActual.pago === undefined || $scope.cuentaActual.pago === null )
                {
               
                     var mitad = $scope.cuentaActual.valorAPagar/2; 
                     let data = 
                         {
                                montoInicial:mitad,
                                montoFinal: 0
                         };
                         
                    
                     $http.post('http://localhost:8080/s3_pear-web/api/pagos/cuenta/' + $scope.cuentaActual.id, data).then(function (response) {
                         $scope.pagoActual = response.data;
                     console.log($scope.pagoActual.id);
                     });
                     
                    
                
                }else if ($scope.cuentaActual.pago.montoFinal === 0 ||$scope.cuentaActual.pago.montoFinal === undefined) 
                {
                    
                    $scope.pagoActual = $scope.cuentaActual.pago;
                    
                    let data = 
                          {
                                montoInicial: $scope.pagoActual.montoInicial, 
                                montoFinal : $scope.pagoActual.montoInicial
                          }; 
                    
                    $http.put('http://localhost:8080/s3_pear-web/api/pagos/' + $scope.pagoActual.id, data).then(function (response) {
                 
                     console.log($scope.pagoActual.id);
                     });
                     
                     
                    
                }
                
                 $state.go('pago', {}, {reload: true});
            }; 
            
        function postPago()
        {
             var mitad = $scope.cuentaActual.valorAPagar/2; 
                    let data = 
                         {
                                montoInicial:mitad,
                                montoFinal: 0
                         };
                         
            $http.post('http://localhost:8080/s3_pear-web/api/pagos', data).then(function (response) {
                 
                        $scope.pagoActual = response.data;
                        
                     });
        }
        
        
        
        } 
    ]);
}
       
        
        
)(window.angular);