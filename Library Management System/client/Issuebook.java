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

@WebServlet("/Issuebook")
public class Issuebook extends HttpServlet 
{
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
					
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","manager");
				
				String sql=("insert into Issuebook values(?,?,?,?)");
				PreparedStatement ps=con.prepareStatement(sql);
				System.out.println("cat");
				
				String bid=req.getParameter("bid");
				int bid1=Integer.parseInt(bid);
				System.out.println("bat");
				
				int sid=Integer.parseInt(req.getParameter("sid"));
				String sname=req.getParameter("sname");
				int smob=Integer.parseInt(req.getParameter("smob"));
				
				
				ps.setInt(1, bid1);
				ps.setInt(2, sid);
				ps.setString(3, sname);
				ps.setInt(4, smob);
				
				
				int rs=ps.executeUpdate();
				
				PrintWriter out=res.getWriter();
				
				
				
				out.println("<html><body>");
				out.println("succesfully issued book::");
				out.println("</body></html>");
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

}
