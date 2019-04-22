package Taulak;

import java.util.ArrayList;

public class Erabiltzaile {
	private String user;
	private String pasahitza;
	private String email;
	private ArrayList<Abestia> nireAbestiak;//??
	private ArrayList<Albuma> nireAlbumak;//??
	private ArrayList<Artista> nireArtistak;//??
	private ArrayList<PlayList> nirePlayListak;//??
	private ArrayList<Erabiltzaile> jarraitu;//??
	private ArrayList<Erabiltzaile> jarraitzaile;//??
	
	public Erabiltzaile(String pUser, String pPas, String pEmail) {
		this.user=pUser;
		this.pasahitza=pPas;
		this.email=pEmail;
		this.nireAbestiak=new ArrayList<Abestia>();
		this.nireAlbumak=new ArrayList<Albuma>();
		this.nireArtistak=new ArrayList<Artista>();
		this.nirePlayListak=new ArrayList<PlayList>();
		this.jarraitu=new ArrayList<Erabiltzaile>();
		this.jarraitzaile=new ArrayList<Erabiltzaile>();
	}
	
	public void abestiaGehitu(Abestia a) {
		this.nireAbestiak.add(a);
	}
	
	public void albumaGehitu(Albuma a) {
		this.nireAlbumak.add(a);
	}
	
	public void artistaGehitu(Artista a) {
		this.nireArtistak.add(a);
	}
	
	public void abestiaGehitu(PlayList p) {
		this.nirePlayListak.add(p);
	}
	
	public void jarraituaGehitu(Erabiltzaile e) {
		this.jarraitu.add(e);
	}
	
	public void jarraitzaileaGehitu(Erabiltzaile e) {
		this.jarraitzaile.add(e);
	}
	
}
