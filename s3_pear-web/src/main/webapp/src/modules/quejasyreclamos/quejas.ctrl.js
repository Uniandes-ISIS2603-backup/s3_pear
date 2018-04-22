(function (ng) {

    var mod = ng.module("quejasModule");
    mod.constant("quejasContext", "api/quejasyreclamos");

    mod.filter('range', function() {
        return function(input, total) {
          total = parseInt(total);
          for (var i=0; i<total; i++)
            input.push(i);
          return input;
        };
     });
     
    mod.controller('quejasController', ['$scope', '$http', 'quejasContext', '$state',


        function ($scope, $http, quejasContext,  $state) {

            $http.get(quejasContext).then(function (response) {

                $scope.quejasRecords = response.data;

            }).then(function (response) {
                console.log('FAILED GET COMENTARIOS ' + response);
            });
            
            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_queja = $state.params.id;

                // TODO Descomentar
                $http.get(quejasContext + $state.params.id ).then(function (response) {
                    $scope.queja = response.data;
                });
            }

            $scope.enviar_comentario = function () {

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

