(function() {

	'use strict';

	angular.module('ce-ui')
	    .factory('caixaEletronicoService', ['$resource', function ($resource) {

	        return $resource('http://localhost:8080/caixa-eletronico/:params', {}, {});

	    }]);

})();