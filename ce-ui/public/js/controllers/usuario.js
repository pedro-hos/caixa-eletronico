(function() {

	'use strict';

	angular.module('ce-ui')
    	.controller('UsuarioController', function ($scope, usuarioService) {

    		$scope.usuario   = new usuarioService();
    		$scope.usuarios  = [];
    		$scope.mensagens = '';

    		todos();

    		function todos() {

    			usuarioService.query(

    				function(usuarios) {
						$scope.usuarios = usuarios;
    				}, 

    				function(erro) {
    					console.log(erro);
    				});
    		};

    		$scope.novo = function( ) {

    			$scope.usuario.$save()
	    			.then(function() {
	    				$scope.usuario  = new usuarioService();
	    				$scope.mensagens = '';
	    				todos();
	    			})
	    			.catch(function(erro) {
	    				console.log(erro.data.fieldErrors);
	    				$scope.mensagens = erro.data.fieldErrors;
	    			});

    		};

    });

})();