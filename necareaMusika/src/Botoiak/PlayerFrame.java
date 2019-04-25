package Botoiak;  

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Abestiak.Reproductor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;


public class PlayerFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String abestia,String erabiltzailea,String p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerFrame frame = new PlayerFrame(abestia,erabiltzailea,p);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */ 
	public PlayerFrame(String abestia,String erabiltzailea,String p) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblAbestia = new JLabel("Abestia: ");
		lblAbestia.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		panel.add(lblAbestia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnPausa = new JButton("Pausa");
		btnPausa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPausa.setBackground(new Color(135, 206, 250));
		btnPausa.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		

		btnPlay.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnPlay.setBackground(new Color(135, 206, 250));
		
		JButton btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJarraitu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnJarraitu.setBackground(new Color(135, 206, 250));
		
		JButton btnStop = new JButton("Stop");
		btnStop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStop.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnStop.setBackground(new Color(135, 206, 250));
		
		JButton btnItxi = new JButton("Itxi");
		btnItxi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnItxi.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnItxi.setBackground(new Color(135, 206, 250));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/Abestiak/"+abestia+".jpg"));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(152)
					.addComponent(btnItxi, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(169, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnPausa)
					.addGap(28)
					.addComponent(btnJarraitu)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(90))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPausa)
						.addComponent(btnJarraitu, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnItxi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		Reproductor r=new Reproductor();
		r.AbrirFichero("src/Abestiak/"+abestia+".mp3");
		r.Play();
	
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r.Play();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnPausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r.Pausa();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnJarraitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r.Continuar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r.Stop();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r.Stop();
					WebFrame web= new WebFrame(erabiltzailea, p);
					web.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		
	}
}