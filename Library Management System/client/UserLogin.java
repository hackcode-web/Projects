package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user")
public class UserLogin extends HttpServlet
{
	
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		PrintWriter out;
		
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
			
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");

	
	System.out.println("A");
	PreparedStatement ps=con.prepareStatement("select * from userlibrary where email=? and passcode=?");
	
	String email=req.getParameter("uemail");
	String pass=req.getParameter("upass");
	
	ps.setString(1, email);
	ps.setString(2, pass);
	
	ResultSet rs=ps.executeQuery();
	
	out=res.getWriter();
	
	System.out.println("B");
	if(rs.next())
	{

		out.println("<html><body><style>body {background-color: lightblue;}</style>");
		
		out.println("<nav>");
		
		out.println("<a href='addbook.html'>ADD BOOK</a>");
		
		
		out.print("<a href='viewbook'>VIEW BOOK</a>");
		
		
		out.println("<a href='Issuebook.html'>ISSUE BOOK</a>");
		
		out.println("<a href='viewissuebook'>VIEW ISSUED BOOK</a>");
		out.println("</nav></body></html>");
		
		out.println("<html><body><br>");
		out.println("<h>hello Mr:"+rs.getString(1)+"</h><br>");
		out.println("</body></html>");
	out.println("executed");
		
		

		
	}
			else
			{
				out.println("sorry");
			}
	
	
	}
	 		catch (Exception e)
	 			{
	 				System.out.println(e);
	 			} 
	
	}
}
