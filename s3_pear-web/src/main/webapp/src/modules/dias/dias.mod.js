(function (ng) {

    var mod = ng.module("diaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dias");

            $stateProvider
                    .state('dias', {
                        url: "/dias",
                        templateUrl: "src/modules/dias/dia.html",
                        controller: 'diasController'
                    })

                    .state('detailDia', {
                        url: "/dia/:id/detail",
                        param: {
                            id: null
                        },
                        templateUrl: "src/modules/dias/dia_detail.html",
                        controller: 'diasController'
                    })

                    .state('post_dia', {
                        url: '/dias/post',
                        views: {
                            'post': {
                                templateUrl: 'src/modules/dias/dia_new.html',
                                controller: 'diasController'
                            }
                        }
                    }).state('actualizar_dia', {
                        url: '/dias/:id/put',
                        param: {
                            id: null
                        },
                        templateUrl: "src/modules/dias/dia_update.html",
                        controller: 'diasController'
                    })

                    ;
        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("diaModule");
    mod.constant("diasContext", "api/dias");

    mod.filter('range', function () {
        return function (input, total) {
            total = parseInt(total);
            for (var i = 0; i < total; i++)
                input.push(i);
            return input;
        };
    });

    mod.controller('diasController', ['$scope', '$http', 'diasContext', '$state',

        function ($scope, $http, diasContext, $state) {
      

            $http.get('http://localhost:8080/s3_pear-web/api/dias').then(function (response) {
                $scope.dias = response.data;
            });

            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_dia = $state.params.id;

                $http.get('http://localhost:8080/s3_pear-web/api/dias/' + $state.params.id).then(function (response) {
                    $scope.dia = response.data;
                });
            }

            $scope.post_dia = function () {

                let data = {
                    fecha: $scope.fecha,
                    recomendacion: $scope.recomendacion,
                    seEnvia: $scope.seEnvia,
                    semana: $scope.semana
                };
                $http.post('http://localhost:8080/s3_pear-web/api/dias', data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('dias', {}, {reload: true});
                });
            };


            $scope.eliminar_dia = function (id) {
                $http.delete('http://localhost:8080/s3_pear-web/api/dias/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                    $state.reload();
                });
            };


            $scope.actualizar_dia = function () {
                let data = {
                    recomendacion: $scope.new_recomendacion,
                    seEnvia: $scope.new_seEnvia
                };
                $http.put('http://localhost:8080/s3_pear-web/api/dias/' + $scope.id_dia, data).then(function (response) {
                    $scope.put_data = response.data;
                    $state.go($state.current, {}, {reload: true});
                    $state.go('dias', {}, {reload: true});
                });
            };
        }
    ]);
})(window.angular);


