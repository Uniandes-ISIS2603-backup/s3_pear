/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {

    var mod = ng.module("envioModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/envios");

        $stateProvider
            .state('envios', {
                url: "/envios",
                templateUrl: "src/modules/envios/envios.html",
                controller: 'enviosController'
            })

            .state('detail', {
                url: "/envio/:id/detail",
                param: {
                    id: null
                },
                templateUrl: "src/modules/envios/envio.html",
                controller: 'enviosController'
            })

        ;
    }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("envioModule");
    mod.constant("enviosContext", "api/envios");
    
    mod.filter('range', function() {
        return function(input, total) {
          total = parseInt(total);
          for (var i=0; i<total; i++)
            input.push(i);
          return input;
        };
      });

    mod.controller('enviosController', ['$scope', '$http', 'enviosContext', '$state',

        function ($scope, $http, enviosContext, $state) {
            //http://localhost:8080/s3_pear-web/api/envios
            // src/modules/envios/envios.json

            // TODO Descomentar
            $http.get('http://localhost:8080/s3_pear-web/api/envios').then(function (response) {
                $scope.envios = response.data;
            });

            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_envio = $state.params.id;

                // TODO Descomentar
                $http.get('http://localhost:8080/s3_pear-web/api/envios/' + $state.params.id ).then(function (response) {
                    $scope.envio = response.data;
                });
            }

            $scope.enviar_envio = function () {

                let data = {
                    direccion: $scope.direccion,
                    duracion: $scope.duracion,
                    recibido: $scope.recibido
                    
                };

                console.log(data);

                // DIRECCION HTTP 
                $http.post('http://localhost:8080/s3_pear-web/api/envios', data).then(function (response) {
                    $scope.post_data = response.data;
                });
            };


            $scope.eliminar_envio = function (id) {

                console.log(id + " < Se va a eliminar la envio");

                // DIRECCION HTTP 
                $http.delete('http://localhost:8080/s3_pear-web/api/envios/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                });
            };


            $scope.actualizar_envio = function () {
                console.log($scope.id_envio + " < Se va a actualizar la envio.");
                
                let data = {
                    direccion: $scope.new_direccion,
                    duracion: $scope.new_duracion,
                    recibido: $scope.new_recibido
                };
                
                //http://localhost:8080/s3_pear-web/api/envios/3
                $http.put('http://localhost:8080/s3_pear-web/api/envios/' + id, data).then(function (response) {
                    $scope.put_data = response.data;
                });
            };

        }

    ]);
})(window.angular);


