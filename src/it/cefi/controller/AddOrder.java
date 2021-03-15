package it.cefi.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cefi.model.DatabaseAreaRiservata;

@WebServlet("/order")
public class AddOrder extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		String utente = req.getParameter("utente");
		String prodotto = req.getParameter("prodotto");
		String quantita = req.getParameter("quantita");
		String max = req.getParameter("max");
		
		int max_quantity = Integer.parseInt(max);
		int quantity = Integer.parseInt(quantita);
		
		int remaining_quantity = max_quantity - quantity;
		
		DatabaseAreaRiservata.uploadQuantity(remaining_quantity, prodotto);
		
		DatabaseAreaRiservata.insertOrdini(utente, prodotto, quantity);
		
	}

}
