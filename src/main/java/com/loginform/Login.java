package com.loginform;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String log=request.getParameter("login");
		try {
			String driver ="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/market";
			String username="root";//user_name for or DB(my_sql)
			String password="tiger";//password for our DB(my_sql)
			Class.forName(driver);
		    Connection con=DriverManager.getConnection(url,username,password);//connection establishing
		    String uname=request.getParameter("uname");
		    String upass=request.getParameter("upass");
	        if(log!=null) {
	        	 String sql="select uname from login where uname=? and upass=?";
	 		    PreparedStatement ps=con.prepareStatement(sql);
	 		    ps.setString(1, uname);
	 		    ps.setString(2, upass);
	 	        ResultSet rs=ps.executeQuery();
	 	        if(rs.next()) {
	 	        	response.sendRedirect("welcome.jsp");
	 	        	}
	 	        else {
	 	        	response.getWriter().println("<h1>Entered Incorrect Details<br>Please sign in");
		 	    	response.getWriter().println("<a href=login.jsp>SIGNIN");
	 	             }
	        }
	        else {
	        	 String sql="select uname from login where uname=? and upass=?";
		 		    PreparedStatement ps=con.prepareStatement(sql);
		 		    ps.setString(1, uname);
		 		    ps.setString(2, upass);
		 		   ResultSet rs=ps.executeQuery();
		 	        if(rs.next()) {
		 	        	response.getWriter().print("<h1 style='text-align:center;margin:100px;'>Username and password already exists<br>Change details and sign in </h1>");
		 	        	response.getWriter().println("<a href=login.jsp><h1 style='text-align:center;padding:500px;margin:100px'>LOGIN<h1></a>");
		 	        }
		 	        else {
	        	 PreparedStatement pps=con.prepareStatement("insert into login values(?,?,?)");
	 		    pps.setString(1, uname);
	 		    pps.setString(2, upass);
	 		    String amt="0";
	 		    pps.setString(3,amt);
	 	        pps.executeUpdate();
	 	       response.getWriter().println("<h1 style='text-align:center;margin:200px'>SIGNINSUCESSFULL</h1>");
	 	    	response.getWriter().println("<a style='text-alingn:center;margin:100px' href=login.jsp>LOGIN");
		 	        }
	        }
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

}
}
	
