package Taulak;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import necareaMusika.Konektatu;

public class Albuma {
	private int id;
	private String artistaKode;
	private String izena;
	private Time denbora;
	private Date data;
	private int likeKop;
	private int abestiKop;
	private ArrayList<Abestia> abestiak;//??
	private ArrayList<String> generoak;//??
	
	public Albuma(int pId, String pArKode, String pIzena, Time pDenb, Date pData, int pLike, int pAbKop) {
		this.id=pId;
		this.artistaKode=pArKode;
		this.izena=pIzena;
		this.denbora=pDenb;
		this.data=pData;
		this.likeKop=pLike;
		this.abestiKop=pAbKop;
		this.abestiak=new ArrayList<Abestia>();
		this.generoak=new ArrayList<String>();
	}
	
	public void bereAbestiakHartu(int alId) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM abestia WHERE albumkode="+alId);
	    while (rs.next()) {
	        int id = rs.getInt("ID");
	        String arKode = rs.getString("ARTISTAKODE");
	        String izen = rs.getString("IZENA");
	        Time denb = rs.getTime("DENBORA");
	        Date data = rs.getDate("DATA");
	        int lKop = rs.getInt("LIKEKOP");
	        String letra = rs.getString("LETRA");
	        int albumId = rs.getInt("ALBUMKODE");
	        //System.out.println(String.format("%S, %s,%t,%t,%d,%s,%d", id,arKode,izen,denb,data,lKop,letra,albumId));
	        Abestia a=new Abestia(id,arKode,izen,denb,data,lKop,letra,albumId);
	        this.abestiak.add(a);
	    }
	    rs.close();
	    statement.close();
	}
	
	public void bereGeneroakHartu(int alId) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM generoak WHERE id="+alId);
	    while (rs.next()) {
	        String genero = rs.getString("GENEROA");
	        //System.out.println(String.format("%S",genero));
	        this.generoak.add(genero);
	    }
	    rs.close();
	    statement.close();
	}
	
	public void abestiaGehitu(Abestia a) {
		this.abestiak.add(a);
	}
	
	public Abestia bilatuAbestia(int abId) {
		boolean aurkitua=false;
		Iterator<Abestia> itr=abestiak.iterator();
		Abestia a=null;
		while(itr.hasNext()&&!aurkitua) {
			a=itr.next();
			if(a.idBerdinaDu(abId)) {
				aurkitua=true;
			}
		}
		return a;
	}
	
	public Abestia bilatuAbestiaIzenaz(String abestia) {
		boolean aurkitua=false;
		Iterator<Abestia> itr=abestiak.iterator();
		Abestia a=null;
		while(itr.hasNext()&&!aurkitua) {
			a=itr.next();
			if(a.izenBerdinaDu(abestia)) {
				aurkitua=true;
			}
		}
		return a;
	}
	
	public boolean kodeBerdinaDu(int id) {
		return this.id==id;
	}
	
	public void zureDatuakInprimatu() {
		System.out.println("	Izena -> "+this.izena);
		System.out.print("	Generoak -> ");
		Iterator<String> itr=generoak.iterator();
		String g=null;
		while (itr.hasNext()) {
			g=itr.next();
			if(!itr.hasNext()) {
				System.out.print(g);
			}else {
				System.out.print(g+", ");
			}
		}
		System.out.println();
		System.out.print("	Abestiak -> ");
		Iterator<Abestia> itr2=abestiak.iterator();
		Abestia a=null;
		while (itr2.hasNext()) {
			a=itr2.next();
			if(!itr2.hasNext()) {
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
	
	public String getIzena() {
		return this.izena;
	}
	
	public boolean izenBerdinaDu(String izen) {
		return this.izena.equals(izen);
	}
	
	public String getArtistaKode() {
		return this.artistaKode;
	}
	
	public int getId() {
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
	
	public int getAbestiKop() {
		return this.abestiKop;
	}
	
	public void likeEmanDiote() {
		this.likeKop++;
	}
	
	public Vector abestiakBektoreanSartu(Vector bek) {
		for(int i=0;i<this.abestiak.size();i++) {
			String s=this.abestiak.get(i).getIzena();
			bek.addElement(s);
		}
		return bek;
	}
}
