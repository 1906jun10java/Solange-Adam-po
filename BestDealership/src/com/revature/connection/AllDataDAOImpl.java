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
import com.revature.beans.User;
import com.revature.data.FirstStructure;
import com.revature.data.LocalUserData;
import com.revature.service.ScannerFinder;

public class AllDataDAOImpl implements AllDataDAO {
	public static Logger log = Logger.getRootLogger();
	static ConnectionFactorySingleton connection = ConnectionFactorySingleton.getCFSInstance();
	static ConnectionFactorySingleton cFS = connection;

	@Override
	public void syncCarsUp(HashMap<Integer, Car> lotInventory, ArrayList<Integer> usedSKU) throws SQLException {

		Connection connection = cFS.getConnection();
		// PREPARED STATEMENT - INSERTING ONE CAR FROM MAP AT A TIME
		String sql1 = "TRUNCATE TABLE CARS";
		PreparedStatement ps1 = connection.prepareStatement(sql1);
		ps1.executeUpdate();

		for (int i = 0; i < usedSKU.size(); i++) {
			String sql2 = "INSERT INTO CARS VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql2);
			ps.setInt(1, lotInventory.get(usedSKU.get(i)).getSku());
			ps.setString(2, lotInventory.get(usedSKU.get(i)).getColor());
			ps.setString(3, lotInventory.get(usedSKU.get(i)).getMake());
			ps.setString(4, lotInventory.get(usedSKU.get(i)).getModel());
			ps.setInt(5, lotInventory.get(usedSKU.get(i)).getYear());
			ps.setInt(6, lotInventory.get(usedSKU.get(i)).getMiles());
			ps.setDouble(7, lotInventory.get(usedSKU.get(i)).getPrice());
			ps.executeUpdate();
		}

	}

	@Override
	public void syncCarsDown() throws SQLException {
		Connection connection = cFS.getConnection();
		Statement statement = null;

		String query = "SELECT * FROM CARS";

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Car car = new Car();
				car.setSku(rs.getInt(1));
				car.setColor(rs.getString(2));
				car.setMake(rs.getString(3));
				car.setModel(rs.getString(4));
				car.setYear(rs.getInt(5));
				car.setMiles(rs.getInt(6));
				car.setPrice(rs.getDouble(7));
				FirstStructure.lotInventory.put(car.getSku(), car);
				FirstStructure.usedSKU.add(car.getSku());

			}
			System.out.println(FirstStructure.lotInventory);
			System.out.println(FirstStructure.usedSKU);

		} catch (SQLException e) {
			log.info(e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}

	}

	@Override
	public void syncUsersUp(HashMap<String, User> userDataBase, ArrayList<String> userDataBaseIndex)
			throws SQLException {

		Connection connection = cFS.getConnection();
		// PREPARED STATEMENT - INSERTING ONE CAR FROM MAP AT A TIME
		String sql1 = "TRUNCATE TABLE CARUSER";
		PreparedStatement ps1 = connection.prepareStatement(sql1);
		ps1.executeUpdate();
		System.out.println(userDataBase);
		System.out.println(userDataBaseIndex);

		for (int i = 0; i < userDataBaseIndex.size(); i++) {
			String sql2 = "INSERT INTO CARUSER VALUES(?,?,?,?,?)";
			System.out.println("Sending User:  " + userDataBase.get(userDataBaseIndex.get(i)).getUserName());
			PreparedStatement ps = connection.prepareStatement(sql2);
			ps.setString(1, userDataBase.get(userDataBaseIndex.get(i)).getUserName());
			ps.setString(2, userDataBase.get(userDataBaseIndex.get(i)).getPassword());
			ps.setString(3, userDataBase.get(userDataBaseIndex.get(i)).getFirstName());
			ps.setString(4, userDataBase.get(userDataBaseIndex.get(i)).getLastName());
			ps.setInt(5, userDataBase.get(userDataBaseIndex.get(i)).getAccessLevel());

			ps.executeUpdate();
		}
	}

	@Override
	public void syncUsersDown() throws SQLException {
		Connection connection = cFS.getConnection();
		Statement statement = null;

		String query = "SELECT * FROM CARUSER";

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setAccessLevel(rs.getInt(5));
				LocalUserData.userDataBase.put(user.getUserName(), user);
				LocalUserData.userDataBaseIndex.add(user.getUserName());

			}
		} catch (SQLException e) {
			log.info(e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}

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
