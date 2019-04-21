package necareaMusika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class necarea_musika {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub

		
		//Konexioa sortu
		String zerbitzaria = "jdbc:mysql://localhost:3306/necarea_musika";
		String erabiltzailea = "root";
		String pasahitza = "";
		String urltime="?useLegacyDatetimeCode=false&useTimeZone=True&serverTimezone=UTC";
		Connection konexioa = DriverManager.getConnection(zerbitzaria+urltime,erabiltzailea,pasahitza);
	
		
		
		
		
	}
}
