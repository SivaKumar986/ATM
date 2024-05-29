package com.loginform;

import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Servlet implementation class Money
 */
public class Money extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Money() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String driver ="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/market";
			String username="root";//user_name for or DB(my_sql)
			String password="tiger";//password for our DB(my_sql)
			Class.forName(driver);
		    Connection con=DriverManager.getConnection(url,username,password);//connection establishing
		    String uname=request.getParameter("user");
		    String upass=request.getParameter("pass");
		    String amount=request.getParameter("amount");
		    int sel=Integer.parseInt(request.getParameter("sele"));
		    if(sel==101) {
		    	
		    	 String sql="select uname,amount from login where uname=? and upass=?";
		 		    PreparedStatement ps=con.prepareStatement(sql);
		 		    ps.setString(1, uname);
		 		    ps.setString(2, upass);
		 	        ResultSet rs=ps.executeQuery();
		 	        if(rs.next()) {
		 	        	
		 	        	String sql1="update login set amount=amount-? where uname=? and upass=?";
		 	        	PreparedStatement withdraw = con.prepareStatement(sql1);
		 	        	withdraw.setString(2, uname);
		 	        	withdraw.setString(3,upass);
		 	        	withdraw.setString(1, amount);
		 	        	withdraw.executeUpdate();
		 	        	response.getWriter().print("<h1>WITHDRAW SUCESSFULL</h1>");
		 	        }
		 	        else {
		 	        	response.getWriter().print("<h1>username or password is wrong</h1>");
		 	        }
		    }
		    else if(sel==103) {
		    	String sql="select amount from login where uname=? and upass=?";
	 		    PreparedStatement ps=con.prepareStatement(sql);
	 		    ps.setString(1, uname);
	 		    ps.setString(2, upass);
	 	        ResultSet rs=ps.executeQuery();
	 	        if(rs.next()) {
	 	        	response.getWriter().print("<h1 style='color:red'>User Name : "+uname+"</h1> ");
	 	        	response.getWriter().print("<h1>Amount Balance : "+rs.getInt(1)+"");
	 	        }
	 	        else {
	 	        	response.getWriter().print("<h1>username or password is wrong</h1>");
	 	        }
		    }
		    else {
		    	String sql="select uname from login where uname=? and upass=?";
	 		    PreparedStatement ps=con.prepareStatement(sql);
	 		    ps.setString(1, uname);
	 		    ps.setString(2, upass);
	 	        ResultSet rs=ps.executeQuery();
	 	        if(rs.next()) {
	 	        	
	 	        	String sql2="update login set amount=amount+? where uname=? and upass=?";
	 	        	PreparedStatement deposit = con.prepareStatement(sql2);
	 	        	deposit.setString(2, uname);
	 	        	deposit.setString(3,upass);
	 	        	deposit.setString(1, amount);
	 	        	deposit.executeUpdate();
	 	        	response.getWriter().print("<h1>DEPOSITED SUCESSFULL</h1>");
	 	        }
	 	        else {
	 	        	response.getWriter().print("<h1>username or password is wrong</h1>");
	 	        }
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
