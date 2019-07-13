package com.revature.connection;

import java.sql.SQLException;

public interface AllDataDAO {
	
	public void syncCars() throws SQLException;
	
	public void syncUsers() throws SQLException;
	
	public void syncOffers() throws SQLException;
	
	public void syncSold() throws SQLException;

}
