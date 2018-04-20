(function (ng) {
    var mod = ng.module("quejasModule");
    mod.constant("sportContext", "api/quejasyreclamos");
    mod.controller('quejasDetailCtrl', ['$scope', '$http', 'quejasContext', '$state', '$filter',
        function ($scope, $http, quejasContext, $state, $filter) {

           if (($state.params. quejasId !== undefined) && ($state.params.quejasId !== null)) {
                $http.get('src/module/quejasyreclamos/quejas.json').then(function (response) {
                    $scope.quejasRecords = response.data;
                    $scope.currentQuejas = $filter('filter')($scope.quejasRecords, {id: $state.params.quejasId}, true)[0];
                }
                );
            }
        }
    ]);
}
)(window.angular);


