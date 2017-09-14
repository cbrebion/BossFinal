var app = angular.module("tpAngular");


app.controller("connexionController", function($scope, Page, userService, connexionResource, $location) {
	Page.setTitle("Se connecter");

	$scope.nom ="";
	$scope.prenom ="";
  $scope.code ="";

		$scope.connexion = function() {
				var candidat = {nom: this.nom, prenom: this.prenom, code: this.code};

				userService.user = logInResource.logIn(candidat);

				$location.path("accueil");

		}
});
