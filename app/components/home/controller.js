var app = angular.module("tpAngular");


app.controller("homeController", function($scope, Page, connexionResource) {
	Page.setTitle("Accueil");

	$scope.nom ="";
	$scope.prenom ="";
  $scope.code ="";

	$scope.connexion = function() {
			var candidat = {nom: this.nom, prenom: this.prenom, code: this.code};

			userService.user = connexionResource.logIn(candidat);

			$location.path("accueil");

	}
});
