package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.lti.model.Customer;

//Data Access Object 
public class CustomerDao {
	Connection conn=null;
	PreparedStatement stmt;

	public void addCustomer (Customer customer) {
		try {
			
			Properties dbProps=new Properties();
			dbProps.load(this.getClass().getClassLoader().getResourceAsStream("prod-db.properties"));
			
			Class.forName(dbProps.getProperty("driver"));
			conn = DriverManager.getConnection(dbProps.getProperty("url"),dbProps.getProperty("user"),dbProps.getProperty("pass"));

			String sql = "insert into customerLTI_AS values(?,?,?)";
			
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, customer.getId());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getEmail());
			stmt.executeUpdate();		
			
		} catch (Exception e) { e.printStackTrace();} 
		finally {
			if (conn != null)
			try {conn.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
		}
	}
}
