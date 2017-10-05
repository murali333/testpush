var App = angular.module('myApp',['ngRoute','ngResource']);


 
App.config(['$routeProvider',
    function (
        $routeProvider
    ) {
          $routeProvider.
              when('/home', {
                  templateUrl: '/views/data.html',
                controller: 'UserController'
              }).
              when('/welcome', {
                 templateUrl: '/views/data2.html',
                controller: 'UserController2'
              }).
              otherwise({
                  redirectTo: '/home'
              });
}]);
App.config(['$httpProvider', function($httpProvider) {

        $httpProvider.defaults.useXDomain = true;

        delete $httpProvider.defaults.headers.common['X-Requested-With'];

    }

]);



App.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);
