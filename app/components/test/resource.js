app.factory('testResource', ['$resource', 'API_URL', function($resource, API_URL) {

  return $resource(API_URL + '/candidattest');
}]);
