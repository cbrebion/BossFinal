var app = angular.module("tpAngular");


app.controller("homeController", function($scope, Page, connexionResource, candidatTestService) {
	Page.setTitle("Accueil");

	$scope.candidatTest = {};

	// Clic sur connexion
	$scope.connexion = function() {
		console.log("DANS CLIC");
		$scope.candidatTest = connexionResource.logIn($scope.code, function() {
			console.log("DANS LOGIN");
			candidatTestService.create($scope.candidatTest);
			$location.path('/test');
		});
	};
});
