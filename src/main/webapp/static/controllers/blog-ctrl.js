define(['angular','kkpager'], function (angular,kkpager) {
    return function BlogCtrl( $scope, $http ){
       	$scope.showSearch=false;
    	$scope.$on('getLucenBlogs', function(e, data) {
    		$scope.blogs = data.results;
    	});
    	$scope.findByType = function(id) {
    		$http({
    			url : 'blog/articles/type/' + id + '?pageNum=1',
    			method : 'GET'
    		}).success(function(data) {
    			$scope.blogs = data.page.results;
    			$scope.getPage(data.page);
    		}).error(function(data) {
    			alert(data.msg)
    		});
    	};
    	$http({
    		url : 'blog/articles',
    		method : 'GET'
    	}).success(function(data) {
    		$scope.blogs = data.page.results;
    		$scope.getPage(data.page);
    	}).error(function(data) {
    		alert(data.msg)
    	});
    	$http({
    		url : 'blogType/all',
    		method : 'GET'
    	}).success(function(data) {
    		$scope.types = data.results;
    	}).error(function(data) {
    		alert(data.msg)
    	});

    	// 生成分页控件
    	$scope.getPage = function(page) {
    		kkpager.generPageHtml({
    			pno : page.pageNum,
    			mode : 'click',
    			// 总页码
    			total : page.totalPage,
    			// 总数据条数
    			totalRecords : page.totalRecords,
    			click : function(n) {
    				$http({
    					url : 'blog/articles?pageNum=' + n,
    					method : 'GET'
    				}).success(function(data) {
    					$scope.blogs = data.page.results;
    				}).error(function(data) {
    					alert(data.msg)
    				});
    				this.selectPage(n);
    			}
    		}, true);
    	};
    };
});