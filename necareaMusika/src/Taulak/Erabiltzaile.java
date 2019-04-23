package Taulak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import necareaMusika.Konektatu;
import necareaMusika.Necarea;

public class Erabiltzaile {
	private String user;
	private String pasahitza;
	private String email;
	private ArrayList<Abestia> nireAbestiak;//??
	private ArrayList<Albuma> nireAlbumak;//??
	private ArrayList<Artista> nireArtistak;//??
	private ArrayList<PlayList> nirePlayListak;//??
	private ArrayList<Erabiltzaile> jarraitu;//??
	private ArrayList<Erabiltzaile> jarraitzaile;//??
	
	public Erabiltzaile(String pUser, String pPas, String pEmail) {
		this.user=pUser;
		this.pasahitza=pPas;
		this.email=pEmail;
		this.nireAbestiak=new ArrayList<Abestia>();
		this.nireAlbumak=new ArrayList<Albuma>();
		this.nireArtistak=new ArrayList<Artista>();
		this.nirePlayListak=new ArrayList<PlayList>();
		this.jarraitu=new ArrayList<Erabiltzaile>();
		this.jarraitzaile=new ArrayList<Erabiltzaile>();
	}
	
	public void abestiaGehitu(Abestia a) {
		this.nireAbestiak.add(a);
	}
	
	public void albumaGehitu(Albuma a) {
		this.nireAlbumak.add(a);
	}
	
	public void artistaGehitu(Artista a) {
		this.nireArtistak.add(a);
	}
	
	public void abestiaGehitu(PlayList p) {
		this.nirePlayListak.add(p);
	}
	
	public void jarraituaGehitu(Erabiltzaile e) {
		this.jarraitu.add(e);
	}
	
	public void jarraitzaileaGehitu(Erabiltzaile e) {
		this.jarraitzaile.add(e);
	}
	
	public void bereArtistakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM jarraituartista WHERE erabiltzaileuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	        String arKode = rs.getString("ARTISTAKODE");
	        System.out.println(String.format("%S",arKode));
	        Artista a=n.bilatuArtista(arKode);
	        this.nireArtistak.add(a);
	    }
	    rs.close();
	    statement.close();
	}
	
	public void bereAlbumakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM gordealbum WHERE erabiltzaileuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	    	String arKode = rs.getString("ARTISTAKODE");
	        int alId = rs.getInt("ALBUMID");
	        System.out.println(String.format("%s,%d",arKode,alId));
	        Albuma a=n.bilatuAlbuma(arKode,alId);
	        this.nireAlbumak.add(a);
	    }
	    rs.close();
	    statement.close();
	}

	public void bereAbestiakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM gordeabesti WHERE erabiltzaileuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	        String arKode = rs.getString("ARTISTAKODE");
	        int abId = rs.getInt("ABESTIID");
	        System.out.println(String.format("%s, %d",arKode,abId)); //?
	        Abestia a= n.bilatuAbestia(arKode,abId);
	        this.nireAbestiak.add(a);
	    }
	    rs.close();
	    statement.close();
	}

	public void berePlaylistakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM gordeplaylist WHERE erabiltzaileuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	        int plId = rs.getInt("PLAYLISTID");
	        System.out.println(String.format("%S",plId));
	        PlayList pl=n.bilatuPlayLista(plId);
	        this.nirePlayListak.add(pl);
	    }
	    rs.close();
	    statement.close();
	}

	public void bereJarraituakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM jarraituerabiltzaile WHERE noruser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	        String nori = rs.getString("NORIUSER");
	        System.out.println(String.format("%S",nori));
	        Erabiltzaile e=n.bilatuErabiltzailea(nori);
	        this.jarraitu.add(e);
	    }
	    rs.close();
	    statement.close();
	}

	public void bereJarraitzaileakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM jarraituerabiltzaile WHERE noriuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	        String nor = rs.getString("NORUSER");
	        System.out.println(String.format("%S",nor));
	        Erabiltzaile e=n.bilatuErabiltzailea(nor);
	        this.jarraitzaile.add(e);
	    }
	    rs.close();
	    statement.close();
	}
	
	public boolean userBerdinaDu(String u) {
		return this.user==u;
	}
}
