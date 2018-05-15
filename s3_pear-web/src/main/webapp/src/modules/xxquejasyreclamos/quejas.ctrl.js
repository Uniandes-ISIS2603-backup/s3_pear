(function (ng) {

    var mod = ng.module("quejasModule");
    mod.constant("quejasContext", "quejasyreclamos");
    mod.constant("dietasContext", "api/dietas");

    mod.filter('range', function() {
        return function(input, total) {
          total = parseInt(total);
          for (var i=0; i<total; i++)
            input.push(i);
          return input;
        };
     });
     
    mod.controller('quejasController', ['$scope', '$http', 'dietasContext', '$state', 'quejasContext',


        function ($scope, $http, dietasContext,  $state, quejasContext) {

            console.log($state.params.dietaId);
            $http.get(dietasContext + '/' + $state.params.dietaId + '/'+quejasContext).then(function (response) {

                $scope.quejasRecords = response.data;

            }).then(function (response) {
                response;
            });
            
            if ($state.params.quejasId !== null && $state.params.quejasId !== undefined) {
                $scope.id_queja = $state.params.quejasId;
                // TODO Descomentar
                $http.get(dietasContext + '/' + $state.params.idDieta + '/'+ quejasContext + "/" +$state.params.quejasId ).then(function (response) {
                    $scope.queja = response.data;
                    $scope.dietaId= $state.params.idDieta;
                });
            }

            $scope.enviar_queja = function () {

                let data = {
                    asunto: $scope.asunto,
                    comentario: $scope.comentario
                    
                };      
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
                $http.put(dietasContext + '/' + $state.params.dietaId+ '/'+ quejasContext + "/" + $scope.id_queja, data).then(function (response) {
                    $scope.put_data = response.data;
                    $state.go($state.current, {}, {reload: true});
                    $state.go('quejasList', {}, {reload: true});
                });
            };
        }

    ]);
})(window.angular);

