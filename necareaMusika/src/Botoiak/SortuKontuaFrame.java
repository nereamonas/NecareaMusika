package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Taulak.Necarea;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SortuKontuaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
     
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortuKontuaFrame frame = new SortuKontuaFrame();
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
	public SortuKontuaFrame() throws SQLException {
		setBackground(new Color(0, 0, 255));
		setTitle("Kontua sortu");
		Necarea necarea=Necarea.getNecarea();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 254);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnSartu.setBackground(new Color(135, 206, 250));
		btnSartu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		panel_2.add(label_1);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(108)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPasahitza)
								.addComponent(lblErabiltzailea))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(10)
											.addComponent(btnSartu))
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(214)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(189, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblErabiltzailea)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPasahitza)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSartu)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton button = new JButton("Kontua daukat. Saioa hasi");
		button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		button.setBackground(new Color(135, 206, 250));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(button);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		contentPane.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblKontuaSortu = new JLabel("Kontua sortu");
		panel_3.add(lblKontuaSortu);
		lblKontuaSortu.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		
		
		//Sartu-ri ematean:
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setBackground(Color.WHITE);
				JPanel panel_2 = new JPanel();
				label_1.setText("");
				
				//Erabiltzailea hartu
				String erabiltzailea=textField_1.getText().trim();
				if (textField_1.getText().length()==0) {
					label_1.setText("Ez duzu erabiltzailea sartu");
					textField_1.setBackground(Color.RED);
				}else{
					//Pasahitza hartu:
					String pasahitza=textField.getText().trim();
					if (textField.getText().length()==0) {
						label_1.setText("Ez duzu pasahitza sartu");
						textField.setBackground(Color.RED);
					}else {
					
				
				boolean dago=necarea.pertsonaBilatu(erabiltzailea);
				
				
				//Dena ondo dago, erabiltzailea dagoen begiratu eta bestela sortu
				if (dago) {
						label_1.setText("Erabiltzaile hori hartuta dago jada, beste bat aukeratu");
						
				}else {
					necarea.erabiltzaileaGehitu(erabiltzailea,pasahitza);
					label_1.setText("Zure erabiltzailea sortu da. ");
					JButton btnSartu2 = new JButton("Saioa hasi");
					panel.add(btnSartu2);
					btnSartu2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
					btnSartu2.setBackground(new Color(135, 206, 250));
					btnSartu2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnSartu2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							SartuKontuanFrame b=null;
							try {
								b = new SartuKontuanFrame();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							b.setVisible(true);
							dispose();
						}
					});
				}
			}
				}
			}
			
		});
			
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SartuKontuanFrame b=null;
				try {
					b = new SartuKontuanFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				b.setVisible(true);
				dispose();	
			}
		});
		
		
	}
}