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
            $rootScope.admin = true;
            $rootScope.not_logged = false;
            $rootScope.incorrect = false;

            $rootScope.soyUser = function () {
                $rootScope.user = true;
                $rootScope.admin = false;
            };

            $rootScope.soyAdmin = function () {
                $rootScope.admin = true;
                $rootScope.user = false;
            };


            $http.get('src/modules/login/users.json').then(function (response) {
                $scope.usuarios = response.data;
            });


            /* El método $scope.autenticar nos ayudará a validar la información que tenemos desde el formulario contra nuestra colección de usuarios. */
            $scope.autenticar = function () {

                $scope.data = {
                    username: $scope.name,
                    password: $scope.pass,
                    rol: $rootScope.user ? 'user' : 'admin'
                }; /*para recoger cada uno de los valores ingresados en el formulario de login*/


                let auth_persona = function ( persona_id ) {
                    $http.get('http://localhost:8080/s3_pear-web/api/personas/' + persona_id ).then(function () {
                        $state.go('dietas', {}, {
                            reload: true
                        });
                    });
                };

                var flag = false;

                for (let item in $scope.usuarios) {

                    if (item !== null && item !== undefined) {
                        if ($scope.usuarios[item].user === $scope.data.username &&
                                $scope.usuarios[item].password === $scope.data.password &&
                                $scope.usuarios[item].rol === $scope.data.rol) {
                            
                            flag = true;

                            $rootScope.usuario = $scope.usuarios[item];

                            $rootScope.id_persona = $rootScope.usuario.id;

                            if ($rootScope.usuario.rol === 'user') {
                                auth_persona( $rootScope.id_persona );
                            } else {
                                $state.go('dietas', {}, {
                                    reload: true
                                });
                            };
                            break;
                        }
                    }
                } /*END FOR*/
                if (!flag) {
                    $rootScope.incorrect = true;

                    $rootScope.alerts.push({
                        type: "danger",
                        msg: "Incorrect username or password."
                    });
                } else {
                    /*Hacemos uso del sessionStorage para almacenar allí los valores del usuario*/
                    sessionStorage.token = $scope.usuario.token;
                    sessionStorage.setItem("username", $scope.usuario.user);
                    sessionStorage.setItem("name", $scope.usuario.name);
                    sessionStorage.setItem("rol", $scope.usuario.rol);
                    $rootScope.currentUser = $scope.usuario.name;
                }
            };
        } // End Function Controller
    ]);
})(window.angular);


/* LOGOUT CONTROLLER */

(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('logoutController', ['$rootScope', '$state',
        function ($rootScope, $state) {
            if (sessionStorage.getItem("username")) {
                sessionStorage.clear();
            } else {
                $state.go('login', {}, {reload: true});
            }
        }
    ]);
})(window.angular);
