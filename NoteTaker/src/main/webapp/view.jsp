<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.hibernate.Session" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="all_js_css.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<%@include file="navbar.jsp" %>
		<br>
		<h1> All Notes</h1>
		<div class="row">
			<div class="col-12">
				<%
		
					Session s=FactoryProvider.getFactory().openSession();
					Query q=s.createQuery("from Note");
					List<Note> list=q.list();
					for(Note note:list)
					{
						
				 %>
				 <div class="card mt-4" >
					  <img src="img/notepad.png" style="max-width:200px;" class="card-img-top p-5 mx-auto" alt="...">
					  <div class="card-body">
					    <h5 class="card-title"><%=note.getTitle() %></h5>
					    <p class="card-text"><%=note.getContent() %></p>
					    <p><b class="text-primary">last modified:<%=note.getAddedDate() %> </b></p>
					    <div class="container text-center mt-3">
					    <a href="DeleteServlet?id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
					    <a href="update.jsp?id=<%=note.getId() %>&title=" class="btn btn-primary">Update</a>
					    </div>
					    
					  </div>
				</div>
									 
				 <% 
				 	}
					s.close();
				 %>
			</div>
		</div>
		
			
		
</div>
</body>
</html>