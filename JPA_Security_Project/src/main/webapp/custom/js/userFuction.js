$(document).ready(function() {
	var user = new User();
	
	$("#registBtn").click(function(e) {
		user.email = $("#email").val();
		user.username = $("#username").val();
		user.password = $("#password").val();
		
		user.signin();
		
	});
	$('#c_password').keyup(function(e) {

		var originPass = $("#password").val();
		var confirmPass = $("#c_password").val();
		user.passwordmatch(originPass, confirmPass);
	});
});
