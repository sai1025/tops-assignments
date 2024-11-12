<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="all_js_css.jsp" %>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp" %>
		<br>
		<h1> Please fill your page details</h1>
		<form action="SaveNoteServlet" method="post">
		  <div class="mb-3">
		    <label for="title" class="form-label"> Note title</label>
		    <input 
		    required 
		    type="text" 
		    class="form-control"
		     id="title" 
		     name="title" 
		     placeholder="enter title here" 
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
			     placeholder="enter your content">
		     </textarea>
		  </div>
		  
		  <div class="container text-center">
		  <button type="submit" class="btn btn-primary">Add</button>
		  </div>
		</form>
	</div>
</body>
</html>