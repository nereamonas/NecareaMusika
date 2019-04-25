 package Botoiak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import Taulak.Albuma;
import necareaMusika.Necarea;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;

public class AlbumInfoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String erabiltzailea, String p,String album) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlbumInfoFrame frame = new AlbumInfoFrame(erabiltzailea, p,album);
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
	public AlbumInfoFrame(String erabiltzailea, String p,String album) throws SQLException {
		Necarea necarea=Necarea.getNecarea();
		setBackground(new Color(245, 255, 250));
		setTitle("Printzipala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 538);
		
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
		
		JLabel lblAlbuma = new JLabel("Albuma");
		lblAlbuma.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		panel.add(lblAlbuma);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Izena:");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblArtista = new JLabel("Artista:");
		lblArtista.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblAlbumKodea = new JLabel("Album kodea:");
		lblAlbumKodea.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblIraupenTotala = new JLabel("Iraupen totala:");
		lblIraupenTotala.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblIrtetzeData = new JLabel("Irtetze data:");
		lblIrtetzeData.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblLikeKopurua = new JLabel("Like kopurua:");
		lblLikeKopurua.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblAbestiKopurua = new JLabel("Abesti kopurua:");
		lblAbestiKopurua.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblAbestiak = new JLabel("Abestiak:");
		lblAbestiak.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAbestiraJoan = new JButton("Abestira joan");
		btnAbestiraJoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbestiraJoan.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAbestiraJoan.setBackground(new Color(135, 206, 250));
		
		JButton btnAbestiraErreproduzitu = new JButton("Abestia erreproduzitu");
		btnAbestiraErreproduzitu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbestiraErreproduzitu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAbestiraErreproduzitu.setBackground(new Color(135, 206, 250));
		
		JButton btnArtistaraJoan = new JButton("Artistara joan");
		btnArtistaraJoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnArtistaraJoan.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnArtistaraJoan.setBackground(new Color(135, 206, 250));
		
		Albuma a=necarea.bilatuAlbumaIzenaz(album);
		JLabel label = new JLabel(album);
		
		JLabel label_1 = new JLabel(necarea.artistarenIzenaLortu(a));
		
		JLabel label_2 = new JLabel(""+necarea.albumarenId(a));
		
		JLabel label_3 = new JLabel(""+necarea.albumarenIraupena(a));
		
		JLabel label_4 = new JLabel(""+necarea.albumarenData(a));
		
		JLabel label_5 = new JLabel(""+necarea.albumarenLikeKop(a));
		
		JLabel label_6 = new JLabel(""+necarea.albumarenAbestiKop(a));
		
		JButton btnAlbumaGordeNahi = new JButton("Albuma gorde nahi dut");
		btnAlbumaGordeNahi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlbumaGordeNahi.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnAlbumaGordeNahi.setBackground(new Color(135, 206, 250));
		
		JButton btnLikeEman = new JButton("Like eman");
		btnLikeEman.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLikeEman.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnLikeEman.setBackground(new Color(135, 206, 250));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAbestiak)
								.addComponent(lblNewLabel)
								.addComponent(lblIrtetzeData)
								.addComponent(lblAlbumKodea)
								.addComponent(lblIraupenTotala)
								.addComponent(lblArtista)
								.addComponent(lblAbestiKopurua)
								.addComponent(lblLikeKopurua))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_6)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup()
													.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(label)
														.addComponent(label_1)
														.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
													.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel_1.createSequentialGroup()
															.addGap(43)
															.addComponent(btnAbestiraJoan)
															.addGap(46))
														.addGroup(gl_panel_1.createSequentialGroup()
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(btnAbestiraErreproduzitu, GroupLayout.PREFERRED_SIZE, 184, Short.MAX_VALUE))))
												.addComponent(label_2)
												.addComponent(label_3)))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_5)
											.addGap(137)
											.addComponent(btnLikeEman, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED, 410, Short.MAX_VALUE))))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(141)
									.addComponent(btnArtistaraJoan))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(159)
							.addComponent(btnAlbumaGordeNahi, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArtista, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(btnArtistaraJoan, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAlbumKodea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIraupenTotala, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIrtetzeData, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4))
							.addGap(22)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(lblLikeKopurua, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnLikeEman, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbestiKopurua, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAbestiak)
					.addGap(11)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnAbestiraJoan, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAbestiraErreproduzitu, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(45))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(btnAlbumaGordeNahi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		Vector elem=necarea.albumaDituenAbestiGuztiak(album);
		JList list = new JList(elem);
		scrollPane.setColumnHeaderView(list);
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
		
		//albuma gustatu
		btnLikeEman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnLikeEman.getText().equals("Like eman")){
					necarea.albumaGustatuZaio(a);
					label_5.setText(""+necarea.albumarenLikeKop(a));
					btnLikeEman.setText("Like kendu");
				}else {
					if(btnLikeEman.getText().equals("Like kendu")) {
						necarea.albumaLikeKendu(a);
						label_5.setText(""+necarea.albumarenLikeKop(a));
						btnLikeEman.setText("Like eman");
					}
				}
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
		
		//abestira joan
		btnAbestiraJoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1) {
					AbestiaInfoFrame abestiInfo=null;
					try {
						abestiInfo = new AbestiaInfoFrame(erabiltzailea, p, (String) list.getSelectedValue());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					abestiInfo.setVisible(true);
					dispose();
				}
			}
		});
		
		//abestia erreproduzitu
		btnAbestiraErreproduzitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1) {
					PlayerFrame play=null;
					try {
						play= new PlayerFrame((String) list.getSelectedValue(),erabiltzailea,p);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					play.setVisible(true);
					dispose();
				}
			}
		});
		
		//albuma gorde
		btnAlbumaGordeNahi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				necarea.albumaGorde(erabiltzailea, album);
			}
		});
		
	
	}

}
