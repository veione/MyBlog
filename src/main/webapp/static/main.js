require.config({
	paths : {
		/* 可以定义数组先远程加载，加载不到再加载本地的 */
		'domReady' : 'base/js/domReady',
		"angular" : [ "http://cdn.bootcss.com/angular.js/1.5.7/angular.min",
				"base/js/angular_route" ],
		"angular-route" : [
				"http://cdn.bootcss.com/angular.js/1.5.7/angular-route.min",
				"base/js/angular-route.min" ],
		"uiRouter" : "base/js/angular-ui-route.min",
		"jquery" : "base/js/jquery-2.2.4.min",
		"bootstrap" : "base/js/bootstrap.min",
		"bootstrapValidator" : "base/js/bootstrapValidator.min",
		"kkpager" : "base/js/kkpager.min",
		"html5" : "base/js/html5shiv",
	},
	/* 定义依赖保证加载顺序,angularJs依赖于jquery是为了升级内部jqLite */
	shim : {
		'bootstrap' : [ 'jquery' ],
		'bootstrapValidator' : [ 'bootstrap' ],
		'kkpager' : {
			deps : [ 'jquery' ],
			exports : 'kkpager'
		},
		'angular' : {
			deps : [ 'jquery' ],
			exports : 'angular'
		},
		'angular-route' : {
			deps : [ 'angular' ],
			exports : 'ngRoute'
		}
	}
});
require([ 'angular', 'router' ], function(angular, router) {
	require([ 'domReady!' ], function() {
		angular.bootstrap(document, [ 'blogApp' ]);
	});
});
