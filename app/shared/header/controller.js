var app = angular.module("tpAngular");

app.controller("headerController", function($scope, Page) {
	$scope.Page = Page;
});