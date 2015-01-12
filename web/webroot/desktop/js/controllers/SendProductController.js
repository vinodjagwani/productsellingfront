'use strict';
foodMeApp.controller('SendProductController', function SendProductController(
		$scope, $http, sendproduct, $location, $upload, $window) {
	$scope.code = sendproduct.code;
	$scope.description = sendproduct.description;
	$scope.price = sendproduct.price;

	$scope.stores = [ {
		name : 'Germany',
		id : 'germany'
	}, {
		name : 'UK',
		id : 'uk'
	} ];
	$scope.availablestores = $scope.stores[0];

	// findRestaurants method definition
	$scope.findRestaurants = function(code, description, address, price) {
		sendproduct.code = code;
		sendproduct.description = description;
		sendproduct.address = address;
		sendproduct.priceOfProduct = price;

		/*
		 * var fd = new FormData(); fd.append('code', sendproduct.code);
		 * fd.append('name', sendproduct.code); fd.append('description',
		 * sendproduct.description); fd.append('address', sendproduct.address);
		 * fd.append('dateandtime',document.getElementById("productAvailable").value);
		 * fd.append('priceOfProduct', sendproduct.priceOfProduct);
		 * fd.append('picture', $scope.myFile); fd.append('storename',
		 * $scope.availablestores.id);
		 */
		
		var reader = new FileReader();
		reader.onloadend = function() {
		var text = reader.result;
		
		var iframe = document.createElement('iframe');
		$(iframe).css('display', 'none');
		$(iframe).attr('name', 'iframeTarget');

		$('body').append(iframe);
		$(this).attr('target', 'iframeTarget');

		var newForm = jQuery('<form>', {
			'action' : 'http://apparel-uk.local:8888',
			'target' : 'iframeTarget',
			'method' : 'POST',
			'enctype' : 'application/x-www-form-urlencoded'
		}).append(jQuery('<input>', {
			'id' : 'code',
			'name' : 'code',
			'value' : sendproduct.code,
			'type' : 'hidden'
		})).append(jQuery('<input>', {
			'id' : 'name',
			'name' : 'name',
			'value' : sendproduct.code,
			'type' : 'hidden'
		})).append(jQuery('<input>', {
			'id' : 'description',
			'name' : 'description',
			'value' : sendproduct.description,
			'type' : 'hidden'
		})).append(jQuery('<input>', {
			'id' : 'address',
			'name' : 'address',
			'value' : sendproduct.address,
			'type' : 'hidden'
		})).append(jQuery('<input>', {
			'id' : 'dateandtime',
			'name' : 'dateandtime',
			'value' : document.getElementById("productAvailable").value,
			'type' : 'hidden'
		})).append(jQuery('<input>', {
			'id' : 'priceOfProduct',
			'name' : 'priceOfProduct',
			'value' : sendproduct.priceOfProduct,
			'type' : 'hidden'
		})).append(jQuery('<input>', {
			'id' : 'picture',
			'name' : 'picture',
			'type' : 'hidden',
			'value' : text
		})).append(jQuery('<input>', {
			'id' : 'storename',
			'name' : 'storename',
			'value' : $scope.availablestores.id,
			'type' : 'hidden'
		}));
		console.log(text);
		newForm.submit();
		
		
		};
		
		reader.readAsDataURL(document.getElementById("imageFile").files[0]);

		

		$location.url('/');
	}

	$('.form_datetime').datetimepicker({
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1
	});

});

foodMeApp.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);