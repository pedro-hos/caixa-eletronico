(function() {

	'use strict';

	angular.module('ce-ui')
	    .factory('saqueService', ['$resource', function ($resource) {

	        return $resource('http://192.168.99.100:8081/saque/:params', {}, {
	        	sacar: {
	        		method: "GET",
	        		isArray: true
	        	}
	        });

	    }]);

})();