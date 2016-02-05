(function() {

	'use strict';

	angular.module('ce-ui')
    	.controller('SaqueController', function ($scope, saqueService, caixaEletronicoService, usuarioService) {

    		$scope.saque = new saqueService();

    		$scope.usuarios  = [];
    		$scope.caixas 	 = [];
    		$scope.notas 	 = '';

    		$scope.numero_invalido = "Digite um número Válido";

    		todosUsuariosECaixas();

    		function todosUsuariosECaixas() {

    			usuarioService.query(

    				function(usuarios) {
    					angular.forEach(usuarios, function(value, key){
    						$scope.usuarios.push(value.nome);
    					});
    				}, 

    				function(erro) {
    					console.log(erro);
    				});

    			caixaEletronicoService.query(

    				function(caixas) {
						angular.forEach(caixas, function(value, key){
    						$scope.caixas.push(value.nome);
    					});
    				}, 

    				function(erro) {
    					console.log(erro);
    				});

    		};

    		$scope.sacar = function() {

    			$scope.saque.$save()
	    			.then(function(notas) {
	    				$scope.notas = notas;
	    				$scope.saque.valor = '';
	    			})
	    			.catch(function(erro) {
	    				console.log(erro.data.fieldErrors);
	    				$scope.mensagens = erro.data.fieldErrors;
	    			});
    		};

    });

})();