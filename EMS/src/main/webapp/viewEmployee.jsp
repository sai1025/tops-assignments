<%@ page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employees</title>
</head>
<body >
<h1 style="margin-left:400px"> Employee List</h1>
<table border="1" style="width: 80%; margin-left: auto; margin-right: auto; ">
<th>EmpID</th><th>FirstName</th><th>LastName</th><th>Email</th><th>mobile</th><th>Address</th><th>Gender</th><th>Password</th>
<%!
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
String url="jdbc:mysql://localhost:3306/topsdb";
String user="root";
String password="123456";
%>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url, user, password);
	ps=con.prepareStatement("select * from emp");
	rs=ps.executeQuery();
	
	if(rs!=null)
	{
		while(rs.next())
		{
%>		
		<tr>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getString(6) %></td>
		<td><%=rs.getString(7) %></td>
		<td><%=rs.getString(8) %></td>
		<td>
		<form style="width:100%">
            <button type="button" onclick="window.location.href='editEmployee.jsp'">edit</button>
            <button type="button" onclick="window.location.href='deleteEmployee.jsp'">delete</button>
        </form>
		</td>
		</tr>
		
<% 	
		}
	}
	
%>

</table>
</body>
</html>