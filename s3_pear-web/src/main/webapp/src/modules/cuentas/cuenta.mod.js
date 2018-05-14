(function (ng) {

    var mod = ng.module("cuentaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/dietas");

            $stateProvider
                    .state('cuenta', {
                        url: "/cuenta",
                        templateUrl: "src/modules/cuentas/cuenta.html",
                        controller: 'cuentaController'
                    })

                    ;
        }]);

})(window.angular);





(function (ng) {

    var mod = ng.module("cuentaModule");

    mod.controller('cuentaController', ['$scope', '$http', '$state', '$rootScope',

        function ($scope, $http, $state, $rootScope) {


            if ($rootScope.persona !== undefined && $rootScope.persona !== null) {
                $http.get('http://localhost:8080/s3_pear-web/api/cuentascobro/' + $rootScope.persona.cuenta.id).then(function (response) {
                    $rootScope.cuenta_personal = response.data;
                });
            }

        }
    ]);
})(window.angular);
