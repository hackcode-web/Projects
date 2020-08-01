package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/addbook")
public class Addbook extends HttpServlet

{
	
	Connection con;
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException 
			{
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");
	
		
		String sql=("insert into addbook values(?,?,?,?,?)");
		PreparedStatement ps=con.prepareStatement(sql);
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String author=req.getParameter("author");
		String publisher=req.getParameter("publisher");
		int quantity=Integer.parseInt(req.getParameter("quan"));
		
	
		
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, author);
		ps.setString(4, publisher);
		ps.setInt(5, quantity);
		
		
		int rs=ps.executeUpdate();
		
		PrintWriter out=res.getWriter();
		
		
		
		out.println("<html><body>");
		out.println("succesfully registered ur details::");
		out.println("</body></html>");
		
		
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
