package com.ibik.pbo.uas;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.ibik.pbo.uas.CekData;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNama;
	private JTextField textAlamat;
	private JTextField textNotlpn;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JTextField textJabatan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public void MainPage() {
		setTitle("Management Staff");
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 403, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Staff");
		lblNewLabel.setBounds(10, 83, 72, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nama");
		lblNewLabel_1.setBounds(10, 108, 72, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Jabatan");
		lblNewLabel_2.setBounds(10, 134, 72, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Alamat");
		lblNewLabel_3.setBounds(10, 159, 72, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No Telepon");
		lblNewLabel_4.setBounds(10, 183, 72, 14);
		panel.add(lblNewLabel_4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(90, 278, 96, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				ValidatorForm();
			}
		});
		panel.add(btnSubmit);
		
		JLabel lblNewLabel_5 = new JLabel("Username");
		lblNewLabel_5.setBounds(10, 208, 72, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(10, 233, 72, 14);
		panel.add(lblNewLabel_6);
		
		textId = new JTextField();
		textId.setBounds(90, 80, 96, 20);
		panel.add(textId);
		textId.setColumns(10);
		
		textNama = new JTextField();
		textNama.setBounds(90, 105, 96, 20);
		panel.add(textNama);
		textNama.setColumns(10);
		
		textAlamat = new JTextField();
		textAlamat.setBounds(90, 156, 96, 20);
		panel.add(textAlamat);
		textAlamat.setColumns(10);
		
		textNotlpn = new JTextField();
		textNotlpn.setBounds(90, 180, 96, 20);
		panel.add(textNotlpn);
		textNotlpn.setColumns(10);
		
		textUsername = new JTextField();
		textUsername.setBounds(90, 205, 96, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 230, 96, 20);
		panel.add(passwordField);
		
		textJabatan = new JTextField();
		textJabatan.setBounds(90, 131, 96, 20);
		panel.add(textJabatan);
		textJabatan.setColumns(10);
		
		JButton btnCek = new JButton("Cek Data");
		btnCek.setBounds(265, 79, 89, 23);
		btnCek.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	CekData cek = new CekData();
	    		cek.CekData();
	        	}
	        });
		panel.add(btnCek);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(265, 130, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        		DeletePage delete = new DeletePage();
	        		delete.DeletePage();
	        	}
	        });
		panel.add(btnDelete);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.setBounds(265, 179, 89, 23);
		btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				UpdatePage update = new UpdatePage();
				update.UpdatePage();
            }
        });
		panel.add(btnupdate);
		
		JLabel lblNewLabel_7 = new JLabel("Insert Data Karyawan Baru");
		lblNewLabel_7.setBounds(10, 40, 176, 14);
		panel.add(lblNewLabel_7);
		
		JButton btnlogout = new JButton("Logout");
		btnlogout.setBounds(265, 229, 89, 23);
		btnlogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				dispose();
            }
        });
		panel.add(btnlogout);
		
		JLabel lblNewLabel_8 = new JLabel("Menu :");
		lblNewLabel_8.setBounds(266, 40, 49, 14);
		panel.add(lblNewLabel_8);
		
		JTextPane txtpnNoteId = new JTextPane();
		txtpnNoteId.setBackground(new Color(255, 255, 255));
		txtpnNoteId.setText("NOTE :\r\nID Staff : k untuk kasir, a untuk admin dan diteruskan dengan 3 angka.");
		txtpnNoteId.setBounds(10, 312, 150, 89);
		panel.add(txtpnNoteId);
		
	}
	
	private void ValidatorForm() {
        if (textId.getText().isEmpty() || textNama.getText().isEmpty()|| textJabatan.getText().isEmpty()|| textAlamat.getText().isEmpty()|| textNotlpn.getText().isEmpty()|| textUsername.getText().isEmpty()|| passwordField.getText().isEmpty()) {
            Object message = "Harap masukan semua data!";
            JOptionPane.showMessageDialog(null, message);
        } else {
            try {
                Insert2database();
                JOptionPane.showMessageDialog(null, "Successfully saved");
                textId.setText("");
                textNama.setText("");
                textJabatan.setText("");
                textAlamat.setText("");
                textNotlpn.setText("");
                textUsername.setText("");
        	    passwordField.setText("");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed save. Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

	private void Insert2database() throws Exception {
	    Staff staff = new Staff();
	    staff.setIdstaff(textId.getText());
	    staff.setNama(textNama.getText());
	    staff.setJabatan(textJabatan.getText());
	    staff.setAlamat(textAlamat.getText());
	    staff.setNotlpn(textNotlpn.getText());
	    staff.setUsername(textUsername.getText());
	    staff.setPassword(passwordField.getText());
	    
	    
	    query query = new query();
	    query.saved(staff);
	}
}
