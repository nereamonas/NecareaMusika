package Taulak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import necareaMusika.Konektatu;

public class Izenak {

	//Atributuak
	private String kodea;
	private String izena;
	
	//Eraikitzaile
	public Izenak(String pKodea,String pIzen) {
		this.kodea=pKodea;
		this.izena=pIzen;
	}
	

	
	//Metodoak
	public void izenakHartu() throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM izenak");
	    while (rs.next()) {
	        String kodea = rs.getString("KODEA");
	        String izena = rs.getString("IZENA");
	        System.out.println(String.format("%S, %s", kodea, izena));
	    }
	    rs.close();
	    statement.close();
	}
	
	public void izenaGehitu(Izenak i) {
		 try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "INSERT INTO " + "Izenak" + " VALUES("+ "\"" + i.kodea + "\", "+ "\"" + i.izena + "\")";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
		 }
	}
	
	
	public void izenaEzabatu(Izenak i) {
	        try {
	    		Connection konexioa=Konektatu.getConnection();
	            String Query = "DELETE FROM " + "IZENAK" + " WHERE IZENA = \"" + i.izena + "\"";
	            java.sql.Statement st = konexioa.createStatement();
	            st.executeUpdate(Query);
	 
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	            JOptionPane.showMessageDialog(null, "Errore bat sortu da izena ezabatzean");
	        }
	    }
	
}
