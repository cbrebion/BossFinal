var app = angular.module("tpAngular");


app.controller("testController", function($scope, Page, testResource) {

Page.setTitle("Liste des tests");
$scope.test = testResource.query();

});
