 package Taulak;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Abestia {
	private int id;
	private String artistaKode;
	private String izena;
	private Time denbora;
	private Date data;
	private int likeKop;
	private String letra;
	private int albumId;
	
	public Abestia(int pId, String pArKode, String pIzena, Time pDenb, Date pData, int pLike, String pLetra, int pAlId) {
		this.id=pId;
		this.artistaKode=pArKode;
		this.izena=pIzena;
		this.denbora=pDenb;
		this.data=pData;
		this.likeKop=pLike;
		this.letra=pLetra;
		this.albumId=pAlId;
	}
	
	public boolean idBerdinaDu(int abId) {
		return abId==this.id;
	}
	
	public boolean izenBerdinaDu(String abestia) {
		return this.izena.equals(abestia);
	}
	
	public void zureIzenaInprimatu() {
		System.out.print(this.izena);
	}
	
	public String getArtistaKode() {
		return this.artistaKode;
	}
	
	public int getAlbumId() {
		return this.albumId;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDenbora() {
		String input = this.denbora.toString();
		String azken5 = "";  
		if (input.length() > 5){
		    azken5 = input.substring(input.length() - 5);
		}else{
		    azken5 = input;
		}
		System.out.println(azken5);
		return azken5;
	}
	
	public String getData() {
		return this.data.toString();
	}
	
	public int getLikeKop() {
		return this.likeKop;
	}
	
	public String getLetra() {
		return this.letra;
	}
	
	public void likeEmanDiote() {
		this.likeKop++;
	}
	
	public String getIzena() {
		return this.izena;
	}
}
