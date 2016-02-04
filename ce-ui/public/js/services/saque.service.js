(function() {

	'use strict';

	angular.module('ce-ui')
	    .factory('saqueService', ['$resource', function ($resource) {

	        return $resource('http://localhost:8081/saque/:params', {}, {});

	    }]);

})();