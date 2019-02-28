package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBLoginService {
	Connection conn;
	ResultSet rs;
	PreparedStatement stmt,sm;


	public boolean isValidUser(String user, String pass) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");

			String sql = "select count(1) from TBL_USER where username= ? AND password= ? and active='Y' ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, user);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 1) {

					return true;
				}
				return false;
			} else
				return false;
		} catch (Exception e) { // bad , should catch individual exception(s)
			e.printStackTrace();// very bad ,should throw user defined exception instead
			return false;
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				rs.close();
			} catch (Exception e) {
			}
		}

	}
	public String fName(String user) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			
			String sql2 = "select fullname from TBL_USER where username=? ";
			sm=conn.prepareStatement(sql2);
			sm.setString(1,user);
			ResultSet rs = sm.executeQuery();
			
			if(rs.next()) {
				String fname=rs.getString("fullname");
				return fname;
			}
			else 
				return "anonymous";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "anonymous";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "anonymous";
		}
		

	}
}
