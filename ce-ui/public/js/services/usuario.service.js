(function() {

	'use strict';

	angular.module('ce-ui')
	    .factory('usuarioService', ['$resource', function ($resource) {

	        return $resource('http://192.168.99.100:8080/usuario/:params', {}, {});

	    }]);

})();