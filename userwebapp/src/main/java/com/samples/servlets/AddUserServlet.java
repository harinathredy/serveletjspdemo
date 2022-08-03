package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname =request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String emailId =request.getParameter("email");
		String password =request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Virat@12");
				Statement statement=connection.createStatement()){
			String query="insert into user values('"+firstname+"' ,'"+lastname+"','"+emailId+"','"+password+"')";
			System.out.println("Query being executed: "+query);
			int rowsInserted=statement.executeUpdate(query);
			System.out.println("Number of rows inserted: "+rowsInserted);
			PrintWriter pw=response.getWriter();
			pw.write("user successfully added");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
