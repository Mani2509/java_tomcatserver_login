

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String un=request.getParameter("un");
		String pwd=request.getParameter("pwd");
		String tpe=request.getParameter("tpe");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","mani");
			PreparedStatement ps=conn.prepareStatement("select * from registration where username=? and password=? and type=?");
			ps.setString(1, un);
			ps.setString(2, pwd);
			ps.setString(3, tpe);
			
			//ResultSet rs=ps.executeQuery();
			response.sendRedirect("welcome.html");
			}
			catch(Exception e) {
			}
	}

}
