app.factory("reponseResource", function($resource, API_URL) {
  return $resource(API_URL + '/reponse', null, {
    'add': { method: 'PUT' }
  });
});

app.factory("reponseFactory", function() {
  function Reponse(proposition, candidatTest) {
    this.proposition = proposition;
    this.candidatTest = candidatTest;
  };

  return {
    create: function(proposition, candidatTest) {
      return new Reponse(proposition, candidatTest);
    }
  };
});
