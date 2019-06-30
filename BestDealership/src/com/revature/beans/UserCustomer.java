package com.revature.beans;

public class UserCustomer extends User {
	private final int accessLevel = 1;
	private int offersMade = 0;
	
	//Additional information that may or may not be used/implemented
	private double income = 0;
	private int creditScore = 0;
	
	//A no argument Constructor  (No-Args Constructor)
	public UserCustomer() {
		super();
	}
		
	//Constructor using fields
	public UserCustomer(int offersMade, double income, int creditScore) {
		super();
		this.offersMade = offersMade;
		this.income = income;
		this.creditScore = creditScore;
		
		
	}
	
	//Getters and Setters
	public int getOffersMade() {
		return offersMade;
	}
	public void setOffersMade(int offersMade) {
		this.offersMade = offersMade;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public int getAccessLevel() {
		return accessLevel;
	}


	
	//toString method overide
	@Override
	public String toString() {
		return "UserCustomer [accessLevel=" + accessLevel + ", offersMade=" + offersMade + ", income=" + income
				+ ", creditScore=" + creditScore + "]";
	}

	
	
}


