$(document).ready(function(){
	var globalData;
	
	$('#butAjax').click(function(){
				
		$.ajax({
			url:"http://localhost:8080/api/regionid",
			type: "get",
			data: {blsnum:1},
			 dataType: "json",
			success:function(data){
				console.log("success recv data");
				globalData = data;
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
	
	
	$('#pushBut').click(function(){
		
		//alert("click push");
		var jsonArray = [{"stateCode":"CT","stateNum":"09"},{"stateCode":"ME","stateNum":"23"},{"stateCode":"MA","stateNum":"25"},{"stateCode":"NH","stateNum":"33"},{"stateCode":"NY","stateNum":"36"},{"stateCode":"RI","stateNum":"44"},{"stateCode":"VT","stateNum":"50"},{"stateCode":"PR","stateNum":"72"}];
		
		$.ajax({
			url:"http://localhost:8080/api/pushStates",
			type:"post",
			cache:false,
			processData:false,
			data:JSON.stringify(jsonArray),
			dataType:"json",
			contentType: "application/json; charset=utf-8",
			success:function(data){
				console.log("recv back push data");
				//console.log(data);
				$(data).each(function(key,value){
					console.log(key+"-"+value+"-"+value.stateCode+value.stateNum);
				});
			},
			
			erro:function(xhr){
				
				console.log("recv fail");
			}
			
		});
		
	});
	
});