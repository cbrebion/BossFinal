app.factory('connexionResource', ['$resource', 'API_URL', function($resource, API_URL) {

  return $resource(API_URL + '/joueur/login', null, {

    "logIn": {method: 'POST'}

  });
}]);
