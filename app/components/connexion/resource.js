app.factory('connexionResource', ['$resource', 'API_URL', function($resource, API_URL) {

  return $resource(API_URL + '/login', null, {

    "logIn": {method: 'POST'}

  });
}]);


// Service pour connaitre le candidatTest (pour avoir le code)
app.factory("candidatTestService", function() {
  this.candidatTest = {};

  this.create = function(candidatTest) {
    this.candidatTest = candidatTest;
  };
});
