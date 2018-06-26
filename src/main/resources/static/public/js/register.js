function submit(){
	
	var data = {};
	data.username = $("#username").val();
	data.password = $("#password").val();
	getData("POST", interfaces.register, false, data, function(result){
		
	});
}
