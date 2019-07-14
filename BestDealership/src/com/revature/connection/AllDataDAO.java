package com.revature.connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.revature.beans.Car;
import com.revature.beans.User;

public interface AllDataDAO {
	
	public void syncCarsUp(HashMap<Integer, Car> lotInventory, ArrayList<Integer> usedSKU) throws SQLException;

	public void syncCarsDown() throws SQLException;
	
	//Users
	public void syncUsersUp(HashMap<String, User> userDataBase, ArrayList<String> userDataBaseIndex) throws SQLException;
	
	public void syncUsersDown() throws SQLException;
	
	//Offers
	public void syncOffersUp() throws SQLException;
	
	public void syncOffersDown() throws SQLException;
	
	//Loans
	public void syncSoldUp() throws SQLException;
	
	public void syncSoldDown() throws SQLException;

}
