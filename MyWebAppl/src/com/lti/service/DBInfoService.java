package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lti.servlet.Employee;

public class DBInfoService {

	Connection conn;
	ResultSet rs;
	PreparedStatement stmt,sm;
	private int id;



	public boolean isValidEmp(String emp) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");

			String sql = "select count(1) from employees where employee_id= ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, emp);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 1) {

					return true;
				}
				return false;
			} else
				return false;
		} catch (Exception e) { 
			e.printStackTrace();
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

	////////////DATA/////////
	public Employee empDetails(String emp) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");

			String sql = "select employee_id,first_name,email,salary,phone_number,hire_date from employees where employee_id= ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, emp);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Employee e=new Employee();
				e.setName(rs.getString("first_name"));
				e.setEmail(rs.getString("email"));
				e.setSalary(rs.getDouble("salary"));
				e.setDate(rs.getString("hire_date"));
				e.setPhone_number(rs.getString("phone_number"));
				
				return e;
				}
				return null;
		
		} catch (Exception e) { 
			e.printStackTrace();
			return null;
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

	
	



}
