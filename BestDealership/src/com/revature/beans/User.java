package com.revature.beans;

public class User {
	//Menus and fields will determine the difference between employees.  
	//UserCustomer and UserEmploye children classes are not needed.
	private String user = "TestName";
	private String password = "TestPassword";
	private String firstName = "Card";
	private String lastName = "Holder";
	private int accessLevel = 0;
	
	//Constructors
	public User() {
		super();

	}

	public User(String userName, String password, String firstName, String lastName, int accessLevel) {
		super();
		this.user = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accessLevel = accessLevel;
	}

	//Getters and Setters
	public String getUserName() {
		return user;
	}
	public void setUserName(String userName) {
		this.user = userName;
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

	@Override
	public String toString() {
		return "User [userName=" + user + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", accessLevel=" + accessLevel + "]\n";
	}
	
}
