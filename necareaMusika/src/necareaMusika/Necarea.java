package necareaMusika;

import java.sql.Connection;
import java.sql.SQLException;


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
	    

}
