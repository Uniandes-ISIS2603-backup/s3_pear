(function (ng) {

    var mod = ng.module("cocinaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider
                    .state('cocinas', {
                        url: "/cocinas",
                        templateUrl: "src/modules/cocinas/cocina_list.html",
                        controller: 'cocinasController'
                    })

                    .state('cocina_detail', {
                        url: "/cocina/:id/detail",
                        param: {
                            id: null
                        },
                        views: {
                            'post': {
                                templateUrl: 'src/modules/cocinas/cocina_detail.html',
                                controller: 'cocinasController'
                            }
                        }
                    })

                    .state('cocina_update', {
                        url: "/cocina/:id/update",
                        param: {
                            id: null
                        },
                        views: {
                            'post': {
                                templateUrl: 'src/modules/cocinas/cocina_update.html',
                                controller: 'cocinasController'
                            }
                        }
                    })

                    .state('post_cocina', {
                        url: '/cocinas/post',
                        views: {
                            'post': {
                                templateUrl: "src/modules/cocinas/cocina_new.html",
                                controller: 'cocinasController'
                            }
                        }
                    })

                    ;

        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("cocinaModule");
    mod.constant("cocinasContext", "api/cocinas");

    mod.controller('cocinasController', ['$scope', '$http', 'cocinasContext', '$state',

        function ($scope, $http, cocinasContext, $state) {
            //http://localhost:8080/s3_pear-web/api/cocinas
            //src/modules/cocinas/cocinas.json
            $http.get('http://localhost:8080/s3_pear-web/api/cocinas').then(function (response) {
                $scope.cocinas = response.data;
                console.log($scope.cocinas);
            });


            $scope.enviar_cocina = function () {
                let data = {
                    capacidad: $scope.capacidad,
                    ubicacion: $scope.ubicacion,
                    imagen: $scope.imagen,
                    name: $scope.name
                };

                console.log(data);

                $http.post('http://localhost:8080/s3_pear-web/api/cocinas', data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('cocinas', {}, {reload: true});

                });
            };

            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_cocina = $state.params.id;

                $http.get('http://localhost:8080/s3_pear-web/api/cocinas/' + $state.params.id).then(function (response) {
                    $scope.cocina = response.data;
                });
            }
            ;


            $scope.eliminar_cocina = function (id) {
                console.log(id + ' < Se va a eliminar la cocina');

                $http.delete('http://localhost:8080/s3_pear-web/api/cocinas/' + id).then(function (response) {
                    $scope.post_data = response.data;
                    $state.reload();
                });
            };


            $scope.actualizar_cocina = function () {


                let data = {
                    name: $scope.new_nombre,
                    ubicacion: $scope.new_ubicacion,
                    capacidad: $scope.new_capacidad,
                    imagen: $scope.new_imagen
                };

                console.log($scope.id_cocina + " < Se va a actualizar la cocina.");
                console.log(cocina);

                $http.put('http://localhost:8080/s3_pear-web/api/cocinas/' + $scope.id_cocina, data).then(function (response) {
                    $scope.put_data = response.data;
                    $state.go($state.current, {}, {reload: true});
                    $state.go('cocinas', {}, {reload: true});
                });
            };

        }

    ]);
})(window.angular);
