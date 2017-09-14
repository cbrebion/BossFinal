var app = angular.module("tpAngular");


app.config(function($routeProvider) {
	$routeProvider
		.when("/", {
			templateUrl: "./app/components/home/home.html",
			controller: "homeController"
		})
		.when("/accueil", {
	templateUrl: "./app/components/accueil/accueil.html",
	controller: "accueilController"
})
.when("/test", {
templateUrl: "./app/components/test/test.html",
controller: "testController"
});
});
