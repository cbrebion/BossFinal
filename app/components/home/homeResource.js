app.factory('homeResource', ['$resource', 'API_URL', function($resource, API_URL) {

  return $resource(API_URL + '/home', null, {
  });
}]);
