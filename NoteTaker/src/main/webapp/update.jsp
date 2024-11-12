<%@page import="com.entities.Note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Note here</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container">
		<%@include file="navbar.jsp" %>
		<br>
		<h1> Please Update Your Note</h1>
		<%
			int id=Integer.parseInt(request.getParameter("id").trim());
			Session s=FactoryProvider.getFactory().openSession();
			Note note=(Note)s.get(Note.class, id);
		%>
		<form action="UpdateServlet" method="post">
		<input type="hidden" name="id" value="<%=note.getId() %>"/>
		  <div class="mb-3">
		    <label for="title" class="form-label"> Note title</label>
		    <input 
		    required 
		    type="text" 
		    class="form-control"
		     id="title" 
		     name="title" 
		     placeholder="enter title here" 
		     value="<%=note.getTitle() %>"
		     aria-describedby="emailHelp"/>
		  </div>
		  <div class="mb-3">
		    <label for="content" class="form-label">Content</label>
		    <textarea 
			     id="content"
			     required
			     name="content" 
			     class="form-control"
			     style="height:200px;"
			     placeholder="enter your content"
			     ><%=note.getContent() %>
		     </textarea>
		  </div>
		  
		  <div class="container text-center">
		  <button type="submit" class="btn btn-success">Update</button>
		  </div>
		</form>
	</div>
</body>
</html>