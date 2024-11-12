package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class SaveNoteServlet
 */
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Note note=new Note(title, content, new Date());
		System.out.println(note.getTitle()+":"+note.getContent());
		Session session=FactoryProvider.getFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.persist(note);
		
		tx.commit();
		session.close();
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<h1 style='text-align:center;'> note added successfully</h1>");
		out.println("<h2 style='text-align:center;'><a href='view.jsp'>view notes</a></h2>");
	}

}
