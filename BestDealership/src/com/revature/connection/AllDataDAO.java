package com.revature.connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.revature.beans.Car;

public interface AllDataDAO {
	
	public void syncCarsUp(HashMap<Integer, Car> lotInventory, ArrayList<Integer> usedSKU) throws SQLException;

	public void syncCarsDown(HashMap<Integer, Car> lotInventory, ArrayList<Integer> usedSKU) throws SQLException;
	
	//Users
	public void syncUsersUp() throws SQLException;
	
	public void syncUsersDown() throws SQLException;
	
	//Offers
	public void syncOffersUp() throws SQLException;
	
	public void syncOffersDown() throws SQLException;
	
	//Loans
	public void syncSoldUp() throws SQLException;
	
	public void syncSoldDown() throws SQLException;

}
