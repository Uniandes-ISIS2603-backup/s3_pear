(function (ng) {
    var mod = ng.module("pagoModule");
    mod.constant("pagoContext", "api/pagos");
    mod.controller('pagoController', ['$scope', '$http', 'pagoContext','$state', 
        
        function ($scope, $http, pagoContext, $state) {
            
      } 
    ]);
}  
)(window.angular);