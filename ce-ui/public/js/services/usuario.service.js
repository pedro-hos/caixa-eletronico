(function() {

	'use strict';

	angular.module('ce-ui')
	    .factory('usuarioService', ['$resource', function ($resource) {

	        return $resource('http://localhost:8080/usuario/:params', {}, {});

	    }]);

})();