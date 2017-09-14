var app = angular.module("tpAngular");


app.controller("connexionController", function($scope, Page, connexionResource, $location, candidatTestService) {
	Page.setTitle("Se connecter");

	$scope.candidatTest = {};

	// Clic sur connexion
	$scope.connexion = function() {
		$scope.candidatTest = connexionResource.logIn($scope.code, function() {
			candidatTestService.create($scope.candidatTest);
			$location.path('/test');
		});
	};
});
