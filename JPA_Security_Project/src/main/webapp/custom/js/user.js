var User = function(email, username, password) {
	this.username = username;
	this.password = password;
	this.email = email;

};

User.prototype.passwordmatch = function(originPass, confirmPass) {
	if (originPass != confirmPass) {
		$("#warnMsg").text("Password is missmatch");

	} else {
		$("#warnMsg").text("");
	}

};

User.prototype.signin = function() {

	var userinfo = {
		name : this.username,
		password : this.password,
		email : this.email,

	};
	 var infojson = JSON.stringify(userinfo);

	$.ajax({
		type : "PUT",
		url : "UserInfo",
		data : infojson,
		contentType : "application/json; charset=UTF-8",
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		success : function(response) {

			$("#warnMsg").text(response.message);

			if (response.message == 'success') {
				document.location.href = "login";
			}
		},
		error : function(request, status, error) {
			$("#warnMsg").text(
					"code:" + request.status + "\n" + "message:"
							+ request.responseText + "\n" + "error:" + error);
		}

	});
};

User.prototype.eventHandler = function(user) {

};
