(function() {

    'use strict';

    angular
    	.module('ce-ui', ['ngResource', 'ngRoute'])
    	.config(function ($routeProvider) {
        	$routeProvider

	            .when('/', {
	                templateUrl: 'views/main.html',
	                controller: 'MainController'
	            })

	            .when('/usuario', {
	                templateUrl: 'views/usuario.html',
	                controller: 'UsuarioController'
	            })

	            .when('/caixa-eletronico', {
	                templateUrl: 'views/caixa-eletronico.html',
	                controller: 'CaixaEletronicoController'
	            })

	            .when('/saque', {
	                templateUrl: 'views/saque.html',
	                controller: 'SaqueController'
	            })

	            .otherwise({
	                redirectTo: '/'
	            });
    });

})();