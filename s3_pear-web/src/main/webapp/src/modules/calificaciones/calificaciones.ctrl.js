(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "api/calificaciones");

    mod.filter('range', function () {
        return function (input, total) {
            total = parseInt(total);
            for (var i = 0; i < total; i++)
                input.push(i);
            return input;
        };
    });
    mod.controller('calificacionesCtrl', ['$scope', '$http', 'calificacionesContext', '$state',

        function ($scope, $http, calificacionesContext, $state) {

            var cero=0;
            var uno=0;
            var dos=0;
            var tres=0;
            var cuatro = 0;
            var cinco =0;
            $http.get(calificacionesContext).then(function (response) {
                var a = response.data;
                var puntajeTotal=0;
                $scope.calificacionesRecords = response.data;
                

                for (var i = 0; i < a.length; i++) {
                    if (a[i].puntuacion == 0 || a[i].puntuacion == 1) {
                        cero++;
                    }
                    if (a[i].puntuacion == 2 || a[i].puntuacion == 3) {
                        uno++;
                    }
                    if (a[i].puntuacion == 4 || a[i].puntuacion == 5) {
                        dos++;
                    }
                    if (a[i].puntuacion == 6 || a[i].puntuacion == 7) {
                        tres++;
                    }
                    if (a[i].puntuacion == 8 || a[i].puntuacion == 9) {
                        cuatro++;
                    }
                    if (a[i].puntuacion == 10) {
                        cinco++;
                    }
                    puntajeTotal+= a[i].puntuacion;
                }
                var total = uno+ dos+ tres + cuatro + cinco + cero;
                $scope.calificacionCero=cero;
                $scope.calificacionUno=uno;
                $scope.calificacionDos=dos;
                $scope.calificacionTres=tres;
                $scope.calificacionCuatro = cuatro;
                $scope.calificacionCinco=cinco;
                $scope.porcentajeCero= (cero*100)/total;
                $scope.porcentajeUno= (uno*100)/total;
                $scope.porcentajeDos= (dos*100)/total;
                $scope.porcentajeTres= (tres*100)/total;
                $scope.porcentajeCuatro= (cuatro*100)/total;
                $scope.porcentajeCinco= (cinco*100)/total;
                $scope.promedio= puntajeTotal/a.length;
                

            });

            if ($state.params.calificacionesId !== null && $state.params.calificacionesId !== undefined) {
                $scope.id_calificacion = $state.params.calificacionesId;

                $http.get(calificacionesContext + "/" + $state.params.calificacionesId).then(function (response) {
                    $scope.calificacion = response.data;
                });
            }





        }
    ]);
}
)(window.angular);

