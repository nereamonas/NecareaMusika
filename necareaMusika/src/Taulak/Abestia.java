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
}
