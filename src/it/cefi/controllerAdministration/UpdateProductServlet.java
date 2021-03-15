package it.cefi.controllerAdministration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cefi.model.DatabaseAreaRiservata;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {

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

			DatabaseAreaRiservata.updateProduct(img, name_product, quantita, price);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
			
	}

}
