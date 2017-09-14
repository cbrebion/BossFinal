var app = angular.module("tpAngular");


app.controller("testController", function($scope, Page, testResource, candidatTestService) {

  Page.setTitle("Liste des tests");

  $scope.toto = candidatTestService.candidatTest;
  //$scope.test = testResource.getFromCode({code:$scope.code});

});
