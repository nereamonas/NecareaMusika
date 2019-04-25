package Taulak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

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
	
	public void bereArtistakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM jarraituartista");// WHERE erabiltzaileuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	    	if (rs.getString("ERABILTZAILEUSER").equals(user)) {
	    		String arKode = rs.getString("ARTISTAKODE");
	    		//System.out.println(String.format("%S",arKode));
	    		Artista a=n.bilatuArtista(arKode);
	    		this.nireArtistak.add(a);
	    	}
	    }
	    rs.close();
	    statement.close();
	}
	
	public void bereAlbumakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM gordealbum");// WHERE erabiltzaileuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	    	if (rs.getString("ERABILTZAILEUSER").equals(user)) {
	    		String arKode = rs.getString("ARTISTAKODE");
	    		int alId = rs.getInt("ALBUMID");
	    		//System.out.println(String.format("%s,%d",arKode,alId));
	    		Albuma a=n.bilatuAlbuma(arKode,alId);
	    		this.nireAlbumak.add(a);
	    	}
	    }
	    rs.close();
	    statement.close();
	}

	public void bereAbestiakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM gordeabesti");// WHERE erabiltzaileuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	    	if (rs.getString("ERABILTZAILEUSER").equals(user)) {
	    		String arKode = rs.getString("ARTISTAKODE");
	    		int abId = rs.getInt("ABESTIID");
	    		//System.out.println(String.format("%s, %d",arKode,abId)); //?
	    		Abestia a= n.bilatuAbestia(arKode,abId);
	    		this.nireAbestiak.add(a);
	    	}
	    }
	    rs.close();
	    statement.close();
	}

	public void berePlaylistakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM gordeplaylist");// WHERE erabiltzaileuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	    	if (rs.getString("ERABILTZAILEUSER").equals(user)) {
	    		int plId = rs.getInt("PLAYLISTID");
	    		//System.out.println(String.format("%S",plId));
	    		PlayList pl=n.bilatuPlayLista(plId);
	    		this.nirePlayListak.add(pl);
	    	}
	    }
	    rs.close();
	    statement.close();
	}

	public void bereJarraituakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM jarraituerabiltzaile");// WHERE noruser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	    	if (rs.getString("NORUSER").equals(user)) {
	    		String nori = rs.getString("NORIUSER");
	    		//System.out.println(String.format("%S",nori));
	    		Erabiltzaile e=n.bilatuErabiltzailea(nori);
	    		this.jarraitu.add(e);
	    	}
	    }
	    rs.close();
	    statement.close();
	}

	public void bereJarraitzaileakHartu(String user) throws SQLException {
		Connection konexioa=Konektatu.getConnection();
	    java.sql.Statement statement = konexioa.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM jarraituerabiltzaile");// WHERE noriuser="+user);
	    Necarea n=Necarea.getNecarea();
	    while (rs.next()) {
	    	if (rs.getString("NORIUSER").equals(user)) {
	    		String nor = rs.getString("NORUSER");
	    		//System.out.println(String.format("%S",nor));
	    		Erabiltzaile e=n.bilatuErabiltzailea(nor);
	    		this.jarraitzaile.add(e);
	    	}
	    }
	    rs.close();
	    statement.close();
	}
	
	public boolean userBerdinaDu(String u) {
		return this.user.equals(u);
	}
	
	public void zureDatuakInprimatu() {
		System.out.println("User -> "+this.user);
		System.out.print("Nire artistak -> ");
		Iterator<Artista> itr=nireArtistak.iterator();
		Artista ar=null;
		while (itr.hasNext()) {
			ar=itr.next();
			if(!itr.hasNext()) {
				ar.zureIzenaInprimatu();
			}else {
				ar.zureIzenaInprimatu();
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("Nire albumak -> ");
		Iterator<Albuma> itr2=nireAlbumak.iterator();
		Albuma al=null;
		while (itr2.hasNext()) {
			al=itr2.next();
			if(!itr2.hasNext()) {
				al.zureIzenaInprimatu();
			}else {
				al.zureIzenaInprimatu();
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("Nire abestiak -> ");
		Iterator<Abestia> itr3=nireAbestiak.iterator();
		Abestia ab=null;
		while (itr3.hasNext()) {
			ab=itr3.next();
			if(!itr3.hasNext()) {
				ab.zureIzenaInprimatu();
			}else {
				ab.zureIzenaInprimatu();
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("Nire playlistak -> ");
		Iterator<PlayList> itr4=nirePlayListak.iterator();
		PlayList pl=null;
		while (itr4.hasNext()) {
			pl=itr4.next();
			if(!itr4.hasNext()) {
				pl.zureIzenaInprimatu();
			}else {
				pl.zureIzenaInprimatu();
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("Nire jarraituak -> ");
		Iterator<Erabiltzaile> itr5=jarraitu.iterator();
		Erabiltzaile e1=null;
		while (itr5.hasNext()) {
			e1=itr5.next();
			if(!itr5.hasNext()) {
				e1.zureIzenaInprimatu();
			}else {
				e1.zureIzenaInprimatu();
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("Nire jarraitzaileak -> ");
		Iterator<Erabiltzaile> itr6=jarraitzaile.iterator();
		Erabiltzaile e2=null;
		while (itr6.hasNext()) {
			e2=itr6.next();
			if(!itr6.hasNext()) {
				e2.zureIzenaInprimatu();
			}else {
				e2.zureIzenaInprimatu();
				System.out.print(", ");
			}
		}
	}
	
	public void zureIzenaInprimatu() {
		System.out.print(this.user);
	}
	
	public boolean pasahitzaKonprobatu(String pas) {
		return this.pasahitza.equals(pas);
	}
	
	public void pasahitzaAldatu(String pas) {
		this.pasahitza=pas;
		try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "UPDATE " + "erabiltzaile" + " SET pasahitza ="+ pas+" WHERE user = \"" + this.user + "\"";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
		 }
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void gehituAbestia(Abestia a) {
		this.nireAbestiak.add(a);
		try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "INSERT INTO " + "gordeabesti" + " VALUES("+ "\"" + a.getArtistaKode() + "\", "+ "\"" + a.getId() + "\", "+"\""+ this.user+ "\")";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
		 }
	}
	
	public void gehituAlbuma(Albuma a) {
		this.nireAlbumak.add(a);
		try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "INSERT INTO " + "gordealbum" + " VALUES("+ "\"" + a.getArtistaKode() + "\", "+ "\"" + a.getId() + "\", "+"\""+ this.user+ "\")";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
		 }
	}
	
	public void gehituArtista(Artista a) {
		this.nireArtistak.add(a);
		try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "INSERT INTO " + "jarraituartista" + " VALUES("+ "\"" + a.getKode() + "\", "+ "\"" + this.user+ "\")";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
		 }
	}
	
	public void gehituJarraitua(Erabiltzaile a) {
		this.jarraitu.add(a);
		try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "INSERT INTO " + "jarraituerabiltzaile" + " VALUES("+ "\"" + this.user + "\", "+ "\"" + a.getUser()+ "\")";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
		 }
	}
	
	public void gehituJarraitzaile(Erabiltzaile a) {
		this.jarraitzaile.add(a);
	}
	
	public void gehituPlaylist(PlayList pl) {
		this.nirePlayListak.add(pl);
		try {
			 Connection konexioa=Konektatu.getConnection();
		     String Query = "INSERT INTO " + "gordealbum" + " VALUES("+ "\"" + pl.getKode() + "\", "+ "\"" + pl.getErabiltzailea() + "\", "+"\""+ this.user+ "\")";
		     java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
		 } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
		 }
	}
	
	public Vector jarraituBektorea() {
		Vector bek=new Vector();
		for(int i=0;i<this.jarraitu.size();i++) {
			   String s=this.jarraitu.get(i).getUser();
			   bek.addElement(s);
		   }
		return bek;
	}
	
	public Vector abestiBektorea() {
		Vector bek=new Vector();
		for(int i=0;i<this.nireAbestiak.size();i++) {
			   String s=this.nireAbestiak.get(i).getIzena();
			   bek.addElement(s);
		   }
		return bek;
	}
	
	public Vector albumBektorea() {
		Vector bek=new Vector();
		for(int i=0;i<this.nireAlbumak.size();i++) {
			   String s=this.nireAlbumak.get(i).getIzena();
			   bek.addElement(s);
		   }
		return bek;
	}
	
	public Vector artistaBektorea() {
		Vector bek=new Vector();
		for(int i=0;i<this.nireArtistak.size();i++) {
			   String s=this.nireArtistak.get(i).getIzena();
			   bek.addElement(s);
		   }
		return bek;
	}
	
	public Vector playlistBektorea() {
		Vector bek=new Vector();
		for(int i=0;i<this.nirePlayListak.size();i++) {
			   String s=this.nirePlayListak.get(i).getIzena();
			   bek.addElement(s);
		   }
		return bek;
	}
	
	public boolean jarraitzenDu(String er) {
		boolean aurkitua=false;
		Iterator<Erabiltzaile> itr=jarraitu.iterator();
		Erabiltzaile e=null;
		while(itr.hasNext()&&!aurkitua) {
			e=itr.next();
			if(e.getUser().equals(this.user)) {
				aurkitua=true;
			}
		}
		return aurkitua;
	}
}
