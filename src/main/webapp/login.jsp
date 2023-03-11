<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body style="background-image: url('css/background.jpg');">

	<center>
		<h1>Administration Login</h1>
	</center>
	<div class="login-page">
		<div class="form">
			<form class="login-form" action="ControllerServlet" method="POST">
			        	<input type="hidden" name="destination" value="LOGIN" />
			
				<input type="text" name="username" placeholder="username" /> <input
					type="password" placeholder="password" name="password" />
				<button type="submit">login</button>
			</form>
		</div>
	</div>
</body>
</html>