app.factory('connexionResource', ['$resource', 'API_URL', function($resource, API_URL) {

  return $resource(API_URL + '/connexion', null, {
    "logIn": {
      method: 'POST',
      params: {code: "="}
    }
  });
}]);

// Service pour connaitre le candidatTest (pour avoir le code)
app.service("candidatTestService", function() {
  this.candidatTest = {};

  this.create = function(candidatTest) {
    this.candidatTest = candidatTest;
  };
});
