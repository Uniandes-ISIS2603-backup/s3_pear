(function (ng) {

    var mod = ng.module("loginModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/login");

            $stateProvider

                    .state('login', {
                        url: '/login',
                        data: {
                            requireLogin: false
                        },
                        views: {
                            'post': {
                                templateUrl: 'src/modules/personas/persona_add.html',
                                controller: 'loginController'
                            }
                        }
                    })

                    .state('logout', {
                        url: '/logout',
                        data: {
                            requireLogin: false,
                            roles: []
                        }
                        ,
                        views: {
                            'post': {
                                templateUrl: 'src/modules/login/logout.html',
                                controller: 'logoutController'
                            }
                        }
                    })
                    ;


        }]);

})(window.angular);

(function (ng) {

    var mod = ng.module("loginModule");

    mod.controller('loginController', ['$scope', '$http', '$state', '$rootScope',

        function ($scope, $http, $state, $rootScope) {

            $rootScope.user = false;
            $rootScope.admin = false;

            $rootScope.soyUser = function () {
                console.log('Soy User');
                $rootScope.user = true;
                $rootScope.admin = false;
                $state.go('dietas', {}, {reload: true});
            }
            
            $rootScope.soyAdmin = function () {
                console.log('Soy Admin');
                $rootScope.user = false;
                $rootScope.admin = true;
                $state.go('dietas', {}, {reload: true});
            }

        } // End Function Controller


    ]);
})(window.angular);



(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('logoutController', ['$rootScope', '$state',
     
     // TODO
     
        function ($rootScope, $state) {
           /* if (sessionStorage.getItem("username")) {
                sessionStorage.clear();
            } else {
                $state.go('booksList', {}, {reload: true});
            }
            */
        }
    ]);
}
)(window.angular);
