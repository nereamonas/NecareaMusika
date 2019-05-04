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

import Taulak.Artista;
import necareaMusika.Necarea;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class ArtistaInfoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String erabiltzailea, String p, String artista) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtistaInfoFrame frame = new ArtistaInfoFrame(erabiltzailea,  p, artista);
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
	public ArtistaInfoFrame(String erabiltzailea, String p, String artista) throws SQLException {
		Necarea necarea=Necarea.getNecarea();
		setBackground(new Color(245, 255, 250));
		setTitle("Printzipala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 530);
		
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
		
		JMenuItem mntmPlaylistaSortu = new JMenuItem("PlayLista sortu");
		mnMenua.add(mntmPlaylistaSortu);
		
		JSeparator separator_2 = new JSeparator();
		mnMenua.add(separator_2);
		
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
		mntmH.setIcon(new ImageIcon("src/logo_txikia2.png"));
		menuBar.add(mntmH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblArtista.setBackground(new Color(175, 238, 238));
		panel.add(lblArtista);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblTaldearenIzena = new JLabel("Taldearen izena:");
		lblTaldearenIzena.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblBiografia = new JLabel("Biografia:");
		lblBiografia.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblArtistarenKodea = new JLabel("Artistaren kodea:");
		lblArtistarenKodea.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblLikeKopurua = new JLabel("Like kopurua:");
		lblLikeKopurua.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblPartaidea = new JLabel("Partaideak:");
		lblPartaidea.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDiskoak = new JLabel("Diskoak:");
		lblDiskoak.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnDiskoraJoan = new JButton("Diskora joan");
		btnDiskoraJoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDiskoraJoan.setBackground(new Color(135, 206, 250));
		btnDiskoraJoan.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		Artista a= necarea.artistaBilatuIzenaz(artista);
		JLabel label = new JLabel(""+artista);
		
		JLabel label_1 = new JLabel(""+necarea.artistarenBiografia(a));
		
		JLabel label_2 = new JLabel(""+necarea.artistarenId(a));
		
		JLabel label_3 = new JLabel(""+necarea.artistarenLikeKop(a));
		
		JButton btnLikeEman = new JButton("Like eman");
		btnLikeEman.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLikeEman.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnLikeEman.setBackground(new Color(135, 206, 250));
		
		JButton button = new JButton("Artista jarraitu nahi dut");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		button.setBackground(new Color(135, 206, 250));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPartaidea)
								.addComponent(lblDiskoak))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDiskoraJoan))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addComponent(lblLikeKopurua)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
									.addComponent(btnLikeEman, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(74))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(3)
											.addComponent(lblTaldearenIzena)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(39)
											.addComponent(lblBiografia)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_1))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblArtistarenKodea)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_2)))
									.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)))))
					.addGap(13))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(132))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaldearenIzena)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBiografia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArtistarenKodea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLikeKopurua, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(btnLikeEman, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(30)
							.addComponent(lblPartaidea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(22)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDiskoak, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(29)
									.addComponent(btnDiskoraJoan)))))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		
		
		JList list_1 = new JList(necarea.artistaDituenAlbumGuztiak(artista));
		scrollPane_1.setViewportView(list_1);
		
		JList list = new JList(necarea.artistarenPartaideGuztiak(artista));
		scrollPane.setViewportView(list);
		panel_1.setLayout(gl_panel_1);
		
		
		//PlayList sortu
		mntmPlaylistaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayListSortuFrame plSortu=null;
				try {
					plSortu = new PlayListSortuFrame(erabiltzailea,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				plSortu.setVisible(true);
				dispose();
			}
		});
		
		
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
		
		//artistari like
		
		btnLikeEman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnLikeEman.getText().equals("Like eman")){
					necarea.artistaGustatuZaio(a);
					label_3.setText(""+necarea.artistarenLikeKop(a));
					btnLikeEman.setText("Like kendu");
				}else {
					if(btnLikeEman.getText().equals("Like kendu")) {
						necarea.artistaLikeKendu(a);
						label_3.setText(""+necarea.artistarenLikeKop(a));
						btnLikeEman.setText("Like eman");
					}
				}
			}
		});
		
		//diskora joan
		btnDiskoraJoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_1.getSelectedIndex()!=-1) {
					AlbumInfoFrame albumInfo=null;
					try {
						albumInfo = new AlbumInfoFrame(erabiltzailea,p,(String) list_1.getSelectedValue());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					albumInfo.setVisible(true);
					dispose();
				}
				
			}
		});
		
		//artistaJarraitu
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				necarea.artistaGorde(erabiltzailea, artista);
			}
		});
		
	}

}
