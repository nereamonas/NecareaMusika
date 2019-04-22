package Taulak;
 
import java.util.ArrayList;

public class Artista {
	private String kodea;
	private String biografia;
	private int likeKop;
	private String taldeIzena;
	private ArrayList<String> izenak; //??
	private ArrayList<Albuma> albumak; //??
	
	public Artista(String pKodea, String pBio,int pLike, String pTalde) {
		this.kodea=pKodea;
		this.biografia=pBio;
		this.likeKop=pLike;
		this.taldeIzena=pTalde;
		this.izenak=new ArrayList<String>();
		this.albumak=new ArrayList<Albuma>();
	}
	
	public void izenaGehitu(String i) {
		this.izenak.add(i);
	}
	
}