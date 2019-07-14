package com.revature.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Car;
import com.revature.service.ScannerFinder;

public class AllDataDAOImpl implements AllDataDAO {
	public static Logger log = Logger.getRootLogger();
	static ConnectionFactorySingleton connection = ConnectionFactorySingleton.getCFSInstance();
	static ConnectionFactorySingleton cFS = connection;

	@Override
	public void syncCarsUp(HashMap<Integer, Car> lotInventory, ArrayList<Integer> usedSKU) throws SQLException {
		
		Connection connection = cFS.getConnection();
		//PREPARED STATEMENT - INSERTING ONE CAR FROM MAP AT A TIME
		String sql1 = "TRUNCATE TABLE CARS";
		PreparedStatement ps1 = connection.prepareStatement(sql1);
		ps1.executeUpdate();
		
		for(int i = 0; i < usedSKU.size(); i++) {
		String sql2 = "INSERT INTO CARS VALUES(?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql2);
		ps.setInt(1,lotInventory.get(usedSKU.get(i)).getSku());
		ps.setString(2,lotInventory.get(usedSKU.get(i)).getColor());
		ps.setString(3,lotInventory.get(usedSKU.get(i)).getMake());
		ps.setString(4,lotInventory.get(usedSKU.get(i)).getModel());
		ps.setInt(5,lotInventory.get(usedSKU.get(i)).getMiles());
		ps.setInt(6,lotInventory.get(usedSKU.get(i)).getYear());
		ps.setDouble(7,lotInventory.get(usedSKU.get(i)).getPrice());
		ps.executeUpdate();
		}
		
	}
	
	@Override
	public void syncCarsDown(HashMap<Integer, Car> lotInventory, ArrayList<Integer> usedSKU) throws SQLException {
		Connection connection = cFS.getConnection();
		Statement statement = null;
		String query = 
				"SELECT * FROM CARS";
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			System.out.println(rs.findColumn("CAR_SKU"));
			
		} catch (SQLException e) {
			log.info(e);
		} finally {
			if (statement !=null) {
				statement.close();
			}
		}
		
	}

	@Override
	public void syncUsersUp() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void syncUsersDown() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncOffersUp() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void syncOffersDown() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void syncSoldUp() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void syncSoldDown() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
