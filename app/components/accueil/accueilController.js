var app = angular.module("tpAngular");


app.controller("accueilController", function($scope, Page, accueilResource, userService) {
	Page.setTitle("Accueil");

$scope.username = userService.user.username;

});
