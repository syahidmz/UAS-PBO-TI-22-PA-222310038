package com.ibik.pbo.uas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.ibik.pbo.uas.*;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
// komen buat penjelasan
public class LoginPage extends JFrame {
	//deklarasi variable
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField Password;
	private JTextField textJabatan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	// pembuatan frame untuk login page
	public LoginPage() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 248, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Username = new JTextField();
		Username.setBounds(106, 45, 96, 20);
		contentPane.add(Username);
		Username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 48, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 88, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		Password = new JPasswordField();
		Password.setBounds(106, 85, 96, 20);
		contentPane.add(Password);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(106, 169, 96, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Jabatan");
		lblNewLabel_2.setBounds(10, 127, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		textJabatan = new JTextField();
		textJabatan.setBounds(106, 124, 96, 20);
		contentPane.add(textJabatan);
		textJabatan.setColumns(10);
		//memasukan actionlistener supaya ketika login dapat masuk ke mainpage
		btnLogin.addActionListener(new ActionListener() {
	        @SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
	        	String username = Username.getText();
	        	String password = Password.getText();
	        	String jabatan = textJabatan.getText();
	        	
	        	try {
	        		koneksidb.connect();
	        		//query untuk mengambil data dari database
	        		String query = "SELECT * FROM staff WHERE username = ? AND password = ? AND jabatan = ?";
	        		//membuat statement buat execute query
	        		PreparedStatement ps = koneksidb.connect().prepareStatement(query);
	        		ps.setString(1, username);
	        		ps.setString(2, password);
	        		ps.setString(3, "admin");
	        		ResultSet rs = ps.executeQuery();
	        		//logic buat jika username, password, jabatan = admin bisa masuk ke mainpage
	        		if("admin".equals(username) && "admin".equals(String.valueOf(password)) && "admin".equals(jabatan)){
	        			MainPage main = new MainPage();
	        			main.MainPage();
	        			
	        			dispose();
	        		}
	        		else if(rs.next()) {
	        			MainPage main = new MainPage();
	        			main.MainPage();
	        			
	        			dispose();
	        			//logic kalo jabatan bukan admin tidak bisa login
	        		}else {
	        			JOptionPane.showMessageDialog(null, "hanya admin yang dapat mengakses manegement staff atau cek username atau password");
	        		}
	        		//mengakhiri koneksi ke database
	        		koneksidb.close();	
	        	}catch (Exception ex) {
	        		ex.printStackTrace();
	        	}
	        }
	        });
	}
}

