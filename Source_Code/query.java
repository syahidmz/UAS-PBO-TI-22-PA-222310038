package com.ibik.pbo.uas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ibik.pbo.uas.*;

//kumpulan query
public class query {
	
	//query insert ke database
	private String queryinsert = "insert into staff(id_staff, nama, jabatan, alamat, no_telepon, username, password)" + "values(?,?,?,?,?,?,?)";
	//query untuk menampilkan data di database
	private String querySelectAll = "select * from staff";
	//query untuk menghapus data di database
	public static String deleteDataQuery() {
        return "DELETE FROM staff WHERE id_staff = ?";
    }
	//query untuk 
	public static String updateDataQuery(String attributeName) {
        return "UPDATE staff SET " + attributeName + " = ? WHERE id_staff = ?";
    }
	//method buat liat data di database
	public List<Staff>findAll() throws Exception{
		List<Staff>hasil = new ArrayList<Staff>();
		
		Connection c = new koneksidb().connect();
		PreparedStatement psCariSemuaProduk = c.prepareStatement(querySelectAll);
		
		ResultSet rs = psCariSemuaProduk.executeQuery();
		while(rs.next()) {
			Staff staff = konversiResultSet(rs);
			hasil.add(staff);
		}
		
		c.close();
		return hasil;
	}
	//method konversi buat liat data di database
	private Staff konversiResultSet(ResultSet rs) throws SQLException{
		Staff staff = new Staff();
		staff.setIdstaff(rs.getString("id_staff"));
		staff.setNama(rs.getString("nama"));
		staff.setJabatan(rs.getString("jabatan"));
		staff.setAlamat(rs.getString("alamat"));
		staff.setNotlpn(rs.getString("no_telepon"));
		staff.setUsername(rs.getString("username"));
		staff.setPassword(rs.getString("password"));
		return staff;
	}
	//method buat save data ke database
	public void saved(Staff staff) throws Exception{
		Connection c = new koneksidb().connect();
		
		PreparedStatement psInsert = c.prepareStatement(queryinsert);
		
		psInsert.setString(1, staff.getIdstaff());
		psInsert.setString(2, staff.getNama());
		psInsert.setString(3, staff.getJabatan());
		psInsert.setString(4, staff.getAlamat());
		psInsert.setString(5, staff.getNotlpn());
		psInsert.setString(6, staff.getUsername());
		psInsert.setString(7, staff.getPassword());
		
		psInsert.executeUpdate();
		
		c.close();
	}
	
		//method buat delete data di database
	    public static void deleteData(String idStaff) throws SQLException {
	        Connection connection = koneksidb.connect();
	        try {
	            String query = deleteDataQuery();
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, idStaff);
	                int rowsAffected = preparedStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "Id Staff tidak ditemukan!", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    //method buat update data di database
	    public static void updateData(String attributeName, String newValue, String idStaff) throws SQLException {
	        Connection connection = koneksidb.connect();
	        try {
	            String query = updateDataQuery(attributeName);
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, newValue);
	                preparedStatement.setString(2, idStaff);

	                int rowsAffected = preparedStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Data dengan ID Staff tersebut tidak ditemukan.");
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } 
	    }
	}

