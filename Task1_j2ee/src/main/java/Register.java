


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

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String un=request.getParameter("un");
		String pwd=request.getParameter("pwd");
		String conpwd=request.getParameter("conpwd");
		String tpe=request.getParameter("tpe");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","mani");
		PreparedStatement ps=conn.prepareStatement("insert into registration(username,password,confirmpassword,type) values(?,?,?,?)");
		ps.setString(1, un);
		ps.setString(2, pwd);
		ps.setString(3, conpwd);
		ps.setString(4, tpe);
		ps.executeUpdate();
		
		response.sendRedirect("Login.html");
		
		}
		catch(Exception e) {
		}
		out.close();
	}

}
