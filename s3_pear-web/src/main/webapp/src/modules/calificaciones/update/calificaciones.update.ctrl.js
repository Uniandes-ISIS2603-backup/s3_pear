(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.controller('calificacionUpdateCtrl', ['$scope', '$http', 'calificacionesContext', '$state', '$rootScope',
        
        function ($scope, $http, calificacionesContext, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.data = {};

            $scope.selectedItems = [];

            $scope.availableItems = [];

            var idCalificacion = $state.params.calificacionId;

            //Consulto el autor a editar.
            $http.get(calificacionesContext + '/' + idCalificacion).then(function (response) {
                var calificacion = response.data;
                $scope.data.puntaje = calificacion.puntaje;
            });

            

            /**
             * @ngdoc function
             * @name createAuthor
             * @methodOf authors.controller:authorUpdateCtrl
             * @description
             * Crea un nuevo autor con los libros nuevos y la información del
             * $scope.
             */
            $scope.createCalificacion = function () {
                $http.put(calificacionContext + "/" + idCalificacion, $scope.data).then(function (response) {
                    if ($scope.selectedItems.length >= 0) {
                        $http.put(calificacionesContext + "/" + response.data.id , $scope.selectedItems).then(function (response) {
                        });
                    }
                   
                    $state.go('calificacionesList', {calificacionId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);