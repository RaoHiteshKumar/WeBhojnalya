package com.restraurent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  //form action
	      res.setContentType("text/html");
	      PrintWriter pw= res.getWriter();
	      pw.print("Form Submited Successfully.");
	      
	      String name= req.getParameter("username");
	      String password= req.getParameter("password");
	      
	      pw.print("Name of customer : " + name);
	      pw.print("Password: " + password);
	      
	      System.out.println("Name of customer : " + name);
	      System.out.println("Password : " + password);
	      
	      String url = "jdbc:mysql://localhost:3306/hitesh";
	      String username = "root";
	      String pwrd = "7670";
	      
	      try { 
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection c=DriverManager.getConnection(url,username,pwrd);
	                    
	        //print data in database
	        String query = "insert into login values(?,?)";
	        PreparedStatement statement =c.prepareStatement(query);

	        statement.setString(1,name);
	        statement.setString(2,password);
	        
	        statement.executeUpdate();
	        
	        System.out.println("Data Inserted.");
	      } 
	      catch (ClassNotFoundException | SQLException e) {
	      	System.out.println("data not inserted");
	        e.printStackTrace();
	      }
	      
	}
	
}
