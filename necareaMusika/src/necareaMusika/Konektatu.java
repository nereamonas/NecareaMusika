package necareaMusika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Konektatu {
	
	private static final String zerbitzaria = "jdbc:mysql://localhost:3306/necarea_musika?useServerPrepStmts=true";
	private static final String erabiltzailea = "root";
	private static final String pasahitza = "";
	private static final String urltime="&useLegacyDatetimeCode=false&useTimeZone=True&serverTimezone=UTC";
	private static Connection konexioa=null;
	
	public Konektatu() throws SQLException {
		this.konexioa=DriverManager.getConnection(zerbitzaria+urltime,erabiltzailea,pasahitza);
		if(this.konexioa!=null) {
			System.out.println("Ondo sortu da konexioa");
		}else {
			System.out.println("Konexioa ez da ondo sortu");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return Konektatu.konexioa;
	}
	
	public void deskonektatu() {
		this.konexioa=null;
		if(this.konexioa==null) {
			System.out.println("Konexioa amaitu da");
		}
	}
	
}
	
