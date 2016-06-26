// router.js

define(['angular', 'require', 'angular-route'], function (angular, require) {

    var blogApp = angular.module('blogApp',['ngRoute']);

    blogApp.config(['$routeProvider','$controllerProvider',
        function($routeProvider,$controllerProvider) {
            $routeProvider
            .when('/', {
                templateUrl:'static/views/home.html',
                controller: 'HomeCtrl',
                resolve:{
                    delay : ctrlRegister('HomeCtrl',['static/controllers/home-ctrl.js'])
                }
            })
            .when('/blog', {
                templateUrl:'static/views/blog.html',
                controller: 'BlogCtrl',
                resolve:{
                    delay : ctrlRegister('BlogCtrl',['static/controllers/blog-ctrl.js'])
                }
            })
            .otherwise({
                redirectTo: '/'
            });

            function ctrlRegister (ctrlName, ctrlModule) {
                return function ($q) {
                    var defer = $q.defer();
                    require(ctrlModule, function (controller) {

                        $controllerProvider.register(ctrlName, controller);

                        defer.resolve();
                    });
                    return defer.promise;
                }
            }
        }
    ]);

    return blogApp;
});