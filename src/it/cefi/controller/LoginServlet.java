package it.cefi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.cefi.model.DatabaseAreaRiservata;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (DatabaseAreaRiservata.validateAccount(username, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			if (username.equals("admin")) {
				resp.sendRedirect("administration.jsp");
			}else {
				resp.sendRedirect("page1.jsp");
			}		
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			PrintWriter out = resp.getWriter();
			
			resp.setContentType("text/html");
			
			out.println("<div class=\"position-absolute alert alert-warning alert-dismissible fade show\" role=\"alert\">\r\n"
					+ "  <strong>WARNING!</strong> Invalid Username or Password.\r\n"
					+ "  <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n"
					+ "</div>");
			
			dispatcher.include(req, resp);
		}
	}
}
