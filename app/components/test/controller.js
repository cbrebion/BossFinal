var app = angular.module("tpAngular");


app.controller("testController", function($scope, $location, Page, testResource, reponseFactory, reponseResource, candidatTestService) {

  Page.setTitle("Test");

  $scope.proposition = {};
  $scope.showFinish = false;
  $scope.showNext = true;

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

      // Sauvegarde de la réponse
      var reponse = {};
      reponse = reponseFactory.create($scope.proposition, $scope.candidatTest);

      // Enregistrement de la réponse
      reponseResource.add(reponse, function() {
        $scope.proposition = {};
      });


      // Passage à la question suivante
      $scope.index++;
      if ($scope.index == questions.length - 1) {
        $scope.showFinish = true;
        $scope.showNext = false;
      }
      $scope.question = questions[$scope.index];
    }


    $scope.terminer = function() {
      // Sauvegarde de la dernière réponse
      var reponse = {};
      reponse = reponseFactory.create($scope.proposition, $scope.candidatTest);

      // Enregistrement de la réponse
      reponseResource.add(reponse, function() {
        $scope.proposition = {};
      });

      $location.path("/remerciements");
    };
  });


});
