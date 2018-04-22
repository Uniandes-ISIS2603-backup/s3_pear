(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.controller('calificacionesCtrl', ['$scope', '$http', 'calificacionesContext', '$state',
        /**
         * @ngdoc controller
         * @name calificaciones.controller:quejasCtrl
         * @description
         * Definición del controlador de Angular del módulo calificaciones. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} calificacionesContext Constante injectada que contiene la ruta
         * donde se encuentra el API de calificaciones en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function ($scope, $http, calificacionesContext, $state) {
            /**
             * @ngdoc function
             * @name getCalificaciones
             * @methodOf calificaciones.controller:quejasCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentran las calificaciones en formato JSON. El recurso
             * puede ser un archivo o un API Rest. La función se ejecuta
             * automáticamente cuando el controlador es accedido desde el
             * navegador.
             * @param {String} URL Dirección donde se encuentra el recurso
             * de las quejas y reclmaos o API donde se puede consultar.
             */
            $http.get(calificacionesContext).then(function (response) {
                $scope.calificacionesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);

