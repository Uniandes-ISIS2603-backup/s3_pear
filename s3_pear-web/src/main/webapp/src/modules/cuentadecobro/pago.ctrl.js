(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("cuentaContext", "api/cuenta");
    mod.controller('pagoCtrl', ['$scope', '$http', 'cuentacobroContext',
        
        function ($scope, $http, pagoContext) {
            $http.get('data/mediospago.json').then(function (response) {
                $scope.cuentasRecordfs = response.data;
            });     
        }
    ]);
}
        
        
        
        
)(window.angular);