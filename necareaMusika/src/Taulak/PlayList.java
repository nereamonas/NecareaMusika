package Taulak;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import necareaMusika.Konektatu;
import necareaMusika.Necarea;

public class PlayList {
	private int id;
	private String erabiltzaileUser;
	private String izena;
	private Time denbora;
	private Date data;
	private int likeKop;
	private String deskribapena;
	private ArrayList<Abestia> abestiak;
	
	public PlayList(int pId, String pEr, String pIzen, Time pDenb, Date pData, int pLike, String pDeskr) {
		this.id=pId;
		this.erabiltzaileUser=pEr;
		this.izena=pIzen;
		this.denbora=pDenb;
		this.data=pData;
		this.likeKop=pLike;
		this.deskribapena=pDeskr;
		this.abestiak=new ArrayList<Abestia>();
	}
	
	public void gehituAbestia(Abestia a) {
		this.abestiak.add(a);
	}
	
	public void bereAbestiakHartu() throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM dago WHERE playlistid="+this.id);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	        String arKode = rs.getString("ARTISTAKODE");
	        int abId = rs.getInt("ABESTIID");
	        System.out.println(String.format("%s, %d",arKode,abId)); //?
	        Abestia a= n.bilatuAbestia(arKode,abId);
	        this.abestiak.add(a);
	    }
	    rs.close();
	    statement.close();
	}
	
	public boolean kodeBerdinaDu(int plId) {
		return this.id==plId;
	}
	
	public void zureDatuakInprimatu() {
		System.out.println("	Izena -> "+this.izena);
		System.out.print("	Abestiak -> ");
		Iterator<Abestia> itr=abestiak.iterator();
		Abestia a=null;
		while (itr.hasNext()) {
			a=itr.next();
			if(!itr.hasNext()) {
				a.zureIzenaInprimatu();
			}else {
				a.zureIzenaInprimatu();
				System.out.print(", ");
			}
		}
	}
	
	public void zureIzenaInprimatu() {
		System.out.print(this.izena);
	}
	
	public boolean izenBeraDu(String iz) {
		return this.izena.equals(iz);
	}
	
	public String getErabiltzailea() {
		return this.erabiltzaileUser;
	}
	
	public int getKode() {
		return this.id;
	}
	
	public String getDenbora() {
		return this.denbora.toString();
	}
	
	public String getData() {
		return this.data.toString();
	}
	
	public int getLikeKop() {
		return this.likeKop;
	}
	
	public String getDeskribapena() {
		return this.deskribapena;
	}
	
	public void likeEmanDiote() {
		this.likeKop++;
		try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "UPDATE " + "playlist" + " SET likekop ="+ this.likeKop+" WHERE id = \"" + this.id + "\"";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            //JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da like ematean");
		 }
	}
	
	public void likeKendu() {
		this.likeKop--;
		try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "UPDATE " + "playlist" + " SET likekop ="+ this.likeKop+" WHERE id = \"" + this.id + "\"";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            //JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da like ematean");
		 }
	}
	
	public String getIzena() {
		return this.izena;
	}
	
	public Vector abestiakBektoreanSartu(Vector bek) {
		for(int i=0;i<this.abestiak.size();i++) {
			String s=this.abestiak.get(i).getIzena();
			bek.addElement(s);
		}
		return bek;
	}
}