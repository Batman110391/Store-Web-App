package it.cefi.controllerAdministration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cefi.model.DatabaseAreaRiservata;

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String img = req.getParameter("img");
		String quantity = req.getParameter("quantita");
		String name_product = req.getParameter("name_product");
		String price_product = req.getParameter("price_product");
		
		int quantita = Integer.parseInt(quantity);
		float price = Float.parseFloat(price_product);
		
		try(PrintWriter out = resp.getWriter();){
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/administration.jsp");
			DatabaseAreaRiservata.addProduct(img, quantita, name_product, price);
			
			resp.setContentType("text/html");
			
			out.println(
			"<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n"
			+ "  <strong>Good!</strong> Product entered successfully. \r\n"
			+ "  <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n"
			+ "</div>");
			
			dispatcher.include(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
			
	}

}
