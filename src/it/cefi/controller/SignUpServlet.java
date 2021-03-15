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

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (!(DatabaseAreaRiservata.SignAccount(username))) {
			DatabaseAreaRiservata.InsertUser(username, password);
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			resp.sendRedirect("page1.jsp");
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			PrintWriter out = resp.getWriter();
			
			resp.setContentType("text/html");
			
			out.println("<div class=\"position-absolute alert alert-warning alert-dismissible fade show\" role=\"alert\">\r\n"
					+ "  <strong>WARNING!</strong> Username Exists\r\n"
					+ "  <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n"
					+ "</div>");
			
			dispatcher.include(req, resp);
		}
	}
}
