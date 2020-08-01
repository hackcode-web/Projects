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


@WebServlet("/viewissuebook")
public class ViewIssuedbook extends HttpServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");
	
			PreparedStatement ps=con.prepareStatement("select * from Issuebook");
			
			PrintWriter out=res.getWriter();
			
			ResultSet rs=ps.executeQuery();
									
			while(rs.next())
				
			{
				
				out.println("<html><body>");
				out.print("<style>table, th, td {border: 1px solid black;}</style>");
				
				out.println("<table><tr>");
				out.println("<th>BOOK ID</th>");
				out.println("<th>STUDENT ID</th>");
				out.println("<th>NAME</th>");
				out.println("<th>MOBILE</th>");
				out.println("</tr><tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				
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
