package com.ibik.pbo.uas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdatePage extends JFrame {
    private JTextField idStaffTextField;
    private JTextField attributeNameTextField;
    private JTextField newValueTextField;
    private JButton updateDataButton, kembalibutton;
    private JButton btnkembali;

    public void UpdatePage() {
    	setLocationRelativeTo(null);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        placeComponents(panel);
        
        btnkembali = new JButton("Kembali");
        btnkembali.setBounds(150, 115, 89, 25);
        btnkembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				dispose();
            }
        });
        panel.add(btnkembali);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel idStaffLabel = new JLabel("ID Staff:");
        idStaffLabel.setBounds(10, 20, 80, 25);
        panel.add(idStaffLabel);

        idStaffTextField = new JTextField(20);
        idStaffTextField.setBounds(150, 20, 200, 25);
        panel.add(idStaffTextField);

        JLabel attributeNameLabel = new JLabel("Atribut yang akan diupdate:");
        attributeNameLabel.setBounds(10, 50, 180, 25);
        panel.add(attributeNameLabel);

        attributeNameTextField = new JTextField(20);
        attributeNameTextField.setBounds(200, 50, 150, 25);
        panel.add(attributeNameTextField);

        JLabel newValueLabel = new JLabel("Data baru:");
        newValueLabel.setBounds(10, 80, 80, 25);
        panel.add(newValueLabel);

        newValueTextField = new JTextField(20);
        newValueTextField.setBounds(150, 80, 200, 25);
        panel.add(newValueTextField);

        updateDataButton = new JButton("Update");
        updateDataButton.setBounds(261, 115, 89, 25);
        updateDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					updateData();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
        });
        panel.add(updateDataButton);
    }

    private void updateData() throws SQLException {
        String idStaff = idStaffTextField.getText();
        String attributeName = attributeNameTextField.getText();
        String newValue = newValueTextField.getText();

        if (idStaff.isEmpty() || attributeName.isEmpty() || newValue.isEmpty()) {
            System.out.println("ID Staff, Atribut, dan Nilai baru harus diisi!");
            return;
        }

        query.updateData(attributeName, newValue, idStaff);
    }

    public static void main(String[] args) {
        new UpdatePage();
    }
}
