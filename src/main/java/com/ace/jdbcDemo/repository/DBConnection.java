package com.ace.jdbcDemo.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static final Properties properties;
	
	private Connection con;

	static {
		// load properties file
		properties = new Properties();
		try {
			properties.load(CustomerRepositoryImp.class.getClassLoader().getResourceAsStream("customer.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// loading driver class
		try {
			Class.forName(properties.getProperty("db.mysql.driver.class"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public Connection getNewDBConnection() {
		
		try {

			// creating connection
			con = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"),
					properties.getProperty("db.password"));
			//always make autocommit false
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
