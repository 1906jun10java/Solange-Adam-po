package com.revature.connection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactorySingleton {
	
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
			properties.load(new FileReader("conneciton.properties"));
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(
					properties.getProperty("Earl"), properties.getProperty("past"), 
					properties.getProperty("time"));
		}
		
		
	}

}
