(function (ng) {
    var mod = ng.module("quejasModule");
    mod.constant("quejasContext", "api/quejasyreclamos");
    mod.controller('quejasCtrl', ['$scope', '$http', 'quejasContext', '$state',
        /**
         * @ngdoc controller
         * @name quejas.controller:quejasCtrl
         * @description
         * Definición del controlador de Angular del módulo quejasyreclamos. 
         * Se crea el controlador con el cual se maneja el módulo.
         * En el controlador se definen los atributos y métodos que pueden
         * ser accedidos desde el HTML utilizando el $scope.
         * @param {Object} $scope Referencia injectada al Scope definida para este
         * controlador, el scope es el objeto que contiene las variables o 
         * funciones que se definen en este controlador y que son utilizadas 
         * desde el HTML.
         * @param {Object} $http Objeto injectado para la manejar consultas HTTP
         * @param {Object} quejasContext Constante injectada que contiene la ruta
         * donde se encuentra el API de quejas en el Backend.
         * @param {Object} $state Dependencia injectada en la que se recibe el 
         * estado actual de la navegación definida en el módulo.
         */
        function ($scope, $http, quejasContext, $state) {
            /**
             * @ngdoc function
             * @name getQuejasyReclamos
             * @methodOf quejas.controller:quejasCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para obtener el recurso 
             * donde se encuentran las quejas en formato JSON. El recurso
             * puede ser un archivo o un API Rest. La función se ejecuta
             * automáticamente cuando el controlador es accedido desde el
             * navegador.
             * @param {String} URL Dirección donde se encuentra el recurso
             * de las quejas y reclmaos o API donde se puede consultar.
             */
            $http.get('src/module/quejasyreclamos/quejas.json').then(function (response) {
                $scope.quejasRecords = response.data;
            });
        }
    ]);
}
)(window.angular);

