angular.module('app', []).
 
  //definimos las rutas de la 'app'
  config(['$routeProvider', function($routes) {
 
  
  $routes.
  
      when('/productList', {
          templateUrl: 'src/views/productList.html',
          controller: ProductListController
          }).
         
      //cualquier ruta no definida
      otherwise({
          redirectTo: '/productList'});
 
}]);
