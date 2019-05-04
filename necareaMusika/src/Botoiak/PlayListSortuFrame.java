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

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import necareaMusika.Necarea;
import javax.swing.JTextPane;

public class PlayListSortuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String erabiltzailea, String p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayListSortuFrame frame = new PlayListSortuFrame(erabiltzailea,p);
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
	public PlayListSortuFrame(String erabiltzailea, String p) throws SQLException {
		Necarea necarea=Necarea.getNecarea();
		setBackground(new Color(245, 255, 250));
		setTitle("Printzipala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 411);
		
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
		
		JLabel lblNewLabel = new JLabel("Play lista sortu");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel.setBackground(new Color(175, 238, 238));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnPlayListBerri = new JButton("Play list berri bat sortu");

		btnPlayListBerri.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnPlayListBerri.setBackground(new Color(135, 206, 250));
		
		JButton btnSortutaDudanPlay = new JButton("Sortuta dudan play list bati abestiak gehitu");
		btnSortutaDudanPlay.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnSortutaDudanPlay.setBackground(new Color(135, 206, 250));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnHonetan = new JButton("Honetan");

		btnHonetan.setBackground(new Color(135, 206, 250));
		btnHonetan.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblPlayListarenIzena = new JLabel("Play listaren izena sartu: ");
		lblPlayListarenIzena.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblPlayListarenIzena.setVisible(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setVisible(false);
		
		JLabel lblHautatuSartuNahi = new JLabel("Hautatu sartu nahi dituzun abestiak:");
		lblHautatuSartuNahi.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblHautatuSartuNahi.setVisible(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVisible(false);
		
		JLabel lblJadaSartutaDauden = new JLabel("Jada sartuta dauden abestiak:");
		lblJadaSartutaDauden.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblJadaSartutaDauden.setVisible(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVisible(false);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.setBackground(new Color(135, 206, 250));
		btnGehitu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnGehitu.setVisible(false);
		
		JButton btnSortu = new JButton("Sortu");
		btnSortu.setBackground(new Color(135, 206, 250));
		btnSortu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnSortu.setVisible(false);
		
		JLabel label = new JLabel("");
		
		JButton btnBesteAbestiBat = new JButton("Beste abesti bat sartu");

		btnBesteAbestiBat.setBackground(new Color(135, 206, 250));
		btnBesteAbestiBat.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnBesteAbestiBat.setVisible(false);
		
		JLabel label_1 = new JLabel("");
		label_1.setVisible(false);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(63)
									.addComponent(btnPlayListBerri))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(19)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnHonetan))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnSortutaDudanPlay)))
							.addGap(1))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_1)
							.addGap(69)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(45)
							.addComponent(lblPlayListarenIzena)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSortu))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(43)
									.addComponent(lblHautatuSartuNahi))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(70)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblJadaSartutaDauden)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(btnBesteAbestiBat)
										.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(371, Short.MAX_VALUE)
					.addComponent(btnGehitu)
					.addGap(254))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(457, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(235))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPlayListBerri)
						.addComponent(lblPlayListarenIzena)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSortu))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(28)
							.addComponent(label_1)
							.addGap(18)
							.addComponent(btnSortutaDudanPlay, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(40)
									.addComponent(btnHonetan))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(11)
							.addComponent(label)
							.addGap(21)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHautatuSartuNahi)
								.addComponent(lblJadaSartutaDauden))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGehitu)
						.addComponent(btnBesteAbestiBat))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
		
		JList list_1 = new JList();
		scrollPane_1.setColumnHeaderView(list_1);
		
		Vector elem= necarea.ErabiltzaileakSortutakoPlayList(erabiltzailea);
		JList list = new JList(elem);
		list.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		scrollPane.setViewportView(list);
		
		JLabel lblNikSortutakoPlay = new JLabel("Nik sortutako play listak");
		lblNikSortutakoPlay.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		scrollPane.setColumnHeaderView(lblNikSortutakoPlay);
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
		
		
		//PLAY LISTA SORTU
		btnPlayListBerri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPlayListarenIzena.setVisible(true);
				textField.setVisible(true);
				btnSortu.setVisible(true);
				label.setText("");
				
				btnSortu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
				String playlistIzena=textField.getText().trim();
				if (textField.getText().length()==0) {
					label.setText("Ez duzu ezer idatzi");
					textField.setBackground(Color.RED);
				}else {
					label_1.setText(playlistIzena);
					necarea.sortuPlayList(erabiltzailea, playlistIzena);
					label.setText("Play lista ongi sortu da");
					Vector elem= necarea.ErabiltzaileakSortutakoPlayList(erabiltzailea);
					JList list = new JList(elem);
					lblHautatuSartuNahi.setVisible(true);
					lblJadaSartutaDauden.setVisible(true);
					scrollPane_1.setVisible(true);
					scrollPane_2.setVisible(true);
					btnGehitu.setVisible(true);
					
					Vector EzDituenAbesti = necarea.playListakEzDituenAbestiak(erabiltzailea, playlistIzena);
					JList list_1 = new JList(EzDituenAbesti);
					
					Vector DituenAbesti = necarea.playListakDituenAbestiak(erabiltzailea, playlistIzena);
					JList list_2 = new JList(DituenAbesti);	
					
					btnGehitu.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(list_1.getSelectedIndex()!=-1) {
								necarea.playListariGehituAbestia (erabiltzailea, playlistIzena, (String) list_1.getSelectedValue());
								Vector EzDituenAbesti = necarea.playListakEzDituenAbestiak(erabiltzailea, playlistIzena);
								JList list_1 = new JList(EzDituenAbesti);
								
								Vector DituenAbesti = necarea.playListakDituenAbestiak(erabiltzailea, playlistIzena);
								JList list_2 = new JList(DituenAbesti);
								btnBesteAbestiBat.setVisible(true);
							}
						}
						
					});
				
				}
					}
				});
			}
			
		});
		
		btnBesteAbestiBat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBesteAbestiBat.setVisible(false);
				Vector EzDituenAbesti = necarea.playListakEzDituenAbestiak(erabiltzailea, label_1.getText());
				JList list_1 = new JList(EzDituenAbesti);
				
				Vector DituenAbesti = necarea.playListakDituenAbestiak(erabiltzailea, label_1.getText());
				JList list_2 = new JList(DituenAbesti);	
				
				btnGehitu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(list_1.getSelectedIndex()!=-1) {
							necarea.playListariGehituAbestia (erabiltzailea, label_1.getText(), (String) list_1.getSelectedValue());
							Vector EzDituenAbesti = necarea.playListakEzDituenAbestiak(erabiltzailea, textField.getText().trim());
							JList list_1 = new JList(EzDituenAbesti);
							
							Vector DituenAbesti = necarea.playListakDituenAbestiak(erabiltzailea, label_1.getText());
							JList list_2 = new JList(DituenAbesti);
							btnBesteAbestiBat.setVisible(true);
						}
					}
					
				});
				
			}
		});
		
		btnHonetan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1) {
					label_1.setText((String) list.getSelectedValue());
					lblHautatuSartuNahi.setVisible(true);
					lblJadaSartutaDauden.setVisible(true);
					scrollPane_1.setVisible(true);
					scrollPane_2.setVisible(true);
					btnGehitu.setVisible(true);
					
					Vector EzDituenAbesti = necarea.playListakEzDituenAbestiak(erabiltzailea, label_1.getText());
					JList list_1 = new JList(EzDituenAbesti);
					
					Vector DituenAbesti = necarea.playListakDituenAbestiak(erabiltzailea, label_1.getText());
					JList list_2 = new JList(DituenAbesti);	
					
					btnGehitu.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(list_1.getSelectedIndex()!=-1) {
								necarea.playListariGehituAbestia (erabiltzailea, label_1.getText(), (String) list_1.getSelectedValue());
								Vector EzDituenAbesti = necarea.playListakEzDituenAbestiak(erabiltzailea, label_1.getText());
								JList list_1 = new JList(EzDituenAbesti);
								
								Vector DituenAbesti = necarea.playListakDituenAbestiak(erabiltzailea, label_1.getText());
								JList list_2 = new JList(DituenAbesti);
								btnBesteAbestiBat.setVisible(true);
							}
						}
						
					});
				}
			}
		});
		
		
	}
}
