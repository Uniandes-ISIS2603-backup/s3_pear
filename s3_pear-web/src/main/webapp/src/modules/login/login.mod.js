(function (ng) {

    var mod = ng.module("loginModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/login");

        $stateProvider

            .state('login', {
                url: '/login',
                data: {
                    requiereLogin: false
                },
                views: {
                    'post': {
                        templateUrl: 'src/modules/login/login.html',
                        controller: 'loginController'
                    }
                }
            })

            .state('login_rol', {
                url: '/login/rol',
                data: {
                    requiereLogin: false
                },
                views: {
                    'post': {
                        templateUrl: 'src/modules/login/rol.html',
                        controller: 'loginController'
                    }
                }
            })

            .state('login_register', {
                url: '/login/register',
                data: {
                    requiereLogin: false
                },
                views: {
                    'post': {
                        templateUrl: 'src/modules/login/register.html',
                        controller: 'loginController'
                    }
                }
            })

            .state('login_sesion', {
                url: '/login/sesion',
                data: {
                    requiereLogin: false
                },
                views: {
                    'post': {
                        templateUrl: 'src/modules/login/login_login.html',
                        controller: 'loginController'
                    }
                }
            })

            .state('logout', {
                url: '/logout',
                data: {
                    requiereLogin: false,
                    roles: []
                },
                views: {
                    'post': {
                        templateUrl: 'src/modules/login/logout.html',
                        controller: 'logoutController'
                    }
                }
            });


        }]);

})(window.angular);



/* LOGIN CONTROLLER */

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
            }

            $rootScope.soyAdmin = function () {
                console.log('Soy Admin');
                $rootScope.user = false;
                $rootScope.admin = true;
            }


//            $scope.usuario = {}; /*para asignar los datos del usuario*/
//            $scope.data = {}; /*para recoger cada uno de los valores ingresados en el formulario de login*/
//
//            $http.get('src/modules/login/users.json').then(function (response) {
//                $scope.usuarios = response.data;
//            });
//
//
//            /* El método $scope.autenticar nos ayudará a validar la información que tenemos desde el formulario contra nuestra colección de usuarios. */
//            $scope.autenticar = function () {
//                var flag = false;
//                for (let item in $scope.usuarios) {
//                    if ($scope.usuarios[item].user == $scope.data.username &&
//                        $scope.usuarios[item].password == $scope.data.password &&
//                        $scope.usuarios[item].rol == $scope.data.rol) {
//                        flag = true;
//                        $scope.usuario = $scope.usuarios[item];
//                        $state.go('dietas', {}, {
//                            reload: true
//                        });
//                        break;
//                    }
//                }
//                if (!flag) {
//                    $rootScope.alerts.push({
//                        type: "danger",
//                        msg: "Incorrect username or password."
//                    });
//                } else {
//                    /*Hacemos uso del sessionStorage para almacenar allí los valores del usuario*/
//                    sessionStorage.token = $scope.usuario.token;
//                    sessionStorage.setItem("username", $scope.usuario.user);
//                    sessionStorage.setItem("name", $scope.usuario.name);
//                    sessionStorage.setItem("rol", $scope.usuario.rol);
//                    $rootScope.currentUser = $scope.usuario.name;
//                }
//            };

        } // End Function Controller


    ]);
})(window.angular);





/* LOGOUT CONTROLLER */

(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('logoutController', ['$rootScope', '$state',

     // TODO

        function ($rootScope, $state) {
           /* if (sessionStorage.getItem("username")) {
                 sessionStorage.clear();
             } else {
                // $state.go('dietas', {}, {reload: true});
             }
             */
        }
    ]);
})(window.angular);
