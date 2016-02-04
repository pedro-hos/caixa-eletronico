(function() {

	'use strict';

	angular.module('ce-ui')
    	.controller('CaixaEletronicoController', function ($scope, caixaEletronicoService) {

    		$scope.numero_invalido = "Digite um número Válido";

			inicializa();

			function inicializa() {

				todos();
				$scope.caixa 		= new caixaEletronicoService();
    			$scope.caixas 		= [];
				$scope.mensagens 	= [];

				$scope.nota_cem 		= { nota:100, quantidade: 0 };
				$scope.nota_cinquenta	= { nota:50,  quantidade: 0 };
				$scope.nota_vinte		= { nota:20,  quantidade: 0 };
				$scope.nota_dez			= { nota:10,  quantidade: 0 };

				$scope.notas = [$scope.nota_cem, $scope.nota_cinquenta, $scope.nota_vinte, $scope.nota_dez];

			};
			
    		function todos() {

    			caixaEletronicoService.query(

    				function(caixas) {
						$scope.caixas = caixas;
    				}, 

    				function(erro) {
    					console.log(erro);
    				});
    		};

    		$scope.novo = function() {

    			$scope.caixa.notas = $scope.notas;
    			
    			console.log($scope.caixa);

    			$scope.caixa.$save()
	    			.then(function() {
	    				inicializa();
	    			})
	    			.catch(function(erro) {
	    				console.log(erro.data.fieldErrors);
	    				$scope.mensagens = erro.data.fieldErrors;
	    			});

    		};

    		$scope.changeNota = function() {

    			var notasCem 		= $scope.nota_cem.quantidade * $scope.nota_cem.nota;
    			var notasCinquenta 	= $scope.nota_cinquenta.quantidade * $scope.nota_cinquenta.nota;
				var notasCinquenta 	= $scope.nota_cinquenta.quantidade * $scope.nota_cinquenta.nota;
				var notasVinte 		= $scope.nota_vinte.quantidade * $scope.nota_vinte.nota;
				var notasDez		= $scope.nota_dez.quantidade * $scope.nota_dez.nota;

    			$scope.caixa.saldo = notasCem + notasCinquenta + notasVinte + notasDez;
    		};

    });

})();