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
     
    mod.controller('calificacionesController', ['$scope', '$http', 'calificacionesContext', '$state',


        function ($scope, $http, calificacionesContext,  $state) {

            $http.get(calificacionesContext).then(function (response) {

                $scope.calificacionesRecords = response.data;

            }).then(function (response) {
                console.log('FAILED GET COMENTARIOS ' + response);
            });
            
            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_calificacion = $state.params.id;
                // TODO Descomentar
                $http.get(calificacionesContext + $state.params.id ).then(function (response) {
                    $scope.queja = response.data;
                });
            }

            $scope.enviar_calificacion = function () {

                let data = {
                    
                };

                console.log(data);

                


                // DIRECCION HTTP 
                /*$http.post(' DIRECCION HTTP DE POSTMAN', data).then(function (response) {
                    $scope.post_data = response.data;
                });*/
            }



        }

    ]);
})(window.angular);

