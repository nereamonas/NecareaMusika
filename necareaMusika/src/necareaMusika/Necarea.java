package necareaMusika;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import Taulak.Abestia;
import Taulak.Albuma;
import Taulak.Artista;
import Taulak.Erabiltzaile;
import Taulak.PlayList;
 

public class Necarea {

		//atributuak
	    private static Necarea nireNecarea=null;
	    
	    private Connection konexioa=null;
	    
	    private ArrayList<Erabiltzaile> erabiltzaileak;
	    private ArrayList<Artista> artistak;
	    private ArrayList<PlayList> playlistak;
	    
	            
	//eraikitzailea
	            
	    private Necarea() throws SQLException { 
	    	Konektatu k= new Konektatu();
	    	this.konexioa=k.getConnection();
	    	this.erabiltzaileak= new ArrayList<Erabiltzaile>();
	    	this.artistak= new ArrayList<Artista>();
	    	this.playlistak= new ArrayList<PlayList>();
	    }    
	    
	    public static synchronized Necarea getNecarea() throws SQLException {
	        if (Necarea.nireNecarea==null) {
	        	Necarea.nireNecarea= new Necarea();
	        }
	        return Necarea.nireNecarea;
	    }
	    
	    
	    //Metodoak
	    //CARGAR EN EL ORDEN QUE ESTAN PUESTOS
	    public void guztiaHartu() throws SQLException {
	    	this.artistakHartu();
	    	this.playlistakHartu();
	    	this.erabiltzaileakHartu();
	    }
		
		public void artistakHartu() throws SQLException {
			Connection konexioa=Konektatu.getConnection();
		    java.sql.Statement statement = konexioa.createStatement();
		    ResultSet rs = statement.executeQuery("SELECT * FROM artista");
		    while (rs.next()) {
		        String kodea = rs.getString("KODEA");
		        String biografia = rs.getString("BIOGRAFIA");
		        int likeKop = rs.getInt("LIKEKOP");
		        String taldeIzena = rs.getString("TALDEIZENA");
		        //System.out.println(String.format("%s, %s, %d, %s",kodea,biografia, likeKop,taldeIzena)); //?
		        Artista a= new Artista(kodea,biografia,likeKop,taldeIzena);
		        this.artistak.add(a);
		        a.bereAlbumakHartu(kodea);
		        a.bereIzenakHartu(kodea);
		        a.bereKontzertuakHartu(kodea);
		    }
		    rs.close();
		    statement.close();
		}
		
		public void playlistakHartu() throws SQLException {
			Connection konexioa=Konektatu.getConnection();
		    java.sql.Statement statement = konexioa.createStatement();
		    ResultSet rs = statement.executeQuery("SELECT * FROM playlist");
		    while (rs.next()) {
		        int id = rs.getInt("ID");
		        String erUser = rs.getString("ERABILTZAILEUSER");
		        String izena = rs.getString("IZENA");
		        Time denbora = rs.getTime("DENBORA");
		        Date data = rs.getDate("DATA");
		        int likeKop = rs.getInt("LIKEKOP");
		        String deskr = rs.getString("DESKRIBAPENA");
		        //System.out.println(String.format("%d,%s, %s,%t,%t %d, %s",id,erUser,izena,denbora,data, likeKop,deskr)); //?
		        PlayList p= new PlayList(id,erUser,izena,denbora,data, likeKop,deskr);
		        this.playlistak.add(p);
		        p.bereAbestiakHartu();
		    }
		    rs.close();
		    statement.close();
		}
		
		public void erabiltzaileakHartu() throws SQLException {
			Connection konexioa=Konektatu.getConnection();
		    java.sql.Statement statement = konexioa.createStatement();
		    ResultSet rs = statement.executeQuery("SELECT * FROM erabiltzaile");
		    while (rs.next()) {
		        String user = rs.getString("USER");
		        String pasahitza = rs.getString("PASAHITZA");
		        String email = rs.getString("EMAIL");
		        //System.out.println(String.format("%s, %s, %s", user, pasahitza,email)); //?
		        Erabiltzaile e= new Erabiltzaile(user,pasahitza,email);
		        this.erabiltzaileak.add(e);
		        e.bereArtistakHartu(user);
		        e.bereAlbumakHartu(user);
		        e.bereAbestiakHartu(user);
		        e.berePlaylistakHartu(user);
		        e.bereJarraituakHartu(user);
		        e.bereJarraitzaileakHartu(user);
		    }
		    rs.close();
		    statement.close();
		}
		
		
		
		
		public Abestia bilatuAbestia(String arKode,int abId) {
			boolean aurkitua=false;
			Iterator<Artista> itr=artistak.iterator();
			Artista a=null;
			Abestia ab=null;
			while(itr.hasNext()&&!aurkitua) {
				a=itr.next();
				if(a.kodeBerdinaDu(arKode)) {
					ab=a.bilatuAbestia(abId);
					if (ab!=null) {
						aurkitua=true;
					}
				}
			}
			return ab;
		}
		
		public Artista bilatuArtista(String arKode) {
			boolean aurkitua=false;
			Iterator<Artista> itr=artistak.iterator();
			Artista a=null;
			while(itr.hasNext()&&!aurkitua) {
				a=itr.next();
				if(a.kodeBerdinaDu(arKode)) {
					aurkitua=true;
				}
			}
			return a;
		}
		
		public Albuma bilatuAlbuma(String arKode, int alId) {
			boolean aurkitua=false;
			Iterator<Artista> itr=artistak.iterator();
			Artista a=null;
			Albuma al=null;
			while(itr.hasNext()&&!aurkitua) {
				a=itr.next();
				if(a.kodeBerdinaDu(arKode)) {
					al=a.bilatuAlbuma(alId);
					if (al!=null) {
						aurkitua=true;
					}
				}
			}
			return al;
		}
		
		public PlayList bilatuPlayLista(int plId) {
			boolean aurkitua=false;
			Iterator<PlayList> itr=playlistak.iterator();
			PlayList pl=null;
			while(itr.hasNext()&&!aurkitua) {
				pl=itr.next();
				if(pl.kodeBerdinaDu(plId)) {
					aurkitua=true;
				}
			}
			return pl;
		}
		
		public Erabiltzaile bilatuErabiltzailea(String user) {
			boolean aurkitua=false;
			Iterator<Erabiltzaile> itr=erabiltzaileak.iterator();
			Erabiltzaile e=null;
			while(itr.hasNext()&&!aurkitua) {
				e=itr.next();
				if(e.userBerdinaDu(user)) {
					aurkitua=true;
				}
			}
			return e;
		}
		
		public void printArtistak() {
			Iterator<Artista> itr=this.artistak.iterator();
			Artista a=null;
			int kont=1;
			while(itr.hasNext()) {
				a=itr.next();
				System.out.println();
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println();
				System.out.println(kont+". ARTISTA:");
				a.zureDatuakInprimatu();
				kont++;
			}
		}
		
		public void printPlaylistak() {
			Iterator<PlayList> itr=this.playlistak.iterator();
			PlayList pl=null;
			int kont=1;
			while(itr.hasNext()) {
				pl=itr.next();
				System.out.println();
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println();
				System.out.println(kont+". PLAYLISTA:");
				pl.zureDatuakInprimatu();
				kont++;
			}
		}
		
		public void printErabiltzaileak() {
			Iterator<Erabiltzaile> itr=this.erabiltzaileak.iterator();
			Erabiltzaile e=null;
			int kont=1;
			while(itr.hasNext()) {
				e=itr.next();
				System.out.println();
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println();
				System.out.println(kont+". ERABILTZAILEA:");
				e.zureDatuakInprimatu();
				kont++;
			}
		}
		
		
		//------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------
	    //LUEGO BORRARLO DE AQUÍ
		//LOS METODOS DE AÑADIR, BORRAR Y COGER DE IZENA - EJEMPLO
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
		
		public void izenaGehitu(String kodea, String izena) {
			 try {
				 Connection konexioa=Konektatu.getConnection();
			     String Query = "INSERT INTO " + "Izenak" + " VALUES("+ "\"" + kodea + "\", "+ "\"" + izena + "\")";
			     java.sql.Statement st = konexioa.createStatement();
			            st.executeUpdate(Query);
			            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
			 } catch (SQLException ex) {
			            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
			 }
		}
		
		
		public void izenaEzabatu(String izena) {
		        try {
		    		Connection konexioa=Konektatu.getConnection();
		            String Query = "DELETE FROM " + "IZENAK" + " WHERE IZENA = \"" + izena + "\"";
		            java.sql.Statement st = konexioa.createStatement();
		            st.executeUpdate(Query);
		 
		        } catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		            JOptionPane.showMessageDialog(null, "Errore bat sortu da izena ezabatzean");
		        }
		    }
	    
		//------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //LOS COMENTO XQ DA ERRORES. PERO ESTOS SON LOS METODOS QUE TENEMOS QUE INPLEMENTAR
	    
	    
	    
	    
	    
	//ERABILTZAILEAREKIN    
	    public boolean pertsonaBilatu(String erabiltzailea) {
	    	boolean dago=false;
	    	Iterator<Erabiltzaile> itr=this.erabiltzaileak.iterator();
	    	Erabiltzaile e=null;
	    	while(itr.hasNext()&&!dago) {
	    		e=itr.next();
	    		if(e.userBerdinaDu(erabiltzailea)) {
	    			dago=true;
	    		}
	    	}
	    	return dago;
	    }
	    
	    public boolean pasahitzaKonprobatu(String erabiltzailea, String pasahitza) {
	    	boolean ondo=false;
	    	boolean aurkitua=false;
	    	Iterator<Erabiltzaile> itr=this.erabiltzaileak.iterator();
	    	Erabiltzaile e=null;
	    	while(itr.hasNext()&&!aurkitua) {
	    		e=itr.next();
	    		if(e.userBerdinaDu(erabiltzailea)) {
	    			if(e.pasahitzaKonprobatu(pasahitza)) {
	    				ondo=true;
	    			}
	    			aurkitua=true;
	    		}
	    	}
	    	
	    	return ondo;
	    }
	    
	    public void erabiltzaileaGehitu(String erabiltzailea,String pasahitza, String email) {//HAY QUE AÑADIR PARA QUE META EMAIL EN INTERFACES
	    	Erabiltzaile e=new Erabiltzaile(erabiltzailea,pasahitza,email);
	    	this.erabiltzaileak.add(e);
	    	try {
				 Connection konexioa=Konektatu.getConnection();
			     String Query = "INSERT INTO " + "erabiltzaile" + " VALUES("+ "\"" + erabiltzailea + "\", "+ "\"" + pasahitza + "\", "+"\""+ email+ "\")";
			     java.sql.Statement st = konexioa.createStatement();
			            st.executeUpdate(Query);
			            JOptionPane.showMessageDialog(null, "Datuak ongi sartu dira");
			 } catch (SQLException ex) {
			            JOptionPane.showMessageDialog(null, "Errore bat sortu da datuak sortzean");
			 }
	    }
	    
	   public void pasahitzaAldatu(String erabiltzailea,String pasahitza) {
	    	boolean aurkitua=false;
	    	Iterator<Erabiltzaile> itr=this.erabiltzaileak.iterator();
	    	Erabiltzaile e=null;
	    	while(itr.hasNext()&&!aurkitua) {
	    		e=itr.next();
	    		if(e.userBerdinaDu(erabiltzailea)) {
	    			e.pasahitzaAldatu(pasahitza);
	    			aurkitua=true;
	    		}
	    	}
	   }
	   
	   public String erabiltzailearenEMail(String e) {
		   String mail="";
		   boolean aurkitua=false;
	    	Iterator<Erabiltzaile> itr=this.erabiltzaileak.iterator();
	    	Erabiltzaile er=null;
	    	while(itr.hasNext()&&!aurkitua) {
	    		er=itr.next();
	    		if(er.userBerdinaDu(e)) {
	    			mail=er.getEmail();
	    			aurkitua=true;
	    		}
	    	}
		   return mail;
	   }
	   
	  
	 
	   
	//INPRIMIR TODO LO QUE HAY   
	   public Vector erabiltzaileGuztiak() {
		   Vector emaitza= new Vector();
		   for(int i=0;i<this.erabiltzaileak.size();i++) {
			   String s=this.erabiltzaileak.get(i).getUser();
			   emaitza.addElement(s);
		   }
		   return emaitza;
	   }
	   
	   public Vector abestiGuztiak() {
		   Vector emaitza= new Vector();
		   for(int i=0;i<this.artistak.size();i++) {
			   emaitza=this.artistak.get(i).abestiakBektoreanSartu(emaitza);
		   }
		   return emaitza;
	   }
	   
	   public Vector albumGuztiak() {
		   Vector emaitza= new Vector();
		   for(int i=0;i<this.artistak.size();i++) {
			   emaitza=this.artistak.get(i).albumakBektoreanSartu(emaitza);
		   }
		   return emaitza;
	   }
	   
	   public Vector artistaGuztiak() {
		   Vector emaitza= new Vector();
		   for(int i=0;i<this.artistak.size();i++) {
			   String s=this.artistak.get(i).getIzena();
			   emaitza.addElement(s);
		   }
		   return emaitza;
	   }
	   
	   public Vector playlistGuztiak() {
		   Vector emaitza= new Vector();
		   for(int i=0;i<this.playlistak.size();i++) {
			   String s=this.playlistak.get(i).getIzena();
			   emaitza.addElement(s);
		   }
		   return emaitza;
	   }
	   
	   public Vector kontzertuGuztiak() throws SQLException {
		   Vector emaitza= new Vector();
		   for(int i=0;i<this.artistak.size();i++) {
			   emaitza=this.artistak.get(i).kontzertuakBektoreanSartu(emaitza);
		   }
		   return emaitza;
	   }
	   
	   
	 //INPRIMIR LOS QUE LA PERSONA SIGUE
	   
	   public Vector gordeDituenErabiltzaileGuztiak(String erabiltzaile) {
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzaile);
		   Vector emaitza=e.jarraituBektorea();
		   return emaitza;
	   }
	   
	   public Vector gordeDituenAbestiGuztiak(String erabiltzaile) {
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzaile);
		   Vector emaitza=e.abestiBektorea();
		   return emaitza;
	   }
	   
	   public Vector gordeDituenAlbumGuztiak(String erabiltzaile) {
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzaile);
		   Vector emaitza=e.albumBektorea();
		   return emaitza;
	   }
	   
	   public Vector gordeDituenPlayListGuztiak(String erabiltzaile) {
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzaile);
		   Vector emaitza=e.playlistBektorea();
		   return emaitza;
	   }
	   
	   public Vector gordeDituenArtistaGuztiak(String erabiltzaile) {
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzaile);
		   Vector emaitza=e.artistaBektorea();
		   return emaitza;
	   }
	   
	   //otros inprimir:
	   public Vector albumaDituenAbestiGuztiak(String album) {
		   Albuma a=this.bilatuAlbumaIzenaz(album);
		   Vector emaitza= new Vector();
		   emaitza=a.abestiakBektoreanSartu(emaitza);
		   return emaitza;
	   }
	   
	   public Vector artistaDituenAlbumGuztiak(String artista) {
		   Artista a=this.artistaBilatuIzenaz(artista);
		   Vector emaitza= new Vector();
		   emaitza=a.albumakBektoreanSartu(emaitza);
		   return emaitza;
	   }
	   
	   public Vector artistarenPartaideGuztiak(String artista) {
		   Artista a=this.artistaBilatuIzenaz(artista);
		   Vector emaitza= new Vector();
		   emaitza=a.izenakBektoreanSartu(emaitza);
		   return emaitza;
	   }
	   
	   public Vector playlistarenAbestiak(PlayList a) {
		   Vector emaitza= new Vector();
		   emaitza=a.abestiakBektoreanSartu(emaitza);
		   return emaitza;
	   }
	   
	   
	   
	   //ABESTIAREKIN
	   
	   public Abestia bilatuAbestiaIzenaz(String abestia){
		   boolean aurkitua=false;
		   Iterator<Artista> itr=this.artistak.iterator();
		   Artista a= null;
		   Abestia ab=null;
	    	while(itr.hasNext()&&!aurkitua) {
	    		a=itr.next();
	    		ab=a.bilatuAbestiaIzenaz(abestia);
	    		if(ab!=null) {
	    			aurkitua=true;
	    		}
	    	}
		   return ab;
	   }
	   
	   public String artistarenIzenaLortu(Abestia a) {
		   String arKode=a.getArtistaKode();
		   String emaitza=this.bilatuArtista(arKode).getIzena();
		   return emaitza;
	   }
	   
	   public String albumarenIzenaLortu(Abestia a) {
		   String al=this.bilatuAlbuma(a.getArtistaKode(), a.getAlbumId()).getIzena();
		   return al;
	   }
	   
	   public int abestiarenId(Abestia a) {
		   return a.getId();
	   }
	   
	   public String abestiarenIraupena(Abestia a) {
		   return a.getDenbora();
	   }
	   
	  public String abestiarenData(Abestia a) {
		   return a.getData();
	   }
	   
	   public int abestiarenLikeKop(Abestia a) {
		   return a.getLikeKop();
	   }
	   
	   public String abestiarenLetra(Abestia a) {
		   String letra=a.getLetra();
		   String emaitza=null;
		   if(letra!=null) {
			  emaitza=letra; 
		   }
		   return emaitza;
	   }
	   
	   public void abestiaGustatuZaio(Abestia a) {//FALTA SUMAR EN LA DATU BASE
		   a.likeEmanDiote();
		   
	   }
	   
	 //ALBUMAREN INFORMAZIOA
	   
	  public Albuma bilatuAlbumaIzenaz(String album) {
		  boolean aurkitua=false;
		   Iterator<Artista> itr=this.artistak.iterator();
		   Artista a= null;
		   Albuma al=null;
	    	while(itr.hasNext()&&!aurkitua) {
	    		a=itr.next();
	    		al=a.bilatuAlbumaIzenaz(album);
	    		if(al!=null) {
	    			aurkitua=true;
	    		}
	    	}
		   return al;
	  }
	  
	   public String artistarenIzenaLortu(Albuma a) {
		   System.out.print(a.getArtistaKode());
		   String arKode=a.getArtistaKode();
		   String emaitza=this.bilatuArtista(arKode).getIzena();
		   return emaitza;
	   }
	   
	   public int albumarenId(Albuma a) {
		   return a.getId();
	   }
	   
	   public String albumarenIraupena(Albuma a) {
		  return a.getDenbora();
	   }
	   
	   public String albumarenData(Albuma a) {
		   return a.getData();
	   }
	
	   public int albumarenLikeKop(Albuma a) {
		   return a.getLikeKop();
	   }
	   
	   public int albumarenAbestiKop(Albuma a) {
		   return a.getAbestiKop();
	   }
	   
	   public void albumaGustatuZaio(Albuma a) {//HAY QUE SUMAR TAMBIEN EN LA DATU BASE
		   a.likeEmanDiote();
		   
	   }
	   
	   
	   //ARTISTAREN INFORMAZIOA
	   
	   public Artista artistaBilatuIzenaz(String artista) {
		   boolean aurkitua=false;
		   Iterator<Artista> itr=this.artistak.iterator();
		   Artista a= null;
	    	while(itr.hasNext()&&!aurkitua) {
	    		a=itr.next();
	    		if(a.izenBeraDu(artista)) {
	    			aurkitua=true;
	    		}
	    	}
		   return a;
	   }
	   
	   public String artistarenBiografia(Artista a) {
		   return a.getBiografia();
	   }
	   
	   public String artistarenId(Artista a) {
		   return a.getKode();
	   }
	   
	   public int artistarenLikeKop(Artista a) {
		   return a.getLikeKop();
	   }
	   
	   public void artistaGustatuZaio(Artista a) {//HAY QUE SUMAR EN LA DATU BASE
		   a.likeEmanDiote();
	   }
	   
	   
	   //playlistaren info
	   
	   public PlayList bilatuPlaylistIzenaz(String playlist){
		   boolean aurkitua=false;
		   Iterator<PlayList> itr=this.playlistak.iterator();
		   PlayList pl= null;
	    	while(itr.hasNext()&&!aurkitua) {
	    		pl=itr.next();
	    		if(pl.izenBeraDu(playlist)) {
	    			aurkitua=true;
	    		}
	    	}
		   return pl;
	   }
	   
	   public String playlistarenErabiltzailea(PlayList a) {
		   return a.getErabiltzailea();
	   }
	   public int playlistarenKodea(PlayList a) {
		   return a.getKode();
	   }
	   
	   public String playlistarenDenbora(PlayList a) {
		   return a.getDenbora();
	   }
	   
	   public String playlistarenData(PlayList a) {
		   return a.getData();
	   }
	   
	   public int playlistarenLikeKop(PlayList a) {
		   return a.getLikeKop();
	   }
	   public String playlistarenDeskribapena(PlayList a) {
		   return a.getDeskribapena();
	   }
	   
	   public void playlistLikeEman(PlayList pl) {//HAY QUE SUMAR EN LA DATU BASE
		   pl.likeEmanDiote();
	   }
	   

	   
	   
	   
	   //----------------------- 
	   
	   public void abestiaGorde(String erabiltzailea,String abestia) {
		   //guarda la cancion en las canciones q sigue el erabiltzaile
		   Abestia a=this.bilatuAbestiaIzenaz(abestia);
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzailea);
		   e.gehituAbestia(a);//dentro de este?¿
	   }
	   
	   public void albumaGorde(String erabiltzailea,String album) {
		   //guarda el album en los albumes q le gustan
		   Albuma a=this.bilatuAlbumaIzenaz(album);
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzailea);
		   e.gehituAlbuma(a);
	   }
	   
	   public void artistaGorde(String erabiltzailea,String artista) {
		   //guarda el album en los albumes q le gustan
		   Artista a=this.artistaBilatuIzenaz(artista);
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzailea);
		   e.gehituArtista(a);
	   }
	   
	   public void erabiltzaileaGorde(String erabiltzailea,String e) { //a ha seguido a b
		   //guarda el album en los albumes q le gustan
		   Erabiltzaile a=this.bilatuErabiltzailea(erabiltzailea);
		   Erabiltzaile b=this.bilatuErabiltzailea(e);
		   a.gehituJarraitua(b);
		   b.gehituJarraitzaile(a);
	   }
	   
	   public void playlistGorde(String erabiltzailea,String playlist) {
		   //guarda el album en los albumes q le gustan
		   PlayList pl=this.bilatuPlaylistIzenaz(playlist);
		   Erabiltzaile e=this.bilatuErabiltzailea(erabiltzailea);
		   e.gehituPlaylist(pl);
	   }

}