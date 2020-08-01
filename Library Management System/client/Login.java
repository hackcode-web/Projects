package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/log")
public class Login extends HttpServlet {
	
	Connection con;
	PrintWriter out;
	


	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	try 		
	{
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
				
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");
	
		
		System.out.println("19");
		PreparedStatement ps=con.prepareStatement("select * from library where email=? and passcode=?");
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		ps.setString(1, email);
		ps.setString(2, pass);
		
		ResultSet rs=ps.executeQuery();
		
		out=res.getWriter();
		if(rs.next())
		{
			System.out.println(rs.getString(1));
			out.println("<html><body><br>");
			out.println("<h>hello Mr:"+rs.getString(1)+"</h><br>");
			out.println("<h ref='add'></h>");
			out.println("</body></html>");
			out.println("executed");
			
		}
		else
		{
			out.println("sorry invaliud user");
		}
	}
	catch (Exception e)
	{
		System.out.println(e);
	} 
		
}

}
