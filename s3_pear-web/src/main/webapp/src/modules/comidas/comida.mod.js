/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {

    var mod = ng.module("comidaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('comidas', {
                url: "/comidas",
                templateUrl: "src/modules/comidas/comida_list.html",
                controller: 'comidasController'
            })

            .state('detail_comida', {
                url: "/comida/:id/detail",
                param: {
                    id: null
                },
                templateUrl: "src/modules/comidas/comida.html",
                controller: 'comidasController'
            })

        ;
    }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("comidaModule");
    mod.constant("comidasContext", "api/comidas");
    
    mod.filter('range', function() {
        return function(input, total) {
          total = parseInt(total);
          for (var i=0; i<total; i++)
            input.push(i);
          return input;
        };
      });

    mod.controller('comidasController', ['$scope', '$http', 'comidasContext', '$state',

        function ($scope, $http, comidasContext, $state) {
            //http://localhost:8080/s3_pear-web/api/comidas
            // src/modules/comidas/comidas.json

            // TODO Descomentar
            $http.get('http://localhost:8080/s3_pear-web/api/comidas').then(function (response) {
                $scope.comidas = response.data;
            });

            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_comida = $state.params.id;

                // TODO Descomentar
                $http.get('http://localhost:8080/s3_pear-web/api/comidas/' + $state.params.id ).then(function (response) {
                    $scope.comida = response.data;
                });
            }

            $scope.enviar_comida = function () {

                let data = {
                    alimentos: $scope.alimentos,
                    cantidad: $scope.cantidad,
                    TIPO: $scope.TIPO,
                   // image: $scope.image
                };

                console.log(data);

                // DIRECCION HTTP 
                $http.post('http://localhost:8080/s3_pear-web/api/comidas', data).then(function (response) {
                    $scope.post_data = response.data;
                });
            };


            $scope.eliminar_comida = function (id) {

                console.log(id + " < Se va a eliminar la comida");

                // DIRECCION HTTP 
                $http.delete('http://localhost:8080/s3_pear-web/api/comidas/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                });
            };


            $scope.actualizar_comida = function () {
                console.log($scope.id_comida + " < Se va a actualizar la comida.");
                
                let data = {
                    alimentos: $scope.new_alimentos,
                    cantidad: $scope.new_cantidad,
                    TIPO: $scope.new_TIPO,
                   // image: $scope.new_image
                };
                
                //http://localhost:8080/s3_pear-web/api/comidas/3
                $http.put('http://localhost:8080/s3_pear-web/api/comidas/' + id, data).then(function (response) {
                    $scope.put_data = response.data;
                });
            };

        }

    ]);
})(window.angular);


