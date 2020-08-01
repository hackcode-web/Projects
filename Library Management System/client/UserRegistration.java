package client;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/apple")
public class UserRegistration extends HttpServlet 
{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		
		PrintWriter out=res.getWriter();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");
	
		
		String name=req.getParameter("a1");
		String email=req.getParameter("a2");
		String passcode=req.getParameter("a3");
		String address=req.getParameter("a4");
		
		
		
	String sql=("insert into userlibrary values(?,?,?,?)");
		
		PreparedStatement ps=con.prepareStatement(sql);
	
		System.out.println("a");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, passcode);
				ps.setString(4, address);
				
			System.out.println("b");
			int rs=ps.executeUpdate();
			
			System.out.println();
			out.println("<html><body>");
			out.println("succesfully registered ur details::");
			out.println("</body></html>");
			out.println("<a href='userlogin.html'>SIGN IN</a>");
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

}
