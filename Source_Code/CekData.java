package com.ibik.pbo.uas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CekData extends JFrame {
	private JPanel contentPane;
	private JTable jt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CekData frame = new CekData(); frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					}
			}
		});
	}
	public void CekData () {
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setTitle("Query Retrive");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 474, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Table of Staff"); 
		panel.add(lblNewLabel);
		JButton kembali = new JButton("Kembali");
		kembali.setSize(72, 14);
		kembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				dispose();
            }
        });
		panel_2.add(kembali);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		DefaultTableModel tableModel = FecthDataSelect(); 
		jt=new JTable(tableModel);
		
		jt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GetSelectedData();
			}
		});
		
		JScrollPane sp = new JScrollPane(jt);
		panel_1.add(sp);
	}
	
	public DefaultTableModel FecthDataSelect() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id Staff");
		tableModel.addColumn("Nama");
		tableModel.addColumn("Jabatan");
		tableModel.addColumn("Alamat");
		tableModel.addColumn("No Telepon");
		tableModel.addColumn("Username");
		tableModel.addColumn("Password");
		
		query query = new query();
		
		try {
			List<Staff>staff = query.findAll();
			for(int i = 0; i<staff.size(); i++) {
				String data[]= {staff.get(i).getIdstaff(),
				staff.get(i).getNama(),
				staff.get(i).getJabatan(),
				staff.get(i).getAlamat(),
				staff.get(i).getNotlpn(),
				staff.get(i).getUsername(),
				staff.get(i).getPassword()
			};
				tableModel.addRow(data);
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Failed load data. Error:"+e.getMessage());
	}
		return tableModel;
	}
	
	protected void GetSelectedData() {
		DefaultTableModel jtModel = (DefaultTableModel) jt.getModel();
		int selectedRow = jt.getSelectedRow();
		System.out.println("You just click row "+selectedRow);
		String id_staff = jtModel.getValueAt(selectedRow, 0).toString();
		String nama = jtModel.getValueAt(selectedRow, 1).toString();
		String jabatan = jtModel.getValueAt(selectedRow, 2).toString();
		String alamat = jtModel.getValueAt(selectedRow, 3).toString();
		String no_telepon = jtModel.getValueAt(selectedRow, 4).toString();
		String username = jtModel.getValueAt(selectedRow, 5).toString();
		String password = jtModel.getValueAt(selectedRow, 6).toString();
		
		System.out.println("Data:");
		System.out.println("Id Staff: "+id_staff);
		System.out.println("Nama: "+nama);
		System.out.println("Jabatan: "+jabatan);
		System.out.println("Alamat: "+alamat);
		System.out.println("No Telepon: "+no_telepon);
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
	}
}