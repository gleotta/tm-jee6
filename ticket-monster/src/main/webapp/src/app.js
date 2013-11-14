angular.module('app', []).
 
  //definimos las rutas de la 'app'
  config(['$routeProvider', function($routes) {
 
  
  $routes.
  
  	 
      when('/dashboard', {
          templateUrl: 'src/views/dashboard.html',
          controller: DashboardController
          }).
          
      when('/productList', {
          templateUrl: 'src/views/productList.html',
          controller: ProductListController
          }).
          
          
    
          
      //cualquier ruta no definida
      otherwise({
          redirectTo: '/dashboard'});
 
}]);
