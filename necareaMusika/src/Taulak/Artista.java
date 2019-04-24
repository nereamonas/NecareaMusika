 package Taulak;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.print.attribute.DateTimeSyntax;

import necareaMusika.Konektatu;

public class Artista {
	private String kodea;
	private String biografia;
	private int likeKop;
	private String taldeIzena;
	private ArrayList<String> izenak; //??
	private ArrayList<Albuma> albumak; //??
	private ArrayList<Kontzertua> kontzertuak;
	
	public Artista(String pKodea, String pBio,int pLike, String pTalde) {
		this.kodea=pKodea;
		this.biografia=pBio;
		this.likeKop=pLike;
		this.taldeIzena=pTalde;
		this.izenak=new ArrayList<String>();
		this.albumak=new ArrayList<Albuma>();
		this.kontzertuak=new ArrayList<Kontzertua>();
	}
	
	public void izenaGehitu(String i) {
		this.izenak.add(i);
	}
	
	public boolean kodeBerdinaDu(String kode) {
		return this.kodea.equals(kode);
	}
	
	public boolean izenBeraDu(String iz) {
		return this.taldeIzena.equals(iz);
	}
	
	public Abestia bilatuAbestia(int abId) {
		boolean aurkitua=false;
		Iterator<Albuma> itr=albumak.iterator();
		Albuma a=null;
		Abestia ab=null;
		while(itr.hasNext()&&!aurkitua) {
			a=itr.next();
			ab=a.bilatuAbestia(abId);
			if (ab!=null) {
				aurkitua=true;
			}
		}
		return ab;
	}
	
	public Abestia bilatuAbestiaIzenaz(String abestia) {
		boolean aurkitua=false;
		Iterator<Albuma> itr=albumak.iterator();
		Albuma a=null;
		Abestia ab=null;
		while(itr.hasNext()&&!aurkitua) {
			a=itr.next();
			ab=a.bilatuAbestiaIzenaz(abestia);
			if (ab!=null) {
				aurkitua=true;
			}
		}
		return ab;
	}
	
	public Albuma bilatuAlbuma(int alId) {
		boolean aurkitua=false;
		Iterator<Albuma> itr=albumak.iterator();
		Albuma a=null;
		while(itr.hasNext()&&!aurkitua) {
			a=itr.next();
			if(a.kodeBerdinaDu(alId)) {
				aurkitua=true;
			}
		}
		return a;
	}
	
	public Albuma bilatuAlbumaIzenaz(String album) {
		boolean aurkitua=false;
		Iterator<Albuma> itr=albumak.iterator();
		Albuma a=null;
		while(itr.hasNext()&&!aurkitua) {
			a=itr.next();
			if(a.izenBerdinaDu(album)) {
				aurkitua=true;
			}
		}
		return a;
	}
	
	public void zureDatuakInprimatu() {
		System.out.println("Taldearen izena -> "+this.taldeIzena);
		System.out.print("Taldekideak -> ");
		Iterator<String> itr=this.izenak.iterator();
		String i=null;
		while (itr.hasNext()) {
			i=itr.next();
			if(!itr.hasNext()) {
				System.out.print(i);
			}else {
				System.out.print(i+", ");
			}
		}
		System.out.println();
		System.out.println("Albumak -> ");
		Iterator<Albuma> itr2=this.albumak.iterator();
		Albuma a=null;
		while(itr2.hasNext()) {
			a=itr2.next();
			a.zureDatuakInprimatu();
		}
		System.out.println();
		System.out.print("Kontzertuak -> ");
		Iterator<Kontzertua> itr3=this.kontzertuak.iterator();
		Kontzertua k=null;
		while(itr3.hasNext()) {
			k=itr3.next();
			if(!itr3.hasNext()) {
				k.nonInprimatu();
			}else {
				k.nonInprimatu();
				System.out.print("; ");
			}
		}
	}
	
	public void zureIzenaInprimatu() {
		System.out.print(this.taldeIzena);
	}
	
	public void bereAlbumakHartu(String kodea) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM albuma WHERE artistakode="+kodea);
	    while (rs.next()) {
	        int alId = rs.getInt("ID");
	        String arKode = rs.getString("ARTISTAKODE");
	        String izen = rs.getString("IZENA");
	        Time denb = rs.getTime("DENBORA");
	        Date data = rs.getDate("DATA");
	        int lKop = rs.getInt("LIKEKOP");
	        int abKop = rs.getInt("ABESTIKOP");
	        //System.out.println(String.format("%S, %s,%tr,%tF,%d,%d", alId,arKode,izen,denb,data,lKop,abKop));
	        Albuma a=new Albuma(alId,arKode,izen,denb,data,lKop,abKop);
	        this.albumak.add(a);
	        a.bereAbestiakHartu(alId);
	        a.bereGeneroakHartu(alId);
	    }
	    rs.close();
	    statement.close();
	}
	
	public void bereIzenakHartu(String kodea) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM izenak WHERE kodea="+kodea);
	    while (rs.next()) {
	        String kode = rs.getString("KODEA");
	        String izena = rs.getString("IZENA");
	        //System.out.println(String.format("%S, %s", kode, izena));
	        this.izenak.add(izena);
	    }
	    rs.close();
	    statement.close();
	}
	
	public void bereKontzertuakHartu(String kodea) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM kontzertua WHERE artistakode="+kodea);
	    while (rs.next()) {
	        String non = rs.getString("NON");
	        Date noiz =rs.getDate("DATETIME");
	        //System.out.println(String.format("%S, %t", non,noiz));
	        Kontzertua k=new Kontzertua(non,noiz,kodea);
	        this.kontzertuak.add(k);
	    }
	    rs.close();
	    statement.close();
	}
	
	public String getIzena() {
		return this.taldeIzena;
	}
	
	public String getBiografia() {
		return this.biografia;
	}
	
	public String getKode() {
		return this.kodea;
	}
	
	public int getLikeKop() {
		return this.likeKop;
	}
	
	public void likeEmanDiote() {
		likeKop++;
	}
	
	public Vector albumakBektoreanSartu(Vector bek) {
		for(int i=0;i<this.albumak.size();i++) {
			   String s=this.albumak.get(i).getIzena();
			   bek.addElement(s);
		   }
		   return bek;
	}
	
	public Vector abestiakBektoreanSartu(Vector bek) {
		for(int i=0;i<this.albumak.size();i++) {
			   bek=this.albumak.get(i).abestiakBektoreanSartu(bek);  
		}
		return bek;
	}
	
	public Vector kontzertuakBektoreanSartu(Vector bek) throws SQLException {
		for(int i=0;i<this.kontzertuak.size();i++) {
			   String s=this.kontzertuak.get(i).informazioa();
			   bek.addElement(s);
		   }
		   return bek;
	}
	
	public Vector izenakBektoreanSartu(Vector bek) {
		for(int i=0;i<this.izenak.size();i++) {
			String s=this.izenak.get(i);
		}
		return bek;
	}
}