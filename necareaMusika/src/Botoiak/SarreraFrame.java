package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import necareaMusika.Konektatu;
import necareaMusika.Necarea;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SarreraFrame extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SarreraFrame frame = new SarreraFrame();
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
	public SarreraFrame(){
		setTitle("Necarea");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnSaioaHasi = new JButton("Saioa hasi");
		btnSaioaHasi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaioaHasi.setBackground(new Color(135, 206, 250));
		btnSaioaHasi.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		
		//Saioa hasi-ri ematean:
		btnSaioaHasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SartuKontuanFrame sartuKontuan=null;
				try {
					sartuKontuan = new SartuKontuanFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sartuKontuan.setVisible(true);
				dispose();
			}
		});
		
		JButton btnKontuaSortu = new JButton("Kontua sortu");
		btnKontuaSortu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKontuaSortu.setBackground(new Color(135, 206, 250));
		btnKontuaSortu.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		
		JButton btnDatuBaseaDeskonektatu = new JButton("Datu basea deskonektatu eta itxi");
		btnDatuBaseaDeskonektatu.setBackground(new Color(135, 206, 250));
		btnDatuBaseaDeskonektatu.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(102)
					.addComponent(btnSaioaHasi)
					.addGap(5)
					.addComponent(btnKontuaSortu)
					.addContainerGap(86, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(btnDatuBaseaDeskonektatu)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSaioaHasi)
						.addComponent(btnKontuaSortu))
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addComponent(btnDatuBaseaDeskonektatu)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		//Datu basea deskonektatu eta itxi-ri ematean:
		btnDatuBaseaDeskonektatu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							Necarea nc= Necarea.getNecarea();
							nc.deskonektatu();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dispose();
					}
				});
				
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNecareaPelikulak = new JLabel("NECAREA MUSIKA");
		panel_1.add(lblNecareaPelikulak);
		lblNecareaPelikulak.setFont(new Font("Yu Gothic UI", Font.BOLD, 28));
		
		//Kontua sortu-ri ematean:
		btnKontuaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SortuKontuaFrame sortuKontu=null;
				try {
					sortuKontu = new SortuKontuaFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				sortuKontu.setVisible(true);
				dispose();
			}
		});
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
