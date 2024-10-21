package ems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDAO {
	private Connection con;
	public EmpDAO()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/topsdb","root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int registerEmployee(Employee e) throws SQLException
	{
		
		String Query="insert into emp(f_name,l_name,email,mobile,address,gender,passwd) values(?,?,?,?,?,?,?)";
		int result=0;

		PreparedStatement ps=con.prepareStatement(Query);
		
		ps.setString(1,e.getFirstName());
		ps.setString(2, e.getLastName());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getContact());
		ps.setString(5, e.getAddress());
		ps.setString(6, e.getGender());
		ps.setString(7, e.getPassword());
		result=ps.executeUpdate();
		
		
		return result;
		
	
		
	}
	public int updateEmployee(Employee e) throws SQLException
	{
		int result=0;
		String Query="update emp set f_name=?,l_name=?,email=?,mobile=?,address=?,gender=?,passwd=? where e_id=?";
		
		PreparedStatement ps=con.prepareStatement(Query);
		
		ps.setString(1,e.getFirstName());
		ps.setString(2, e.getLastName());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getContact());
		ps.setString(5, e.getAddress());
		ps.setString(6, e.getGender());
		ps.setString(7, e.getPassword());
		ps.setInt(8, e.getId());
		result=ps.executeUpdate();
		return result;
	
	}
	public int deleteEmployee(int id) throws SQLException
	{
		
		int result=0;
		String Query="delete from emp where e_id=?";
		PreparedStatement ps=con.prepareStatement(Query);
		ps.setInt(1, id);
		result=ps.executeUpdate();
		return result;
	}
}
