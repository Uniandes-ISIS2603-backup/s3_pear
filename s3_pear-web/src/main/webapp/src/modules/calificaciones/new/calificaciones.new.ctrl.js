(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "api/quejasyreclamos");
    mod.controller('calificacionNewCtrl', ['$scope', '$http', 'calificacionesContext', '$state', '$rootScope',
       
        function ($scope, $http, quejasContext, $state, $rootScope) {
            $rootScope.edit = false;

            $scope.data = {};

            /**
             * @ngdoc function
             * @name createEditorial
             * @methodOf authors.controller:authorNewCtrl
             * @description
             * Esta función utiliza el protocolo HTTP para crear el autor.
             * @param {Object} autor Objeto con el nuevo autor.
             */
            $scope.createCalificacion = function () {
                $http.post(calificacionesContext, $scope.data).then(function (response) {
                    $state.go('calificacionesList', {calificacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


