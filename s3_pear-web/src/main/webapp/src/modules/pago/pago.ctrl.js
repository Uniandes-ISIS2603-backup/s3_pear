(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagoContext", "api/pagos");
    mod.controller('pagoCtrl', ['$scope', '$http', 'pagoContext',
        
        function ($scope, $http, pagoContext) {
            $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro').then(function (response) {
                $scope.cuentaRecords = response.data;
            });     
        }
    ]);
}
        
        
        
        
)(window.angular);