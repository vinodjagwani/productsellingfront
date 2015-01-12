'use strict';

var foodMeApp = angular.module('foodMeApp', ['ngResource','ngRoute','angularFileUpload']);

foodMeApp.config(function($routeProvider) {
	
  $routeProvider
      .when('/', {controller: 'SendProductController',templateUrl: 'views/sendproduct.html'})
      .when('/sendproduct', {controller: 'SendProductController',templateUrl: 'views/sendproduct.html'});
  	
});
