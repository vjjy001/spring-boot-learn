var app = angular.module("ngApp",[]);

app.controller("ngCtrl",function($scope,$http){
	
	
	$scope.getStates = function(){
		
		$http.get('http://localhost:8080/api/states').then(function success(response){
			
			console.log(response.status);
			if(response.status == 200)
			{
				$scope.ok = true;
				}
			$scope.recvData = response.data;
			
		},function fail(response){
			
			console.log(response.status);
			
		});
	}
	
});

app.controller("ngLocalCtrl", function($scope,$http){
	
	$scope.getEmp=function(){
		$http.get('http://localhost:8080/api/getStudents').then(function success(response){
			
			console.log(response.status);
			if(response.status == 200)
			{
				$scope.ok = true;
				}
			$scope.recvData = response.data;
			
		},function fail(response){
			
			console.log(response.status);
			
		});
	}
	
	
});