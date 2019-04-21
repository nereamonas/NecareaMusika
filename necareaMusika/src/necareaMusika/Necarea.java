package necareaMusika;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import Taulak.Abestia;
import Taulak.Albuma;
import Taulak.Artista;
import Taulak.PlayList;


public class Necarea {

		//atributuak
	    private static Necarea nireNecarea=null;
	    
	    private Connection konexioa=null;
	    

	    
	    
	            
	//eraikitzailea
	            
	    private Necarea() throws SQLException { 
	    	Konektatu k= new Konektatu();
	    	this.konexioa=k.getConnection();
	    }    
	    
	    public static synchronized Necarea getNecarea() throws SQLException {
	        if (Necarea.nireNecarea==null) {
	        	Necarea.nireNecarea= new Necarea();
	        }
	        return Necarea.nireNecarea;
	    }
	    
	    
	    //Metodoak
	    
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

}
