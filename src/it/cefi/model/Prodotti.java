package it.cefi.model;

public class Prodotti {
	
	private int quantita;
	private double prezzo_unitario;
	private String nome_prodotto;
	private String img;
	
	public Prodotti () {}
	
	public Prodotti(int quantita, double prezzo_unitario, String nome_prodotto, String img) {
		this.setQuantita(quantita);
		this.setPrezzo_unitario(prezzo_unitario);
		this.setNome_prodotto(nome_prodotto);
		this.setImg(img);
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo_unitario() {
		return prezzo_unitario;
	}

	public void setPrezzo_unitario(double prezzo_unitario) {
		this.prezzo_unitario = prezzo_unitario;
	}

	public String getNome_prodotto() {
		return nome_prodotto;
	}

	public void setNome_prodotto(String nome_prodotto) {
		this.nome_prodotto = nome_prodotto;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	

}
