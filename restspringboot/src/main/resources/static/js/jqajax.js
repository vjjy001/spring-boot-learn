$(document).ready(function(){
	
	$('#butAjax').click(function(){
		
		$.ajax({
			url:"http://localhost:8080/api/regionid",
			type: "get",
			data: {blsnum:1},
			 dataType: "json",
			success:function(data){
				console.log("success recv data");
				//var jsonData = $.parseJSON(data)
			$(data).each(function(key,value){
				
				//console.log(key+"-"+value+"-"+value[key].stateCode+"-"+value[key].stateNum);
				console.log(key+"-"+value+"-"+value.stateCode+value.stateNum);
				var item = value.stateCode+value.stateNum;
				 $('#selects')
		         .append($("<option></option>")
		         .attr("value",key)
		         .text(item)); 
			});
			},
			
			error: function(xhr) {
				console.log("error");
				//Do Something to handle error
			}
		});
	});
	
});