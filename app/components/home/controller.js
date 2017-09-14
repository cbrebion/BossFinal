var app = angular.module("tpAngular");


app.controller("homeController", function($scope, Page) {
	Page.setTitle("Accueil");
});