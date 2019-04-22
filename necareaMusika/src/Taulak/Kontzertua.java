package Taulak;
 
import javax.print.attribute.DateTimeSyntax;

public class Kontzertua {
	private String non;
	private DateTimeSyntax noiz;
	private String artistaKode;
	
	public Kontzertua(String pNon, DateTimeSyntax pNoiz, String pArKode) {
		this.non=pNon;
		this.noiz=pNoiz;
		this.artistaKode=pArKode;
	}
}