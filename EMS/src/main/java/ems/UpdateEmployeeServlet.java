package ems;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpDAO dao=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        dao=new EmpDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int result=0;
		int id=Integer.parseInt(request.getParameter("id"));
		String f_name=request.getParameter("Fname");
		String l_name=request.getParameter("Lname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String addr=request.getParameter("address");
		String gender=request.getParameter("gender");
		String passwd=request.getParameter("password");
		
		Employee e=new Employee();
		e.setId(id);
		e.setFirstName(f_name);
		e.setLastName(l_name);
		e.setEmail(email);
		e.setContact(mobile);
		e.setAddress(addr);
		e.setGender(gender);
		e.setPassword(passwd);
		
		try {
			result=dao.updateEmployee(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(result>0)
		{
			System.out.println("updated successfully");
			RequestDispatcher rd=request.getRequestDispatcher("viewEmployee.jsp");
			rd.forward(request, response);
		}
	}

}
