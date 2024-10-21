package ems;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class AddEmployeeServlet
 */
//@WebServlet("/register")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpDAO dao=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 dao=new EmpDAO();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int result=0;
		String f_name=request.getParameter("firstName");
		String l_name=request.getParameter("lastName");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String addr=request.getParameter("address");
		String gender=request.getParameter("gender");
		String passwd=request.getParameter("password");
		
		Employee e=new Employee();
		e.setFirstName(f_name);
		e.setLastName(l_name);
		e.setEmail(email);
		e.setContact(mobile);
		e.setAddress(addr);
		e.setGender(gender);
		e.setPassword(passwd);
		
		try {
			result=dao.registerEmployee(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(result>0)
		{
			System.out.println("employee added successfully");
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<h1> employee added </h>");
			
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			
		}
	}

}
