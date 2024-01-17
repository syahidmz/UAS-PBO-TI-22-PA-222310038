package com.ibik.pbo.uas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeletePage extends JFrame {
    private JTextField idStaffTextField;
    private JButton hapusDataButton;
    private JPanel panel_1;

    public void DeletePage() {
        setLocationRelativeTo(null);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel_1 = new JPanel();
        getContentPane().add(panel_1);
        placeComponents(panel_1);
        
        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBounds(66, 56, 89, 23);
        btnKembali.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        panel_1.add(btnKembali);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel_1.setLayout(null);

        JLabel idStaffLabel = new JLabel("ID Staff:");
        idStaffLabel.setBounds(10, 20, 80, 25);
        panel.add(idStaffLabel);

        idStaffTextField = new JTextField(20);
        idStaffTextField.setBounds(66, 20, 199, 25);
        panel.add(idStaffTextField);

        hapusDataButton = new JButton("Hapus Data");
        hapusDataButton.setBounds(165, 56, 100, 25);
        hapusDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					hapusData();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
        });
        panel.add(hapusDataButton);
    }

    private void hapusData() throws SQLException {
        String idStaff = idStaffTextField.getText();

        if (idStaff.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isian kosong", "ID Staff tidak boleh kosong", JOptionPane.ERROR_MESSAGE);
            return;
        }

        query.deleteData(idStaff);
    }

    public static void main(String[] args) {
        new DeletePage();
    }
}
