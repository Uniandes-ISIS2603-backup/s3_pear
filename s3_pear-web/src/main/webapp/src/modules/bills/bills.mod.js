(function (ng) {

    var mod = ng.module("billModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise("/facturas");

            $stateProvider
                    .state('bills', {
                        url: "/bills",
                        templateUrl: "src/modules/bills/bills.html",
                        controller: 'billsController'
                    })
                    
                    .state('detailBill', {
                        url: "/bills/:id/detail",
                        param: {
                            id: null
                        },
                        templateUrl: "src/modules/bills/bill_detail.html",
                        controller: 'billsController'
                    })
                    
                    .state('post_bill', {
                        url: '/bill/post',
                        views: {
                            'post': {
                                templateUrl: 'src/modules/bills/bill_add.html',
                                controller: 'billsController'
                            }
                        }
                    })
                    
                    .state('actualizar_bill', {
                        url: '/bills/:id/put',
                        param: {
                            id: null
                        },
                        templateUrl: "src/modules/bills/bill_update.html",
                        controller: 'billsController'
                    })
            
                    
            ;

        }]);
})(window.angular);


//Controlador
(function (ng) {

    var mod = ng.module("billModule");

    mod.constant("billsContext", "api/facturas");

    mod.controller('billsController', ['$scope', '$http', 'billsContext', '$state',

        function ($scope, $http, billsContext, $state) {
            
            //GET
            $http.get('http://localhost:8080/s3_pear-web/api/facturas').then(function (response) {
                $scope.bills = response.data;
            });
            
            //GET DETAIL
            if ($state.params.id !== null && $state.params.id !== undefined) {
                $scope.id_bill = $state.params.id;

                $http.get('http://localhost:8080/s3_pear-web/api/facturas/' + $state.params.id).then(function (response) {
                    $scope.bill = response.data;
                });
            }
            
            //POST
            $scope.post_bill = function () {
                const data = {
                    cantidadDeProductos: $scope.cantidadProductos,
                    numeroFactura: $scope.numeroFacturaDeVenta,
                    id: 0,
                    persona: {
                        id: $scope.persona
                    }
                };
                                
                $http.post(billsContext, data).then(function (response) {
                    $scope.post_data = response.data;
                    $state.go('bills', {}, {reload: true});
                });

            };
            
            //DELETE
            $scope.eliminar_bill= function (id) {
                $http.delete(billsContext + '/' + id).then(function (response) {
                    $scope.delete_data = response.data;
                    $state.reload();
                });
            };

            //PUT
            $scope.actualizar_bill = function () {

                const data = {
                    //Solo se pueden actualizar estas caracteristicas de una factura
                    cantidadProductos: $scope.new_cantidadProductos,
                    numeroFacturaDeVenta: $scope.new_numeroFacturaDeVenta
                };
                
                $http.put('http://localhost:8080/s3_pear-web/api/facturas/' + data.id, data).then(function (response) {
                    $scope.put_data = response.data;
                    $state.go('bills', {}, {reload: true});
                });
            };
        }
    ]);
})(window.angular);