package com.revature.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.service.ScannerFinder;

public class AllDataDAOImpl implements AllDataDAO {
	static ConnectionFactorySingleton connection = ConnectionFactorySingleton.getCFSInstance();
	static ConnectionFactorySingleton cFS = connection;

	@Override
	public void syncCars() throws SQLException {
		try (Connection connection = cFS.getConnection()){
			
		}
		
	}

	@Override
	public void syncUsers() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncOffers() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncSold() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
