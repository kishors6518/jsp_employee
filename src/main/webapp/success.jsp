<%@page import="jsp_employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String message = (String)request.getAttribute("message");
    if(message != null) {
        out.print("<h1>" + message + "</h1>");
    }
    %>
    
    <% List<Employee> list = (List<Employee>) request.getAttribute("list"); %>
     
    <table border="2px solid">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Password</th>
        <th>Designation</th>
        <th>Salary</th>
    </tr>
    <% for (Employee employee : list) { %>
        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getName() %></td>
            <td><%= employee.getPhone() %></td>
            <td><%= employee.getEmail()%></td>
            <td><%= employee.getPass()%></td>
            <td><%= employee.getDesignation() %></td>
            <td><%= employee.getSalary()%></td>
            <td><a href="delete?id=<%=employee.getId()%>"><button>Delete</button></a></td>
            <td><a href="update?id=<%=employee.getId()%>"><button>Update</button></a></td>
        </tr>
    <% } %>
    </table>

	

</body>
</html>