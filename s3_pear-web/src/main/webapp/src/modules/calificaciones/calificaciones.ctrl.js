(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    
     mod.filter('range', function() {
        return function(input, total) {
          total = parseInt(total);
          for (var i=0; i<total; i++)
            input.push(i);
          return input;
        };
     });
    mod.controller('calificacionesCtrl', ['$scope', '$http', 'calificacionesContext', '$state',
        
        function ($scope, $http, calificacionesContext, $state) {
           
             
            $http.get(calificacionesContext).then(function (response) {
                $scope.calificacionesRecords = response.data;
            });
            
             if ($state.params.calificacionesId !== null && $state.params.calificacionesId !== undefined) {
                $scope.id_calificacion = $state.params.calificacionesId;
                
                $http.get(calificacionesContext + "/" +$state.params.calificacionesId ).then(function (response) {
                    $scope.calificacion = response.data;
                });
            }
        }
    ]);
}
)(window.angular);

