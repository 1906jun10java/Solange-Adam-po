package com.revature.connection;

import java.sql.CallableStatement;
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
import com.revature.beans.Loan;
import com.revature.beans.Offer;
import com.revature.beans.User;
import com.revature.data.FirstStructure;
import com.revature.data.LocalUserData;
import com.revature.data.OffersData;
import com.revature.data.SoldData;
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
	public void syncOffersUp(HashMap<Integer, Offer> customerOffers, ArrayList<Integer> offersByCustomer)
			throws SQLException {
		Connection connection = cFS.getConnection();
		// PREPARED STATEMENT - INSERTING ONE CAR FROM MAP AT A TIME
		String sql1 = "TRUNCATE TABLE OFFERS";
		PreparedStatement ps1 = connection.prepareStatement(sql1);
		ps1.executeUpdate();

		for (int i = 0; i < offersByCustomer.size(); i++) {
			String sql2 = "INSERT INTO OFFERS VALUES(?,?,?,?,?)";
			System.out.println("Sending Offer:  " + customerOffers.get(offersByCustomer.get(i)).getOfferNumber());
			PreparedStatement ps = connection.prepareStatement(sql2);
			ps.setInt(1, customerOffers.get(offersByCustomer.get(i)).getOfferNumber());
			ps.setString(2, customerOffers.get(offersByCustomer.get(i)).getCustomer());
			ps.setInt(3, customerOffers.get(offersByCustomer.get(i)).getCarSKU());
			ps.setDouble(4, customerOffers.get(offersByCustomer.get(i)).getAskingPrice());
			ps.setDouble(5, customerOffers.get(offersByCustomer.get(i)).getOfferMade());

			ps.executeUpdate();
		}
	}

	@Override
	public void syncOffersDown() throws SQLException {
		Connection connection = cFS.getConnection();
		Statement statement = null;

		String query = "SELECT * FROM OFFERS";

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Offer offer = new Offer();
				offer.setOfferNumber(rs.getInt(1));
				offer.setCustomer(rs.getString(2));
				offer.setCarSKU(rs.getInt(3));
				offer.setAskingPrice(rs.getDouble(4));
				offer.setOfferMade(rs.getDouble(5));
				OffersData.customerOffers.put(offer.getOfferNumber(), offer);
				OffersData.offersByCustomer.add(offer.getOfferNumber());
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
	public void syncSoldUp(HashMap<Integer, Loan> soldCars, ArrayList<Integer> soldCarsIndex) throws SQLException {
		Connection connection = cFS.getConnection();
		// PREPARED STATEMENT - INSERTING ONE CAR FROM MAP AT A TIME
		String sql1 = "TRUNCATE TABLE LOAN";
		PreparedStatement ps1 = connection.prepareStatement(sql1);
		ps1.executeUpdate();

		for (int i = 0; i < soldCarsIndex.size(); i++) {
			String sql2 = "INSERT INTO LOAN VALUES(?,?,?,?,?,?,?,?)";
			System.out.println("Sending LOAN:  " + soldCars.get(soldCarsIndex.get(i)).getLoanNumber());
			PreparedStatement ps = connection.prepareStatement(sql2);
			ps.setInt(1, soldCars.get(soldCarsIndex.get(i)).getLoanNumber());
			ps.setString(2, soldCars.get(soldCarsIndex.get(i)).getSignOffEmployee());
			ps.setInt(3, soldCars.get(soldCarsIndex.get(i)).getSku());
			ps.setString(4, soldCars.get(soldCarsIndex.get(i)).getOwner());
			ps.setDouble(5, soldCars.get(soldCarsIndex.get(i)).getBalance());
			ps.setDouble(6, soldCars.get(soldCarsIndex.get(i)).getPayment());
			ps.setDouble(7, soldCars.get(soldCarsIndex.get(i)).getLoanTerm());
			ps.setInt(8, soldCars.get(soldCarsIndex.get(i)).getPaymentsMade());
			ps.executeUpdate();
		}

	}

	@Override
	public void syncSoldDown() throws SQLException {
		Connection connection = cFS.getConnection();
		Statement statement = null;

		String query = "SELECT * FROM LOAN";

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Loan loan = new Loan();
				loan.setLoanNumber(rs.getInt(1));
				loan.setSignOffEmployee(rs.getString(2));
				loan.setSku(rs.getInt(3));
				loan.setOwner(rs.getString(4));
				loan.setBalance(rs.getDouble(5));
				loan.setPayment(rs.getDouble(6));
				loan.setLoanTerm(rs.getDouble(7));
				loan.setPaymentsMade(rs.getInt(8));
				SoldData.soldCars.put(loan.getLoanNumber(), loan);
				SoldData.soldCarsIndex.add(loan.getLoanNumber());
			}
		} catch (SQLException e) {
			log.info(e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

	public void findPayments(String owner) {
		Connection connection = cFS.getConnection();

		String sql = "CALL GET_PAYMENTS_TWO(?)";
		try {
			CallableStatement cs = connection.prepareCall(sql);
			
			cs.setString(1, owner);
			ResultSet rs = cs.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				int payments = rs.getInt("LOAN_PAYMENTS_MADE");
				System.out.println(payments);
			}

		} catch (SQLException e) {
			log.info(e);
		}

	}

}
