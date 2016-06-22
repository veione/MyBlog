angular.module("myApp", []).controller("myCtrl", function($scope, $http) {
	$scope.searchBlog = function() {
		$.ajax({
			method : 'POST',
			url : 'blog/getBlog',
			data : {
				info : $scope.info
			},
		}).success(function(data) {
			console.log(data)
			$scope.blogs = data.results;
		})
	};
	$scope.findByType = function(id) {
		$http({
			url : 'blog/articles/type/'+id+'?pageNum=1&pageSize=5',
			method : 'GET'
		}).success(function(data) {
			console.log(data)
			$scope.blogs = data.page.results;
			getPage(data.page, $scope, $http);
		}).error(function(data) {
			alert(data.msg)
		});
	};
	$http({
		url : 'blog/articles?pageNum=1&pageSize=5',
		method : 'GET'
	}).success(function(data) {
		console.log(data)
		$scope.blogs = data.page.results;
		getPage(data.page, $scope, $http);
	}).error(function(data) {
		alert(data.msg)
	});
	$http({
		url : 'blogTypes/all',
		method : 'GET'
	}).success(function(data) {
		console.log(data)
		$scope.types = data.results;
	}).error(function(data) {
		alert(data.msg)
	});
});