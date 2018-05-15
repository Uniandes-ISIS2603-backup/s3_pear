(function (ng) {

    var app = angular.module('main', [
        // External dependencies
        'ui.router',
        // Internal modules dependencies       
        'dietaModule',
        'cocinaModule',
        'pagoModule',
        'facturaModule',
        'billModule',
        'semanaModule',
        'diaModule',
        'personaModule',
        'comentarioModule',
        'calificacionModule',
        'comidaModule',
        'weekModule',
        'cuentaModule',
        'loginModule'
    ]);


    
    // Resuelve problemas de las promesas
    
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
    
    
    

    /* Hacer uso del bloque de run que nos permite ejecutar fragmentos de código al iniciar la aplicación.  */
//    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

//        $transitions.onSuccess({
//            to: '*'
//        }, function (trans) {
//
//            var $state = trans.router.stateService;
//            var requiereLogin = $state.current.data.requiereLogin;
//            var roles = $state.current.data.roles;
//
//
//            /**
//             * @ngdoc function
//             * @name isAuthenticated
//             * @methodOf main.module:main
//             * @description Esta función define si el usuario se encuentra
//             * dentro de su cuenta.
//             * @returns {Boolean} Verdadero si está dentro de su cuenta.
//             */
//            $rootScope.isAuthenticated = function () {
//
//                if (sessionStorage.getItem("username") != null) {
//                    $rootScope.currentUser = sessionStorage.getItem("name");
//                    return true;
//                } else {
//                    return false;
//                }
//                
//            };
//
//            /**
//             * @ngdoc function
//             * @name hasPermissions
//             * @methodOf main.module:main
//             * @description Esta función define si el usuario tiene permisos
//             * para acceder a la aplicación.
//             * @returns {Boolean} Verdadero si el usuario tiene permisos.
//             * 
//             * La variable roles es un arreglo con los roles permitidos para ese estado, y al obtener el rol del usuario
//             * verificamos que exista en ese arreglo.
//             */
//            $rootScope.hasPermissions = function () {
//                if (($rootScope.isAuthenticated) && (roles.indexOf(sessionStorage.getItem("rol")) > -1)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            };
//
//
//            if (requireLogin && (sessionStorage.getItem("username") === null)) {
//                event.preventDefault();
//                $state.go('login', $state.params);
//            }
//
//        }); /*END TRANSITIONS*/
//
//    }]);
//
//
//



})(window.angular);
