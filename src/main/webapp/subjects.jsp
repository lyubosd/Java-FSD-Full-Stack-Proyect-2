<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Teachers</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
	<div id="page">
		<jsp:include page="mainMenu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Subjects</h3>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>Name</th>
						<th>Description</th>
					</tr>
					<c:forEach var="tempSubject" items="${SUBJECT_LIST }">
						<tr>
							<td>${tempSubject.name}</td>
							<td>${tempSubject.description}</td>		
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>