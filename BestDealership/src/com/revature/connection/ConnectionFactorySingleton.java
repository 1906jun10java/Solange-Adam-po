package com.revature.connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionFactorySingleton {
	public static Logger log = Logger.getRootLogger();
	
	private static ConnectionFactorySingleton cFS = new ConnectionFactorySingleton();
	
	private ConnectionFactorySingleton() {
		super();
	}
	
	// checking if one already exists, otherwise creates one and returns it
	public static synchronized ConnectionFactorySingleton getCFSInstance() {
		if(cFS == null) {
			cFS = new ConnectionFactorySingleton();
		}
		return cFS;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		Properties properties = new Properties();
		try {
		properties.load(new FileReader("connection.properties"));
		Class.forName(properties.getProperty("driver"));
		connection = DriverManager.getConnection(
					properties.getProperty("Earl"), properties.getProperty("past"), 
					properties.getProperty("time"));
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return connection;
		
	}

}
