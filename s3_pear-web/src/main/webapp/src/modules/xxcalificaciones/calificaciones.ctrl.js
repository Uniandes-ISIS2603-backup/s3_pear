(function (ng) {
    var mod = ng.module("calificacionesModule");  
    mod.constant("calificacionesContext", "calificaciones");
      mod.constant("dietasContext", "api/dietas");

    mod.filter('range', function () {
        return function (input, total) {
            total = parseInt(total);
            for (var i = 0; i < total; i++)
                input.push(i);
            return input;
        };
    });
    mod.controller('calificacionesCtrl', ['$scope', '$http', 'calificacionesContext', '$state', 'dietasContext',
        function ($scope, $http, calificacionesContext, $state, dietasContext) {

            var cero=0;
            var uno=0;
            var dos=0;
            var tres=0;
            var cuatro = 0;
            var cinco =0;
            var dieta=0;
            $http.get(dietasContext+ '/' + $state.params.dietaId + '/'+ calificacionesContext).then(function (response) {
                var a = response.data;
                var puntajeTotal=0;
                $scope.calificacionesRecords = response.data;
                
                for (var i = 0; i < a.length; i++) {
                    if (a[i].puntuacion === 0 || a[i].puntuacion === 1)
                        cero++;
                    if (a[i].puntuacion === 2 || a[i].puntuacion === 3)
                        uno++;
                    if (a[i].puntuacion === 4 || a[i].puntuacion === 5)
                        dos++;
                    if (a[i].puntuacion === 6 || a[i].puntuacion === 7)
                        tres++;
                    if (a[i].puntuacion === 8 || a[i].puntuacion === 9)
                        cuatro++;
                    if (a[i].puntuacion === 10)
                        cinco++;      
                    if(a[i].dieta.id === $state.params.dietaId)
                        dieta = a[i].dieta.id;

                    
                    
                    puntajeTotal+= a[i].puntuacion;
                }
                $scope.dieta_id= dieta;
                
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
               
                $http.get(dietasContext+ '/' + $state.params.idDieta + '/'+calificacionesContext + "/" + $state.params.calificacionesId).then(function (response) {
                    $scope.calificacion = response.data;
                });
            }
            $scope.enviar_calificacion = function () {

                let data = {
                    puntuacion: $scope.puntuacion
                    
                };  
                $http.post(calificacionesContext, data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('calificacionesList', {}, {reload: true});
                });
            };
            $scope.actualizar_calificacion = function () {
              
                let data = {
                    puntuacion: $scope.newPuntuacion    
                };

                dieta = 1;
                $http.put(dietasContext+ '/' + $state.params.idDieta + '/'+calificacionesContext + "/" + $scope.id_calificacion, data).then(function (response) {
                    
                    $scope.put_data = response.data;
                    $state.go($state.current, {}, {reload: true});
                    $state.go('calificacionesList({dietaId:dieta})', {}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

