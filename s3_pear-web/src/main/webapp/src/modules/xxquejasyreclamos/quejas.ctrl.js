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
                console.log(response.data);

            }).then(function (response) {
                console.log('FAILED GET COMENTARIOS ' + response);
            });
            
            if ($state.params.quejasId !== null && $state.params.quejasId !== undefined) {
                $scope.id_queja = $state.params.quejasId;
                // TODO Descomentar
                $http.get(quejasContext + "/" +$state.params.quejasId ).then(function (response) {
                    $scope.queja = response.data;
                });
            }

            $scope.enviar_queja = function () {

                let data = {
                    asunto: $scope.asunto,
                    comentario: $scope.comentario
                    
                };

                console.log(data);

      
                $http.post(quejasContext, data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('quejasList', {}, {reload: true});
                });
            };
            $scope.actualizar_queja = function () {
              
                let data = {
                    asunto: $scope.newAsunto,
                    comentario: $scope.newComentario
                    
                };

               
                $http.put(quejasContext + "/" + $scope.id_queja, data).then(function (response) {
                    $scope.put_data = response.data;
                    $state.go($state.current, {}, {reload: true});
                    $state.go('quejasList', {}, {reload: true});
                });
            };
            



        }

    ]);
})(window.angular);

