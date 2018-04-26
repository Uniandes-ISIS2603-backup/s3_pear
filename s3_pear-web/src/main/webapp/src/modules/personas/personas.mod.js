(function (ng) {

    var mod = ng.module("personaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider
                    .state('personas', {
                        url: "/personas",
                        templateUrl: "src/modules/personas/personas.html",
                        controller: 'personasController'
                    });

        }]);
})(window.angular);


//Controlador
(function (ng) {

    var mod = ng.module("personaModule");

    mod.constant("personasContext", "api/personas");

    mod.controller('personasController', ['$scope', '$http', 'personasContext',

        function ($scope, $http, personasContext) {

            //personasContext
            $http.get('src/modules/personas/personas.json').then(function (response) {
                $scope.personas = response.data;
            });



            $scope.post_persona = function () {
                
                let data = {
                    nombre: $scope.nombre,
                    apellido: $scope.apellido,
                    edad: $scope.edad,
                    direccion: $scope.direccion,
                    correo: $scope.correo,
                    subscrito: true
                };
                
                console.log('Se va a crear la siguiente persona');
                console.log(data);
                
                $http.post(personasContext, data).then(function (response) {
                    $scope.post_data = response.data;
                });

            };
            
            
            $scope.eliminar_persona = function (id) {
                $http.delete(personasContext + '/' + id,).then(function (response) {
                    $scope.delete_data = response.data;
                });
            };




        }

    ]);

})(window.angular);