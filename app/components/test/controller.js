var app = angular.module("tpAngular");


app.controller("testController", function($scope, Page, testResource, reponseFactory, reponseResource, candidatTestService) {

  Page.setTitle("Test");

  $scope.proposition = {};

  candidatTestService.candidatTest.$promise.then(function() {
    $scope.candidatTest = candidatTestService.candidatTest;

    // Récupération des questionnaires du test
    var questionnaires = $scope.candidatTest.test.questionnaires;
    var questions = [];

    // Récupération de toutes les questions de tous les questionnaires
    for (var i = 0; i < questionnaires.length; i++) {
      if (questionnaires[i].questions.length != 0) {
        questions = questions.concat(questionnaires[i].questions);
      }
    }

    // Initialisation de l'index et de la question en cours
    $scope.index = 0;
    $scope.question = questions[$scope.index];

    $scope.suivant = function() {
      console.log($scope.proposition);
      // Sauvegarde de la réponse
      var reponse = {};
      reponse = reponseFactory.create($scope.proposition, $scope.candidatTest);
      console.log(reponse);
      reponseResource.add(reponse, function() {
        $scope.proposition = {};
      });


      // Passage à la question suivante
      $scope.index++;
      $scope.question = questions[$scope.index];
    }
  });


});
