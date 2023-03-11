<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sidenav">
	<h3 id="logo">
		Administrative <br /> Portal
	</h3>
	<c:url var="classesLink" value="ControllerServlet">
		<c:param name="destination" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="ControllerServlet">
		<c:param name="destination" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="ControllerServlet">
		<c:param name="destination" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="ControllerServlet">
		<c:param name="destination" value="STUDENTS" />
	</c:url>
	
 

 
 	 
	
	<a class="bar-item" href="${classesLink}">Classes</a> 
		<a class="bar-item" href="${subjectsLink}">Subjects</a>
		<a class="bar-item" href="${teachersLink}">Teachers</a> 
		<a class="bar-item" href="${studentsLink}">Students</a> 
		<a class="bar-item" href="login.jsp">Log out</a>

</div>

