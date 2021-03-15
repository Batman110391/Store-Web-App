package it.cefi.model;

import java.sql.Date;

public class Ordini {
	
	private Date data;
	private int id_ordine;
	private String utente;
	private int quantita;
	private String prodotto;
	
	public Ordini() {}
	
	public Ordini (Date data, int id_ordine, String utente, int quantita, String prodotto) {
		
		this.setData(data);
		this.setId_prodotto(id_ordine);
		this.setUtente(utente);
		this.setQuantita(quantita);
		this.setProdotto(prodotto);
	}

	public Ordini(String utente, int quantita, String prodotto) {
		this.setUtente(utente);
		this.setQuantita(quantita);
		this.setProdotto(prodotto);
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public int getId_prodotto() {
		return id_ordine;
	}

	public void setId_prodotto(int id_ordine) {
		this.id_ordine = id_ordine;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
