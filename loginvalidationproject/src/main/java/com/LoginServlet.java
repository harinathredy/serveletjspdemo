package com;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
String un = request.getParameter("UserName");
String pass = request.getParameter("pass");
if(un.equals("hari") && pass.equals("Hari123")) {
HttpSession session = request.getSession();
session.setAttribute("UserName", un);
response.sendRedirect("home");
}
else {
response.sendRedirect("index.html");
}
}
}
