<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
<!--  -->
	<form id="loginForm" class="da-form da-home-form" method="post"
		action="loginProcess" runat="server">
		<div class="da-form-row">
			<div class=" da-home-form-big">
				<input type="text" id="username" name="username"
					placeholder="Userid" minlength="3" maxlength="20" required="true"
					nosymbols="true" nowhitespace="true" runat="server" />
			</div>
			<div class=" da-home-form-big">
				<input type="password" id="password" name="password"
					placeholder="Password" minlength="3" maxlength="20" required="true"
					nosymbols2="true" nowhitespace="true" runat="server" />
			</div>
		</div>
		<div class="da-home-form-btn-big">
			<!-- <input type="submit" value="Login" id="da-login-submit" class="btn btn-danger btn-block" onclick="javascript:goLogin();" />-->
			<input type="submit" value="Login" id="da-login-submit"
				class="btn btn-danger btn-block" />
		</div>
	</form>
</body>
</html>
