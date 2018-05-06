(function (ng) {

    var mod = ng.module("dietaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/dietas");

        $stateProvider
            .state('dietas', {
                url: "/dietas",
                templateUrl: "src/modules/dietas/dietas.html",
                controller: 'dietasController'
            })

            .state('dieta_update', {
                url: "/dieta/:id/update",
                param: {
                    id: null
                },
                views: {
                    'post': {
                        templateUrl: 'src/modules/dietas/dieta_update.html',
                        controller: 'dietasController'
                    }
                }
                //            ,
                //                data: {
                //                    requiereLogin: true,
                //                    roles: ['admin', 'user']
                //                }
            })

            .state('dieta_specs', {
                url: "/dieta/:id/specs",
                param: {
                    id: null
                },
                views: {
                    'post': {
                        templateUrl: 'src/modules/dietas/dieta_specs.html',
                        controller: 'dietasController'
                    }
                }
                //            ,
                //                data: {
                //                    requiereLogin: true,
                //                    roles: ['admin', 'user']
                //                }
            })
            
            .state('dieta_specs.dieta_specs_id', {
                url: "/dieta/:id/specs/detail",
                param: {
                    id: null
                },
                views: {
                    'dieta_spec': {
                        templateUrl: 'src/modules/dietas/dieta_detail.html',
                        controller: 'dietasController'
                    }
                }
                //            ,
                //                data: {
                //                    requiereLogin: true,
                //                    roles: ['admin', 'user']
                //                }
            })

            .state('post_dieta', {
                url: '/dietas/post',
                views: {
                    'post': {
                        templateUrl: 'src/modules/dietas/dieta_new.html',
                        controller: 'dietasController'
                    }
                }
                //            ,
                //                data: {
                //                    requiereLogin: true,
                //                    roles: ['admin']
                //                }
            })

        ;
        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("dietaModule");
    mod.constant("dietasContext", "api/dietas");

    mod.filter('range', function () {
        return function (input, total) {
            total = parseInt(total);
            for (var i = 0; i < total; i++)
                input.push(i);
            return input;
        };
    });

    mod.controller('dietasController', ['$scope', '$http', 'dietasContext', '$state', '$rootScope',

        function ($scope, $http, dietasContext, $state, $rootScope) {
            //http://localhost:8080/s3_pear-web/api/dietas
            // src/modules/dietas/dietas.json

            $http.get('http://localhost:8080/s3_pear-web/api/dietas').then(function (response) {
                $scope.dietas = response.data;
            });

            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_dieta = $state.params.id;

                $http.get('http://localhost:8080/s3_pear-web/api/dietas/' + $state.params.id).then(function (response) {
                    $scope.dieta = response.data;
                });
            }

            $scope.enviar_dieta = function () {

                let data = {
                    name: $scope.nombre,
                    descripcion: $scope.descripcion,
                    objetivo: $scope.objetivo,
                    imagen: ($scope.imagen === null || $scope.imagen === undefined ) ? 'https://images.pexels.com/photos/5317/food-salad-restaurant-person.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940' : $scope.imagen,
                    stars: $scope.stars
                };

                console.log(data);

                // DIRECCION HTTP 
                $http.post('http://localhost:8080/s3_pear-web/api/dietas', data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('dietas', {}, {
                        reload: true
                    });
                });
            };


            $scope.eliminar_dieta = function (id) {

                console.log(id + " < Se va a eliminar la dieta");

                // DIRECCION HTTP 
                $http.delete('http://localhost:8080/s3_pear-web/api/dietas/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                    $state.reload();
                });
            };


            $scope.actualizar_dieta = function () {
                console.log($scope.id_dieta + " < Se va a actualizar la dieta.");

                let data = {};
                
                if ( $scope.new_nombre !== undefined || $scope.new_nombre !== null )
                    data.name = $scope.new_nombre;
                
                if ( $scope.new_descripcion !== undefined || $scope.new_descripcion !== null )
                    data.descripcion = $scope.new_descripcion;
                
                if ( $scope.new_objetivo !== undefined || $scope.new_objetivo !== null )
                    data.objetivo = $scope.new_objetivo;
                
                if ( $scope.new_stars !== undefined || $scope.new_stars !== null )
                    data.stars = $scope.new_stars;
                
                if ( $scope.new_imagen !== undefined || $scope.new_imagen !== null )
                    data.imagen = $scope.new_imagen;
                

                console.log(data);

                //http://localhost:8080/s3_pear-web/api/dietas/3
//                $http.put('http://localhost:8080/s3_pear-web/api/dietas/' + $scope.id_dieta, data).then(function (response) {
//                    $scope.put_data = response.data;
//                    $state.go($state.current, {}, {
//                        reload: true
//                    });
//                    $state.go('dietas', {}, {
//                        reload: true
//                    });
//                });
            };
        }
    ]);
})(window.angular);
