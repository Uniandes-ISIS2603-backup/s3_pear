(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagoContext", "api/pagos");
    mod.controller('pagoDetailController', ['$scope', '$http', 'pagoContext', '$state',
     
     
     
     
     
        function ($scope, $http, pagoContext, $state) {     
            if (($state.params.medioPagoId !== undefined)&& ($state.params.medioPagoId !== null)) {
           
             
                $http.get("http://localhost:8080/s3_pear-web/api/mediopagos" + '/' + $state.params.medioPagoId).then(function (response) {
                    $scope.currentMedioDePago = response.data;
                });
            }
        }
    ]);
}
)(window.angular);