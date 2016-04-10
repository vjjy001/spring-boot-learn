$(document).ready(function(){
	
	$('#butAjax').click(function(){
		
		$.ajax({
			url:"http://localhost:8080/api/getStudents",
			type: "get",
			success:function(data){
				console.log("success recv data");
				//var jsonData = $.parseJSON(data)
			
				$(data).each(function(key,value){
					var item = value.stuId+value.firstName+value.lastName+value.finacialNum+value.teacherId;
					console.log(item);
					
				});
			},
			
			error: function(xhr) {
				console.log("error");
				//Do Something to handle error
			}
		});
	});
	
	$('#pushBut').click(function(){
		
		//alert("test push but");
		
		//'{"stuId":1,"firstName":"Peter","lastName":"Philp","finacialNum":3,"teacherId":2}'
		var subData = {"stuId":1,"firstName":"Peter","lastName":"Philp","finacialNum":3,"teacherId":2};
		$.ajax({
			url:"http://localhost:8080/api/getStudByJson",
			type: "post",
			data: JSON.stringify(subData),
			contentType: "application/json",
			dataType: "json",
			success:function(data){
				console.log("recv push data");
				$(data).each(function(key,value){
					var item = value.stuId+value.firstName+value.lastName+value.finacialNum+value.teacherId;
					console.log(item);
					
				});
			},
			error: function(xhr) {
				console.log("error");
				//Do Something to handle error
			}
		});	
	});
	
$('#pushListBut').click(function(){
		
		//alert("test push but");
		
		//'{"stuId":1,"firstName":"Peter","lastName":"Philp","finacialNum":3,"teacherId":2}'
		var subData = [{"stuId":1,"firstName":"Peter","lastName":"Philp","finacialNum":3,"teacherId":2},{"stuId":2,"firstName":"First2","lastName":"Last2","finacialNum":2,"teacherId":3},{"stuId":3,"firstName":"First3","lastName":"Last3","finacialNum":3,"teacherId":3},{"stuId":4,"firstName":"First4","lastName":"Last4","finacialNum":4,"teacherId":3},{"stuId":5,"firstName":"First5","lastName":"Last5","finacialNum":5,"teacherId":3},{"stuId":6,"firstName":"First6","lastName":"Last6","finacialNum":6,"teacherId":1},{"stuId":7,"firstName":"First7","lastName":"Last7","finacialNum":7,"teacherId":1},{"stuId":8,"firstName":"First8","lastName":"Last8","finacialNum":8,"teacherId":1},{"stuId":9,"firstName":"First9","lastName":"Last9","finacialNum":9,"teacherId":1},{"stuId":10,"firstName":"First10","lastName":"Last10","finacialNum":10,"teacherId":1},{"stuId":11,"firstName":"First11","lastName":"Last11","finacialNum":11,"teacherId":1},{"stuId":12,"firstName":"First12","lastName":"Last12","finacialNum":12,"teacherId":1},{"stuId":101,"firstName":"student101","lastName":"student101","finacialNum":101,"teacherId":1}];
		$.ajax({
			url:"http://localhost:8080/api/pushStuJSONArray",
			type: "post",
			data: JSON.stringify(subData),
			contentType: "application/json",
			dataType: "json",
			success:function(data){
				console.log("recv push data");
				$(data).each(function(key,value){
					var item = value.stuId+value.firstName+value.lastName+value.finacialNum+value.teacherId;
					console.log(item);
					
				});
			},
			error: function(xhr) {
				console.log("error");
				//Do Something to handle error
			}
		});	
	});
});