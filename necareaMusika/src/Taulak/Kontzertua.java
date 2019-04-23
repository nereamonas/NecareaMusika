package Taulak;

import java.sql.Date;

import javax.print.attribute.DateTimeSyntax;

public class Kontzertua {
	private String non;
	private Date noiz;
	private String artistaKode;
	
	public Kontzertua(String pNon, Date pNoiz, String pArKode) {
		this.non=pNon;
		this.noiz=pNoiz;
		this.artistaKode=pArKode;
	}
}
