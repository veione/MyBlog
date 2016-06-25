require.config({
	paths : {
		/* 可以定义数组先远程加载，加载不到再加载本地的 */
		"angular" : [ "http://cdn.bootcss.com/angular.js/1.5.7/angular.min",
				"../../base/js/angular.min" ],
		"jquery" : "../../base/js/jquery-2.2.4.min",
		"bootstrap" : "../../base/js/bootstrap.min",
		"bootstrapValidator" : "../../base/js/bootstrapValidator.min",
		"kkpager" : "../../base/js/kkpager.min",
		"html5" : "../../base/js/html5shiv",
		/* 本地加载自己的 */
		"blog" : "blog"
	},
	/* 定义依赖保证加载顺序 */
	shim : {
		'bootstrap' : [ 'jquery' ],
		'bootstrapValidator' : [ 'bootstrap' ],
		'kkpager' : [ 'jquery' ],
		'angular' : {
			exports : 'angular'
		},
		'blog' : [ 'angular' ]
	}
})
require([ "jquery", "angular", "bootstrap", "bootstrapValidator", "kkpager",
		"html5", "blog" ], function($, angular) {
	/* 初始化angular */
	angular.bootstrap(document, [ 'myApp' ]);
	/* 表单验证 */
	$(function() {
		$('#myForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				username : {
					message : '用户名必填',
					validators : {
						notEmpty : {
							message : '用户名不能为空'
						},
						stringLength : {
							min : 6,
							max : 30,
							message : '用户名在6到三十位之间'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9_\.]+$/,
							message : '用户名必须在字母数字和下划线之间'
						}
					}
				},
				password : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target);
			// Get the BootstrapValidator instance
			var bv = $form.data('bootstrapValidator');
			// Use Ajax to submit form data
			$.post($form.attr('action'), $form.serialize(), function(result) {
				console.log(result);
			}, 'json')
		});
	});
})