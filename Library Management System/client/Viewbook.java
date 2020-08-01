package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/viewbook")
public class Viewbook extends HttpServlet

{
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");
	
			PreparedStatement ps=con.prepareStatement("select * from addbook");
			
			PrintWriter out=res.getWriter();
			
			ResultSet rs=ps.executeQuery();
									
			while(rs.next())
				
			{
				
				out.println("<html><body>");
				out.print("<style>table, th, td {border: 1px solid black;}</style>");
				
				out.println("<table><tr>");
				out.println("<th>ID</th>");
				out.println("<th>NAME</th>");
				out.println("<th>PUBLISHER</th>");
				out.println("<th>AUTHOR</th>");
				out.println("<th>QUANTITY</th>");
				out.println("</tr><tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr></table>");			
				out.println();
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
