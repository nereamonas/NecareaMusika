package Taulak;

import java.sql.Date;
import java.sql.SQLException;

import javax.print.attribute.DateTimeSyntax;

import necareaMusika.Necarea;

public class Kontzertua {
	private String non;
	private Date noiz;
	private String artistaKode;
	
	public Kontzertua(String pNon, Date pNoiz, String pArKode) {
		this.non=pNon;
		this.noiz=pNoiz;
		this.artistaKode=pArKode;
	}
	
	public void nonInprimatu() {
		System.out.print(this.non);
	}

	public String informazioa() throws SQLException {
		Necarea necarea=Necarea.getNecarea();
		return (necarea.bilatuArtista(artistaKode).getIzena() + ", " + this.non + ", " + this.noiz);
	}
}