/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {

    var mod = ng.module("envioModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

      $urlRouterProvider.otherwise("/dietas");

            $stateProvider

                    .state('dieta_specs.envios', {
                        url: "/envios/dias/:id_dia",
                        param: {
                            id_dia: null
                        },
                        views: {
                            'dieta_spec': {
                                templateUrl: 'src/modules/envios/envio_list.html',
                                controller: 'comidaController'
                            }
                        }
                    })

            .state('envioDetail', {
                url: "/envio/:id/detail",
                param: {
                    id: null
                },
                templateUrl: "src/modules/envios/envio_detail.html",
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
            $http.get('http://localhost:8080/s3_pear-web/api/envios').then(function (response) {
                $scope.envios = response.data;
            });

            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_envio = $state.params.id;

                $http.get('http://localhost:8080/s3_pear-web/api/envios/' + $state.params.id ).then(function (response) {
                    $scope.envio = response.data;
                });
            };
            
            $scope.getDia_2 = function ( id_dia ) {
                
                $http.get('http://localhost:8080/s3_pear-web/api/dias/' + id_dia).then(function (response) {
                    $scope.dia = response.data;
                });
                
            };
            
            $scope.enviar_envio = function () {
                const data = {
                    direccion: $scope.direccion,
                    duracion: $scope.duracion,
                    recibido: $scope.recibido
                    
                };
                $http.post('http://localhost:8080/s3_pear-web/api/envios', data).then(function (response) {
                    $scope.post_data = response.data;
                });
            };


            $scope.eliminar_envio = function (id) {
                $http.delete('http://localhost:8080/s3_pear-web/api/envios/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                });
            };


            $scope.actualizar_envio = function () {                
                const data = {
                    direccion: $scope.new_direccion,
                    duracion: $scope.new_duracion,
                    recibido: $scope.new_recibido
                };
                $http.put('http://localhost:8080/s3_pear-web/api/envios/' + id, data).then(function (response) {
                    $scope.put_data = response.data;
                });
            };
        }
    ]);
})(window.angular);


