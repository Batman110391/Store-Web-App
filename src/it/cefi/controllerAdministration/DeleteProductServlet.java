package it.cefi.controllerAdministration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cefi.model.DatabaseAreaRiservata;


@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		

		String name_product = req.getParameter("name_product");
		
		try(PrintWriter out = resp.getWriter();){

			DatabaseAreaRiservata.deleteProduct(name_product);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
			
	}

}
