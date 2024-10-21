<%@page import="ems.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String url="jdbc:mysql://localhost:3306/topsdb";
	String user="root";
	String password="123456";
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url, user, password);
	ps=con.prepareStatement("select * from emp");
	rs=ps.executeQuery();
	ArrayList<Employee> list=new ArrayList<Employee>();
	
	if(rs!=null)
	{
		while(rs.next())
		{
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setFirstName(rs.getString(2));
			e.setLastName(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setContact(rs.getString(5));
			e.setAddress(rs.getString(6));
			e.setGender(rs.getString(7));
			e.setPassword(rs.getString(8));
			list.add(e);
		}
	}
%>			
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employees</title>
<script type="text/javascript" src="script.js"></script>
<style>
 #updateForm {
            display: none; /* Hide the form initially */
            margin-top: 20px;
            border: 1px solid #ccc;
            padding: 10px;
        }
       
</style>
</head>
<body >
<div id="overlay">
<h1 style="margin-left:400px">
 Employee List
 </h1>
<table border="1" style="width: 90%; margin-left: auto; margin-right: auto; ">
	<tr>
			<th>EmpID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>mobile</th>
			<th>Address</th>
			<th>Gender</th>
			<th>Password</th>
			<th>Action</th>
	</tr>
	<%
		for(Employee e:list)
		{
	%>
	<tr>
			<td><%=e.getId() %></td>
			<td><%=e.getFirstName() %></td>
			<td><%=e.getLastName() %></td>
			<td><%=e.getEmail() %></td>
			<td><%=e.getContact() %></td>
			<td><%=e.getAddress() %></td>
			<td><%=e.getGender() %></td>
			<td><%=e.getPassword() %></td>
			<td>

	            <button type="button" onclick="showUpdateForm(<%=e.getId() %>,'<%=e.getFirstName()%>','<%=e.getLastName()%>','<%=e.getEmail()%>','<%=e.getContact()%>','<%=e.getAddress()%>','<%=e.getGender()%>','<%=e.getPassword()%>')">
	            update</button>
	            <button type="button" onclick="window.location='<%=request.getContextPath()%>/delete?id=<%=e.getId()%>'">delete</button>
			</td>
	</tr>
	<%
		}
	%>
		

</table>
</div>
<div id="updateForm">
	<h2>update employee details</h2>
    <form action="<%= request.getContextPath() %>/update" method="post">
        <input type="hidden" id="empId" name="id">
        <label>FirstName:</label>
        <input type="text" id="empFName" name="Fname" required>
        <br>
        <label>LastName:</label>
        <input type="text" id="empLName" name="Lname" required>
        <br>
        <label>Email:</label>
        <input type="email" id="empEmail" name="email" required>
        <br>
        <label>Mobile:</label>
        <input type="text" id="mobile" name="mobile" required>
        <br>
        <label>Address:</label>
        <input type="text" id="Address" name="address" required>
        <br>
        <label>Gender:</label>
            <input type="radio" id="male" name="gender" value="male" required>
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="female" required>
            <label for="female">Female</label>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Save">
        <button type="button" onclick="hideUpdateForm()">Cancel</button>
    </form>
</div>
</body>
</html>