package com.ibik.pbo.uas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksidb {
	private static Connection conn;
	
	//method buat koneksi ke database
	public static Connection connect() throws SQLException{
		String host ="localhost:3306";
		String dbName ="book_store";
		String dbuser ="root";
		String dbpassword ="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+"/"+dbName, dbuser, dbpassword);
		return conn;
	}
	//method buat close koneksi
	public static Connection close() throws SQLException{
		conn.close();
		return conn;
	}
}