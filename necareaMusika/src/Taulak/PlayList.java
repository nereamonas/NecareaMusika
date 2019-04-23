package Taulak;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

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
}
