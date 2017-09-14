app.factory('accueilResource', ['$resource', 'API_URL', function($resource, API_URL) {

  return $resource(API_URL + '/accueil', null, {
  });
}]);
