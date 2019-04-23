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
		
		public void artistakHartu() throws SQLException {
			Connection konexioa=Konektatu.getConnection();
		    java.sql.Statement statement = konexioa.createStatement();
		    ResultSet rs = statement.executeQuery("SELECT * FROM artista");
		    while (rs.next()) {
		        String kodea = rs.getString("KODEA");
		        String biografia = rs.getString("BIOGRAFIA");
		        int likeKop = rs.getInt("LIKEKOP");
		        String taldeIzena = rs.getString("TALDEIZENA");
		        System.out.println(String.format("%s, %s, %d, %s",kodea,biografia, likeKop,taldeIzena)); //?
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
		        System.out.println(String.format("%d,%s, %s,%t,%t %d, %s",id,erUser,izena,denbora,data, likeKop,deskr)); //?
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
		        System.out.println(String.format("%s, %s, %s", user, pasahitza,email)); //?
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
	    /*
	    
	    
	    
	    
	//ERABILTZAILEAREKIN    
	    public boolean pertsonaBilatu(String erabiltzailea) {
	    	boolean dago=false;
	    	//TODO
	    	
	    	return dago;
	    }
	    
	    public boolean pasahitzaKonprobatu(String erabiltzailea, String pasahitza) {
	    	boolean ondo=false;
	    	//TODO
	    	
	    	return ondo;
	    }
	    
	    public void erabiltzaileaGehitu(String erabiltzailea,String pasahitza) {
	    	
	    	
	    }
	    
	   public void pasahitzaAldatu(String erabiltzailea,String pasahitza) {
		   
	   }
	   
	   public String erabiltzailearenEMail(String e) {
		   String mail="";
		   //bilatu persona
		   //persona.getEmail
		   
		   return mail;
	   }
	   
	  
	 
	   
	//INPRIMIR TODO LO QUE HAY   
	   public Vector erabiltzaileGuztiak() {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector abestiGuztiak() {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector albumGuztiak() {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector artistaGuztiak() {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector playlistGuztiak() {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector kontzertuGuztiak() {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   
	 //INPRIMIR LOS QUE LA PERSONA SIGUE
	   
	   public Vector gordeDituenErabiltzaileGuztiak(String erabiltzaile) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector gordeDituenAbestiGuztiak(String erabiltzaile) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector gordeDituenAlbumGuztiak(String erabiltzaile) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector gordeDituenPlayListGuztiak(String erabiltzaile) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector gordeDituenArtistaGuztiak(String erabiltzaile) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   //otros inprimir:
	   public Vector albumaDituenAbestiGuztiak(String album) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector artistaDituenAlbumGuztiak(String artista) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector artistarenPartaideGuztiak(String artista) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   public Vector playlistarenAbestiak(PlayList a) {
		   Vector emaitza= new Vector();
		   
		   return emaitza;
	   }
	   
	   
	   
	   //ABESTIAREKIN
	   
	   public Abestia bilatuAbestiaIzenaz(String abestia){
		   Abestia a= new Abestia();
		   
		   return a;
	   }
	   
	   public String artistarenIzenaLortu(Abestia a) {
		   String emaitza="";
		   
		   return emaitza;
	   }
	   
	   public String albumarenIzenaLortu(Abestia a) {
		   String emaitza="";
		   
		   return emaitza;
	   }
	   
	   public int abestiarenId(Abestia a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int abestiarenIraupena(Abestia a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int abestiarenData(Abestia a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public String abestiarenGeneroa(Abestia a) {
		   String emaitza="";
		   
		   return emaitza;
	   }
	   
	   public int abestiarenLikeKop(Abestia a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public String abestiarenLetra(Abestia a) {
		   String emaitza="";
		   
		   return emaitza;
	   }
	   
	   public void abestiaGustatuZaio(Abestia a) {
		   //hacer al like +1
		   
	   }
	   
	 //ALBUMAREN INFORMAZIOA
	   
	  public Albuma bilatuAlbumaIzenaz(String album) {
		  Albuma a= new Albuma();
		  
		  return a;
	  }
	  
	   public String artistarenIzenaLortu(Albuma a) {
		   String emaitza="";
		   
		   return emaitza;
	   }
	   
	   public int albumarenId(Albuma a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int albumarenIraupena(Albuma a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int albumarenData(Albuma a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	
	   public int albumarenLikeKop(Albuma a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int albumarenAbestiKop(Albuma a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public void albumaGustatuZaio(Albuma a) {
		   //hacer al like +1
		   
	   }
	   
	   
	   //ARTISTAREN INFORMAZIOA
	   
	   public Artista artistaBilatuIzenaz(String artista) {
		   Artista a=new Artista();
		   
		   return a;
	   }
	   
	   public String artistarenBiografia(Artista a) {
		   String emaitza="";
		   
		   return emaitza;
	   }
	   
	   public int artistarenId(Artista a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int artistarenLikeKop(Artista a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public void artistaGustatuZaio(Artista a) {
		   //hacer al like +1
	   }
	   
	   
	   //playlistaren info
	   
	   public PlayList bilatuPlaylistIzenaz(String playlist){
		   PlayList emaitza= new PlayList();
		   
		   return emaitza;
	   }
	   
	   public String playlistarenErabiltzailea(PlayList a) {
		   String emaitza="";
		   
		   return emaitza;
	   }
	   public int playlistarenKodea(PlayList a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int playlistarenDenbora(PlayList a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int playlistarenData(PlayList a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   
	   public int playlistarenLikeKop(PlayList a) {
		   int emaitza=0;
		   
		   return emaitza;
	   }
	   public String playlistarenDeskribapena(PlayList a) {
		   String emaitza="";
		   
		   return emaitza;
	   }
	   
	   public void playlistLikeEman(PlayList pl) {
		   //hacer al like +1
	   }
	   

	   
	   
	   
	   //-----------------------
	   
	   public void abestiaGorde(String erabiltzailea,String abestia) {
		   //guarda la cancion en las canciones q sigue el erabiltzaile
	   }
	   
	   public void albumaGorde(String erabiltzailea,String album) {
		   //guarda el album en los albumes q le gustan
	   }
	   
	   public void artistaGorde(String erabiltzailea,String artista) {
		   //guarda el album en los albumes q le gustan
	   }
	   
	   public void erabiltzaileaGorde(String erabiltzailea,String e) {
		   //guarda el album en los albumes q le gustan
	   }
	   
	   public void playlistGorde(String erabiltzailea,String playlist) {
		   //guarda el album en los albumes q le gustan
	   }
	   
	   */

}