'use strict';

foodMeApp.controller('NavbarController', function NavbarController($scope,
		$location, $http) {

	$scope.logout = function() {

		var url = 'http://' + $location.host() + ':' + $location.port()
				+ '/productsellingfront/login/logout';

		$.ajax({
			type : 'GET',
			url : url,
			success : function(data) {
				window.location.href = data;
			},
			error : function(error) {
				console.log(error);
			}
		});
	}

	$scope.routeIs = function(routeName) {
		return $location.path() === routeName;
	};

});
