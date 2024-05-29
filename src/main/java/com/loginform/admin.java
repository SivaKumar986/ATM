package com.loginform;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class admin
 */
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int apass=Integer.parseInt(request.getParameter("apass"));
		try {
			if(apass==7799) {
				String driver ="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/market";
				String username="root";//user_name for or DB(my_sql)
				String password="tiger";//password for our DB(my_sql)
				Class.forName(driver);
				Connection con=DriverManager.getConnection(url,username,password);//connection establishing
				response.getWriter().print("<h1>ADMIN</h1>");
				String sql="select uname,amount from login where amount>=0 or amount<=0";
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				response.getWriter().print("<table border='2'>");
				response.getWriter().print("<tr><th>User Name</th><th>Amount Balance</th></tr>");
				while(rs.next()) {
					response.getWriter().println("<tr><td>"+rs.getString(1)+" </td><td>"+rs.getString(2)+" </td></tr>");
				}
				response.getWriter().print("<table>");
        			}
			else {
				response.getWriter().print("<h1>Only for admins</h1>");
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
