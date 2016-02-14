(function() {

	'use strict';

	angular.module('ce-ui')
	    .factory('caixaEletronicoService', ['$resource', function ($resource) {

	        return $resource('http://192.168.99.100:8080/caixa-eletronico/:params', {}, {});

	    }]);

})();