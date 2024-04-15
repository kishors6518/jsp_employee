<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String msg2=(String)request.getAttribute("message"); 
	if(msg2!=null){%>
<%= msg2 %>
<% } %>
	<form action="signup" method="post">
		<h1>SignUp Form</h1>
		Id:<input type="number" name="id"><br><br>
		Name:<input type="text" name="name"><br><br>
		Phone:<input type="tel" name="phone"><br><br>
		Email:<input type="text" name="email"><br><br>
		Password:<input type="text" name="pass"><br><br>
		Designation:<input type="text" name="desig"><br><br>
		Salary:<input type="tel" name="salary"><br><br>
		<button>Register</button>
		
	</form>
</body>
</html>