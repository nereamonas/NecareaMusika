package Taulak;

import java.sql.Date;
import java.sql.Time;

public class PlayList {
	private int id;
	private String erabiltzaileUser;
	private String izena;
	private Time denbora;
	private Date data;
	private int likeKop;
	private String deskribapena;
	
	public PlayList(int pId, String pEr, String pIzen, Time pDenb, Date pData, int pLike, String pDeskr) {
		this.id=pId;
		this.erabiltzaileUser=pEr;
		this.izena=pIzen;
		this.denbora=pDenb;
		this.data=pData;
		this.likeKop=pLike;
		this.deskribapena=pDeskr;
	}
}
