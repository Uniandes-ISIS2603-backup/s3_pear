(function (ng){
    
    var mod = ng.module("personaModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
        
        $urlRouterProvider.otherwise("/dietas");
        
        $stateProvider.state(
                    'personas', {
                                url:"/personas",
                                templateUrl:"src/modules/personas/personas.html",
                                controller: 'personasController'
                                });
        
    }]);
})(window.angular);


//Controlador
(function (ng) {
    
    var mod = ng.module("personaModule");
    
    mod.constant("personasContext", "api/personas");
    
    mod.controller('personasController', ['$scope', '$http', 'personasContext',
    
        function($scope, $http, personasContext) {
            //http://localhost:8080/s3_pear-web/api/dietas
            $http.get('src/modules/personas/personas.json').then(function (response) {
                $scope.dietas = response.data;
            });
        }    
    ]);
    
})(window.angular);