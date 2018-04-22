(function (ng) {
    var mod = ng.module("quejasModule");
    mod.constant("quejasContext", "api/quejasyreclamos");
    mod.controller('quejaNewCtrl', ['$scope', '$http', 'quejasContext', '$state', '$rootScope',
       
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
            $scope.createQueja = function () {
                $http.post(quejasContext, $scope.data).then(function (response) {
                    $state.go('quejasList', {quejaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


