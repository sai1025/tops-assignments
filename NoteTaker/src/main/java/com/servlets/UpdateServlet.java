package com.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noteId=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		Session s=FactoryProvider.getFactory().openSession();
		
		Transaction tx=s.beginTransaction();
		Note note=(Note)s.get(Note.class, noteId);
		note.setTitle(title);
		note.setContent(content);
		note.setAddedDate(new Date());
		tx.commit();
		s.close();
		response.sendRedirect("view.jsp");
		
	}

}
