define(['angular',"bootstrap"], function (angular,$) {
    return function ListCtrl( $scope, $http ){
    	$scope.searchBlog = function() {
    		$.ajax({
    			method : 'POST',
    			url : 'blog/search',
    			data : {
    				info : $scope.info
    			},
    		}).success(function(data) {
    			$scope.$broadcast('getLucenBlogs', data);
    		})
    	};
    };
});