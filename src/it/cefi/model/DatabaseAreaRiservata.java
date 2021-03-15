package it.cefi.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseAreaRiservata {
	
	private static final String HOST= "jdbc:mysql://localhost:3306/webshop?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Goldberg91";
	
	//costruttore privato ancora meglio di dichiararla abstract
	private DatabaseAreaRiservata() { }
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean validateAccount(String user, String Password) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			String query = "select count(*) from utenti where `username` = ? and `password`= MD5(?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, user);
			statement.setString(2, Password);
			
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			return resultSet.getInt(1) == 1;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean SignAccount(String user) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			String query = "select count(*) from utenti where `username` = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, user);
			
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return resultSet.getInt(1) == 1;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
	
	public static void InsertUser (String user, String pass) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			
			String query = "INSERT INTO utenti (`username`, `password`)"
			+ " values (?, MD5(?))";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, user);
			statement.setString(2, pass);
			
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void insertProduct( ArrayList<Prodotti> prodotti) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			String query = "SELECT * FROM prodotti";
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				prodotti.add(new Prodotti(resultSet.getInt("quantita"), 
						resultSet.getDouble("prezzo_unitario"), 
						resultSet.getString("nome_prodotto"),
						resultSet.getString("img")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void insertOrdini (String utente, String prodotto, int quantita) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			
			String query = "INSERT INTO ordini (utente, prodotto, quantita)"
			+ " values (?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, utente);
			statement.setString(2, prodotto);
			statement.setInt(3, quantita);
			
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	} 
	
public static void getUtenti( ArrayList<String> utenti) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			String query = "SELECT * FROM utenti";
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
						
			while(resultSet.next()) {
				
				if(resultSet.getInt("id_utente") != 1) {
					utenti.add(resultSet.getString("username"));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void getOrder( ArrayList<Ordini> ordini, Object utente) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			String ute =(String)utente;
			StringBuilder query = new StringBuilder();
			
			if(ute.contentEquals("")) {
				query.append("SELECT * FROM ordini");
				
			}else {
				query.append("SELECT * FROM ordini WHERE utente='"+ute+"'");
			}
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query.toString());
						
			while(resultSet.next()) {
				
				ordini.add(new Ordini(
						resultSet.getDate("data_ordine"),
						resultSet.getInt("id_ordine"),
						resultSet.getString("utente"),
						resultSet.getInt("quantita"),
						resultSet.getString("prodotto")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void uploadQuantity (int quantita, String nome_prodotto) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			
			String query = "UPDATE prodotti SET quantita=? WHERE nome_prodotto=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, quantita);
			statement.setString(2, nome_prodotto);
			
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void addProduct (String img, int quantita, String name_product, float price_product) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			
			String query = "INSERT INTO prodotti (img, quantita, nome_prodotto, prezzo_unitario)"
			+ " values (?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, img);
			statement.setInt(2, quantita);
			statement.setString(3, name_product);
			statement.setFloat(4, price_product);
			
			statement.executeUpdate();
		
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void updateProduct (String img, String nome_prodotto, int quantita, float price) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			
			String query = "UPDATE prodotti SET img=?, quantita=?, prezzo_unitario=?  WHERE nome_prodotto=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, img);
			statement.setInt(2, quantita);
			statement.setFloat(3, price);
			statement.setString(4, nome_prodotto);
			
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void deleteProduct (String name_product) {
		
		try(Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);){
			
			
			String query = "DELETE FROM prodotti WHERE nome_prodotto=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, name_product);
			
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
}
