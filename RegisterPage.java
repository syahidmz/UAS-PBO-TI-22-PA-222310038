package com.ibik.pbo.uas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class RegisterPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
		public void RegisterPage() {
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setTitle("REGISTER");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(22, 54, 75, 14);
		contentPane.add(lblNewLabel);
		
		textUsername = new JTextField();
		textUsername.setBounds(107, 51, 96, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(22, 94, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 91, 96, 20);
		contentPane.add(passwordField);
		
		String jabatan[]= {"Kasir", "Admin", "Distributor"};
		JComboBox pilihJabatan = new JComboBox(jabatan);
		pilihJabatan.setBounds(107, 129, 96, 22);
		contentPane.add(pilihJabatan);
		
		JLabel lblNewLabel_2 = new JLabel("Jabatan");
		lblNewLabel_2.setBounds(22, 133, 49, 14);
		contentPane.add(lblNewLabel_2);
	}
	}
