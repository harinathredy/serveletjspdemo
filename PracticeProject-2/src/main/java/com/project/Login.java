package com.project;

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

@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final boolean isLoggedIn = false;
	public static String password;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/mydb";
		String uname = "root";
		String pass = "Virat@12";

		response.setContentType("text/html");

		int pId = Integer.parseInt(request.getParameter("p_ID"));

		PrintWriter out = response.getWriter();

		String query = "select * from product where productId=?";
		out.print("<h1>Displaying the Product Details...</h1>");
		out.print("<table border='1'><tr><th>ProductId</th><th>ProductName</th><th>ProductPrice</th></tr>");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbCon = DriverManager.getConnection(url, uname, pass);
			PreparedStatement st = dbCon.prepareStatement(query);

			st.setInt(1, pId);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				out.print("<tr><td>");
				out.println(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("</tr>");

			}

		} catch (Exception e) {

			System.out.println("Some Issue : " + e.getMessage());

		}

	}

}