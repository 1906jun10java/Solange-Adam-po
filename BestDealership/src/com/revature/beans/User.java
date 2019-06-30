package com.revature.beans;

public class User {
	//Menus and fields will determine the difference between employees.  
	//UserCustomer and UserEmploye children classes are not needed.
	private String userName = "TestName";
	private String password = "TestPassword";
	private String firstName = "Card";
	private String lastName = "Holder";
	private int accessLevel = 2;
	private int offersMade = 0;
	
	//Constructors
	public User() {
		super();

	}

	public User(String userName, String password, String firstName, String lastName, int accessLevel, int offersMade) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accessLevel = accessLevel;
		this.offersMade = offersMade;
	}

	//Getters and Setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	public int getOffersMade() {
		return offersMade;
	}
	public void setOffersMade(int offersMade) {
		this.offersMade = offersMade;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", accessLevel=" + accessLevel + ", offersMade=" + offersMade + "]\n";
	}
	
}
