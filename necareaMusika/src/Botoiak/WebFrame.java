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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import necareaMusika.Necarea;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class WebFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String erabiltzailea,String p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebFrame frame = new WebFrame(erabiltzailea,p);
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
	public WebFrame(String erabiltzailea,String p) throws SQLException {
		Necarea necarea=Necarea.getNecarea();
		setBackground(new Color(245, 255, 250));
		setTitle("Printzipala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 397);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblBilatu = new JLabel("Bilatu:");
		lblBilatu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnBilatu = new JButton("Bilatu");
		btnBilatu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBilatu.setBackground(new Color(135, 206, 250));
		btnBilatu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSartu.setBackground(new Color(135, 206, 250));
		btnSartu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton button = new JButton("Sartu");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		button.setBackground(new Color(135, 206, 250));
		
		JButton button_1 = new JButton("Sartu");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		button_1.setBackground(new Color(135, 206, 250));
		
		JButton button_2 = new JButton("Sartu");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		button_2.setBackground(new Color(135, 206, 250));
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPlay.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnPlay.setBackground(new Color(135, 206, 250));
		
		JButton btnGehitu = new JButton("Gorde");

		btnGehitu.setBackground(new Color(135, 206, 250));
		btnGehitu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnGorde.setBackground(new Color(135, 206, 250));
		
		JButton btnGorde_1 = new JButton("Gorde");
		btnGorde_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnGorde_1.setBackground(new Color(135, 206, 250));
		
		JButton btnGorde_2 = new JButton("Gorde");
		btnGorde_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnGorde_2.setBackground(new Color(135, 206, 250));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(53)
					.addComponent(lblBilatu)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBilatu)
					.addGap(52))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnSartu, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnPlay, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(btnGorde, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addComponent(button, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
									.addGap(39))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(52)
							.addComponent(btnGehitu)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnGorde_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1))
							.addGap(51)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnGorde_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))))
					.addGap(73))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBilatu)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBilatu))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSartu)
							.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGehitu)
						.addComponent(btnGorde_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGorde, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGorde_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(175, 238, 238));
		scrollPane_3.setColumnHeaderView(panel_5);
		
		JLabel lblPlaylistak = new JLabel("PlayList-ak:");
		lblPlaylistak.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		panel_5.add(lblPlaylistak);
		
		Vector elemPlaylist=necarea.playlistGuztiak();
		JList list_3 = new JList(elemPlaylist);
		scrollPane_3.setViewportView(list_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(175, 238, 238));
		scrollPane_2.setColumnHeaderView(panel_4);
		
		JLabel lblArtistak = new JLabel("Artistak:");
		lblArtistak.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		panel_4.add(lblArtistak);
		
		Vector elemArtista=necarea.artistaGuztiak();
		JList list_2 = new JList(elemArtista);
		scrollPane_2.setViewportView(list_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		scrollPane_1.setColumnHeaderView(panel_3);
		
		JLabel lblAlbumak = new JLabel("Albumak:");
		lblAlbumak.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		panel_3.add(lblAlbumak);
		
		Vector elemAlbum=necarea.albumGuztiak();
		JList list_1 = new JList(elemAlbum);
		scrollPane_1.setViewportView(list_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(175, 238, 238));
		scrollPane.setColumnHeaderView(panel_2);
		
		JLabel lblAbestiak = new JLabel("Abestiak:");
		panel_2.add(lblAbestiak);
		lblAbestiak.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		Vector elemAbesti=necarea.abestiGuztiak();
		JList list = new JList(elemAbesti);
		scrollPane.setViewportView(list);
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
		
		
		//Boton bilatu
				btnBilatu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String Busqueda=textField_1.getText();
						
						//ABESTI
						DefaultListModel modeloAbesti = new DefaultListModel();
						list.removeAll();
						for(int i=0;i<elemAbesti.size();i++){
							String s=(String) elemAbesti.get(i);
							if(s.contains(Busqueda)){
									modeloAbesti.addElement(s);
							}
						}
						list.setModel(modeloAbesti);
						
						//ALBUM
						DefaultListModel modeloAlbum = new DefaultListModel();
						list_1.removeAll();
						for(int i=0;i<elemAlbum.size();i++){
							String s=(String) elemAlbum.get(i);
							if(s.contains(Busqueda)){
									modeloAlbum.addElement(s);
							}
						}
						list_1.setModel(modeloAlbum);
						
						
						//ARTISTA
						DefaultListModel modeloArtista = new DefaultListModel();
						list_2.removeAll();
						for(int i=0;i<elemArtista.size();i++){
							String s=(String) elemArtista.get(i);
							if(s.contains(Busqueda)){
									modeloArtista.addElement(s);
							}
						}
						list_2.setModel(modeloArtista);
						
						
						
						//PLAYLIST
						DefaultListModel modeloPlaylist = new DefaultListModel();
						list_3.removeAll();
						for(int i=0;i<elemPlaylist.size();i++){
							String s=(String) elemPlaylist.get(i);
							if(s.contains(Busqueda)){
									modeloPlaylist.addElement(s);
							}
						}
						list_3.setModel(modeloPlaylist);						
					}
				});
				
		//abestian sartu
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1) {
					AbestiaInfoFrame aInfo=null;
					try {
						aInfo= new AbestiaInfoFrame(erabiltzailea,p,(String) list.getSelectedValue());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					aInfo.setVisible(true);
					dispose();
				}
			}
		});
		
		//abestia play
		btnPlay.addActionListener(new ActionListener() {
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
		
		//abestia gorde
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1) {
					necarea.abestiaGorde(erabiltzailea,(String) list.getSelectedValue());
				}
			}
		});
		
		//almunean sartu
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_1.getSelectedIndex()!=-1) {
					AlbumInfoFrame albumInfo=null;
					try {
						albumInfo= new AlbumInfoFrame(erabiltzailea,p,(String) list_1.getSelectedValue());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					albumInfo.setVisible(true);
					dispose();
				}
			}
		});
		
		//albuma gorde
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_1.getSelectedIndex()!=-1) {
					necarea.albumaGorde(erabiltzailea, (String) list_1.getSelectedValue());
				}
			}
		});
		
		//artistan sartu
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_2.getSelectedIndex()!=-1) {
					ArtistaInfoFrame artistaInfo=null;
					try {
						artistaInfo = new ArtistaInfoFrame(erabiltzailea,p,(String) list_2.getSelectedValue());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					artistaInfo.setVisible(true);
					dispose();
				}
			}
		});
		
		//artista gorde
		btnGorde_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_2.getSelectedIndex()!=-1) {
					necarea.artistaGorde(erabiltzailea,(String) list_2.getSelectedValue());
				}
			}
		});
		
		//playlistan sartu
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_3.getSelectedIndex()!=-1) {
					PlayListInfoFrame plInfo=null;
					try {
						plInfo = new PlayListInfoFrame(erabiltzailea,p,(String) list_3.getSelectedValue());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					plInfo.setVisible(true);
					dispose();
				}
			}
		});
		
		//playlista gorde
		btnGorde_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_3.getSelectedIndex()!=-1) {
					necarea.playlistGorde(erabiltzailea, (String) list_3.getSelectedValue());
				}
			}
		});
				
	}
}
