package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/life")
public class registration extends HttpServlet{


		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			PrintWriter out=res.getWriter();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
					
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");
		
			
			String name=req.getParameter("t1");
			String email=req.getParameter("t2");
			String passcode=req.getParameter("t3");
			String address=req.getParameter("t4");
			String country=req.getParameter("t5");
			
			
		String sql=("insert into library values(?,?,?,?,?)");
			
			PreparedStatement ps=con.prepareStatement(sql);
		
			System.out.println("a");
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setString(3, passcode);
					ps.setString(4, address);
					ps.setString(5, country);
				
				System.out.println("b");
				int rs=ps.executeUpdate();
				
				System.out.println();
				out.println("<html><body>");
				out.println("succesfully registered ur details::");
				out.println("</body></html>");
				out.println("<a href=login.html>SIGN IN</a>");
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

	
}
}
