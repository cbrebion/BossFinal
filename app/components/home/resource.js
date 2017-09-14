app.factory('connexionResource', ['$resource', 'API_URL', function($resource, API_URL) {

  return $resource(API_URL + '/login', null, {

    "logIn": {method: 'POST'}

  });
}]);
