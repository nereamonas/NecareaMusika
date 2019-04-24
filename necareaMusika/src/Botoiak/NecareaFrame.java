package Botoiak;  

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import necareaMusika.Konektatu;
import necareaMusika.Necarea;

public class NecareaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NecareaFrame frame = new NecareaFrame();
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
	public NecareaFrame() throws SQLException {
		
		Necarea necarea= Necarea.getNecarea();
		necarea.guztiaHartu();
		
		
		setTitle("Necarea");
		setBackground(new Color(255, 255, 255));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
				
		JButton btnNecareaPelikulak = new JButton("NECAREA MUSIKA");
		btnNecareaPelikulak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnNecareaPelikulak.setBackground(new Color(135, 206, 250));
		btnNecareaPelikulak.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 41));
		panel.add(btnNecareaPelikulak);
		
		JLabel lblOngiEtorriGure = new JLabel("Ongi etorri gure Necarea musika aplikaziora.");
		lblOngiEtorriGure.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		panel.add(lblOngiEtorriGure);
		
		JLabel lblZuenGustukoaIzatea = new JLabel("Zuen gustukoa izatea espero dugu");
		lblZuenGustukoaIzatea.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		panel.add(lblZuenGustukoaIzatea);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/logofin2.png"));
		panel.add(label);
		
		btnNecareaPelikulak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SarreraFrame b=new SarreraFrame();
				b.setVisible(true);
				dispose();	
			}
		});
	
	}

}
