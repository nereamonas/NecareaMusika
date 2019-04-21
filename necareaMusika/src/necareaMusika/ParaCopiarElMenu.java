package necareaMusika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import Botoiak.AbestiakFrame;
import Botoiak.AlbumakFrame;
import Botoiak.ArtistakFrame;
import Botoiak.ErabiltzaileakFrame;
import Botoiak.GordeAbestiFrame;
import Botoiak.GordeAlbumFrame;
import Botoiak.GordeArtistaFrame;
import Botoiak.GordeErabiltzaileFrame;
import Botoiak.GordePlayListFrame;
import Botoiak.KontzertuakFrame;
import Botoiak.NireInformazioaFrame;
import Botoiak.PlaylistakFrame;
import Botoiak.SaioaItxiNahiFrame;
import Botoiak.WebFrame;


public class ParaCopiarElMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String erabiltzailea, String p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaCopiarElMenu frame = new ParaCopiarElMenu( erabiltzailea,  p);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParaCopiarElMenu(String erabiltzailea, String p) {
		setBackground(new Color(245, 255, 250));
		setTitle("Printzipala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenua = new JMenu("Menua");
		mnMenua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		menuBar.add(mnMenua);
		
		JMenu mnNireKontua = new JMenu("Nire kontua");
		mnNireKontua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mnNireKontua);
		
		JMenuItem mntmInformazioa = new JMenuItem("Nire informazioa");
		mntmInformazioa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNireKontua.add(mntmInformazioa);
		
		JMenuItem mntmGordetakoAbestiak = new JMenuItem("Gordetako abestiak");
		mntmGordetakoAbestiak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNireKontua.add(mntmGordetakoAbestiak);
		
		JMenuItem mntmGordetakoAlbumak = new JMenuItem("Gordetako album-ak");
		mntmGordetakoAlbumak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNireKontua.add(mntmGordetakoAlbumak);
		
		JMenuItem mntmGordetakoPlaylistak = new JMenuItem("Gordetako playList-ak");
		mntmGordetakoPlaylistak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNireKontua.add(mntmGordetakoPlaylistak);
		
		JMenuItem mntmJarraitutakoArtistak = new JMenuItem("Jarraitutako artistak");
		mntmJarraitutakoArtistak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNireKontua.add(mntmJarraitutakoArtistak);
		
		JMenuItem mntmJarraitutakoErabiltzaileak = new JMenuItem("Jarraitutako erabiltzaileak");
		mntmJarraitutakoErabiltzaileak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNireKontua.add(mntmJarraitutakoErabiltzaileak);
		
		JSeparator separator = new JSeparator();
		mnMenua.add(separator);
		
		JMenuItem mntmAbestiak = new JMenuItem("Abestiak");
		mntmAbestiak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmAbestiak);
		
		JMenuItem mntmAlbumak = new JMenuItem("Albumak");
		mntmAlbumak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmAlbumak);
		
		JMenuItem mntmArtistak = new JMenuItem("Artistak");
		mntmArtistak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmArtistak);
		
		JMenuItem mntmPlaylistak = new JMenuItem("PlayList-ak");
		mntmPlaylistak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmPlaylistak);
		
		JSeparator separator_4 = new JSeparator();
		mnMenua.add(separator_4);
		
		JMenuItem mntmErabiltzaileak = new JMenuItem("Erabiltzaileak");
		mntmErabiltzaileak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmErabiltzaileak);
		
		JMenuItem mntmKontzertuak = new JMenuItem("Kontzertuak");
		mntmKontzertuak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmKontzertuak);
		
		JSeparator separator_3 = new JSeparator();
		mnMenua.add(separator_3);
		
		JMenuItem mntmMenuPrintzipaleraItzuli = new JMenuItem("Menu printzipalera itzuli");
		mntmMenuPrintzipaleraItzuli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmMenuPrintzipaleraItzuli);
		
		JSeparator separator_1 = new JSeparator();
		mnMenua.add(separator_1);
		
		JMenuItem mntmSaioaItxi = new JMenuItem("Saioa itxi");
		mntmSaioaItxi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmSaioaItxi);
		
		JMenuItem mntmH = new JMenuItem("");
		mntmH.setBackground(new Color(245, 255, 250));
		mntmH.setIcon(new ImageIcon("C:\\Users\\nerea\\Desktop\\logo_txikia2.png"));
		menuBar.add(mntmH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		//Saioa itxi
		mntmSaioaItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaioaItxiNahiFrame saioaItxi= new SaioaItxiNahiFrame(erabiltzailea,p);
				saioaItxi.setVisible(true);
				dispose();
			}
		});
		
		//menu printzipalera itzuli
		mntmMenuPrintzipaleraItzuli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WebFrame web=null;
				try {
					web = new WebFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				web.setVisible(true);
				dispose();
			}
		});
		
		//nire informazioa hartu
		mntmInformazioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NireInformazioaFrame info=null;
				try {
					info = new NireInformazioaFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				info.setVisible(true);
				dispose();
			}
		});
		
		
		//Gordetako abestiak
		mntmGordetakoAbestiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GordeAbestiFrame gordeAbesti=null;
				try {
					gordeAbesti = new GordeAbestiFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gordeAbesti.setVisible(true);
				dispose();
			}
		});
		
		//Gordetako albumak
		mntmGordetakoAlbumak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GordeAlbumFrame gordeAlbumak=null;
				try {
					gordeAlbumak = new GordeAlbumFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gordeAlbumak.setVisible(true);
				dispose();
			}
		});
		
		//Gordetako playlist-ak
		mntmGordetakoPlaylistak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GordePlayListFrame gordePlaylistak=null;
				try {
					gordePlaylistak = new GordePlayListFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gordePlaylistak.setVisible(true);
				dispose();
			}
		});
		
		
		//jarraitutako artistak
		mntmJarraitutakoArtistak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GordeArtistaFrame gordeArtista=null;
				try {
					gordeArtista = new GordeArtistaFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gordeArtista.setVisible(true);
				dispose();
			}
		});
		
		
		
		//jarraitutako erabiltzaileak
		mntmJarraitutakoErabiltzaileak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GordeErabiltzaileFrame gordeErabiltzaile=null;
				try {
					gordeErabiltzaile = new GordeErabiltzaileFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gordeErabiltzaile.setVisible(true);
				dispose();
			}
		});
		
		//Abesti guztiak
		mntmAbestiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbestiakFrame Abestiak=null;
				try {
					Abestiak = new AbestiakFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Abestiak.setVisible(true);
				dispose();
			}
		});
		
		//Album guztiak
		mntmAlbumak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlbumakFrame Albumak=null;
				try {
					Albumak = new AlbumakFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Albumak.setVisible(true);
				dispose();
			}
		});		
		
		//Artista guztiak
		mntmArtistak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArtistakFrame Artistak=null;
				try {
					Artistak = new ArtistakFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Artistak.setVisible(true);
				dispose();
			}
		});		
		
		
		//Playlistak guztiak
		mntmPlaylistak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlaylistakFrame Playlistak=null;
				try {
					Playlistak = new PlaylistakFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Playlistak.setVisible(true);
				dispose();
			}
		});	
		
		
		//erabiltzaile guztiak
		mntmErabiltzaileak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ErabiltzaileakFrame Erabiltzaileak=null;
				try {
					Erabiltzaileak = new ErabiltzaileakFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Erabiltzaileak.setVisible(true);
				dispose();
			}
		});		
		
		
		//erabiltzaile guztiak
		mntmKontzertuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KontzertuakFrame Kontzertuak=null;
				try {
					Kontzertuak = new KontzertuakFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Kontzertuak.setVisible(true);
				dispose();
			}
		});	
		
	}

}
