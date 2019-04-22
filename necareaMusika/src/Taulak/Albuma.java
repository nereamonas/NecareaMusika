package Taulak;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Albuma {
	private int id;
	private String artistaKode;
	private String izena;
	private Time denbora;
	private Date data;
	private int likeKop;
	private int abestiKop;
	private ArrayList<Abestia> abestiak;//??
	private ArrayList<String> generoak;//??
	 
	public Albuma(int pId, String pArKode, String pIzena, Time pDenb, Date pData, int pLike, int pAbKop) {
		this.id=pId;
		this.artistaKode=pArKode;
		this.izena=pIzena;
		this.denbora=pDenb;
		this.data=pData;
		this.likeKop=pLike;
		this.abestiKop=pAbKop;
		this.abestiak=new ArrayList<Abestia>();
		this.generoak=new ArrayList<String>();
	}
	
	public void abestiaGehitu(Abestia a) {
		this.abestiak.add(a);
	}
}