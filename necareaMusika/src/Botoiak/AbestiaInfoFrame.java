package Botoiak;

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

import Taulak.Abestia;
import necareaMusika.Necarea;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class AbestiaInfoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String erabiltzailea, String p,String abestia) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbestiaInfoFrame frame = new AbestiaInfoFrame(erabiltzailea, p,abestia);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AbestiaInfoFrame(String erabiltzailea, String p,String abestia) throws SQLException {
		Necarea necarea=Necarea.getNecarea();
		
		setBackground(new Color(245, 255, 250));
		setTitle("Printzipala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 453);
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblAbestia = new JLabel("Abestia");
		lblAbestia.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		panel.add(lblAbestia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblArtistarenIzena = new JLabel("Artistaren izena:");
		lblArtistarenIzena.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton btnArtistaraJoan = new JButton("Artistara joan");
		btnArtistaraJoan.setBackground(new Color(135, 206, 250));
		btnArtistaraJoan.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblAbestiarenId = new JLabel("Abestiaren id:");
		lblAbestiarenId.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblIraupena = new JLabel("Iraupena:");
		lblIraupena.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblIrteeraData = new JLabel("Irteera data:");
		lblIrteeraData.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblGeneroa = new JLabel("Generoa:");
		lblGeneroa.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblLikeKopurua = new JLabel("Like kopurua:");
		lblLikeKopurua.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton btnAbestiaGustatuZait = new JButton("Abestia gustatu zait");
		btnAbestiaGustatuZait.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAbestiaGustatuZait.setBackground(new Color(135, 206, 250));
		
		JLabel lblAlbumKodea = new JLabel("Albuma:");
		lblAlbumKodea.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		Abestia a=necarea.bilatuAbestiaIzenaz(abestia);
		JLabel label = new JLabel(abestia);
		
		JLabel label_1 = new JLabel(necarea.artistarenIzenaLortu(a));
		
		JLabel label_2 = new JLabel(""+necarea.abestiarenId(a));
		
		JLabel label_3 = new JLabel(necarea.albumarenIzenaLortu(a));
		
		JLabel label_4 = new JLabel(""+necarea.abestiarenIraupena(a));
		
		JLabel label_5 = new JLabel(""+necarea.abestiarenData(a));
		
		JLabel label_6 = new JLabel(""+necarea.abestiarenGeneroa(a));
		
		JLabel label_7 = new JLabel(""+necarea.abestiarenLikeKop(a));
		
		JLabel label_8 = new JLabel(""+necarea.abestiarenLetra(a));
		
		JButton btnAbestiaEntzun = new JButton("Abestia entzun");
		btnAbestiaEntzun.setBackground(new Color(135, 206, 250));
		btnAbestiaEntzun.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton btnAbestiaGorde = new JButton("Abestia gorde nahi dut");
		btnAbestiaGorde.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAbestiaGorde.setBackground(new Color(135, 206, 250));
		
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblIrteeraData)
						.addComponent(lblIraupena)
						.addComponent(lblAlbumKodea)
						.addComponent(lblGeneroa)
						.addComponent(lblArtistarenIzena)
						.addComponent(lblIzena)
						.addComponent(lblAbestiarenId)
						.addComponent(lblLikeKopurua)
						.addComponent(lblLetra))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_8)
						.addComponent(label)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(label_6)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_7))
							.addGap(106)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAbestiaGustatuZait)
								.addComponent(btnArtistaraJoan)
								.addComponent(btnAbestiaGorde))))
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(66)
					.addComponent(btnAbestiaEntzun)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIzena)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArtistarenIzena, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(btnArtistaraJoan))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbestiarenId)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlbumKodea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIraupena, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIrteeraData, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addGap(11)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeneroa, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLikeKopurua, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(btnAbestiaGustatuZait, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLetra)
						.addComponent(label_8))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbestiaEntzun)
						.addComponent(btnAbestiaGorde, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		panel_1.setLayout(gl_panel_1);
		
		
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
		
		//gorde
		btnAbestiaGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				necarea.abestiaGorde(erabiltzailea,abestia);
			}
		});
		
		//artistara joan
		btnArtistaraJoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtistaInfoFrame artistaInfo=null;
				try {
					artistaInfo = new ArtistaInfoFrame(erabiltzailea,p,necarea.artistarenIzenaLortu(a));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				artistaInfo.setVisible(true);
				dispose();
			}
		});
		
		//gustatu zaio
		btnAbestiaGustatuZait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				necarea.abestiaGustatuZaio(a);
				label_7.setText(""+necarea.abestiarenLikeKop(a));
			}
		});
		
		//abestia entzun
		btnAbestiaEntzun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerFrame play=null;
				try {
					play= new PlayerFrame(abestia);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				play.setVisible(true);
				dispose();
			}
		});
		
	}

}