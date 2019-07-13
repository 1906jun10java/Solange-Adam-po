package com.revature.beans;

public class Loan {
	private int loanNumber = 9999;
	private String signOffEmployee = "approvalEmployee";
	private int sku = 100000;
	private String owner = "CustomerUserName";
	private double balance = 100000.00;
	private double payment = 999.99;
	private double loanTerm = 96.0;
	private int paymentsMade = 0;
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(int loanNubmer, String signOffEmployee, int sku, String owner, double balance, double payment, double loanTerm,
			int paymentsMade) {
		super();
		this.signOffEmployee = signOffEmployee;
		this.sku = sku;
		this.owner = owner;
		this.balance = balance;
		this.payment = payment;
		this.loanTerm = loanTerm;
		this.paymentsMade = paymentsMade;
	}

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getSignOffEmployee() {
		return signOffEmployee;
	}

	public void setSignOffEmployee(String signOffEmployee) {
		this.signOffEmployee = signOffEmployee;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(double loanTerm) {
		this.loanTerm = loanTerm;
	}

	public int getPaymentsMade() {
		return paymentsMade;
	}

	public void setPaymentsMade(int paymentsMade) {
		this.paymentsMade = paymentsMade;
	}

	@Override
//	public String toString() {
//		return "Loan [loanNumber=" + loanNumber + ", signOffEmployee=" + signOffEmployee + ", sku=" + sku + ", owner="
//				+ owner + ", balance=" + balance + ", payment=" + payment + ", loanTerm=" + loanTerm + ", paymentsMade="
//				+ paymentsMade + "]";
//	}

	public String toString() {
		return "Loan: " + loanNumber + " | For Car: " + sku + " has a balance of: $" + balance + " and $" + payment + " monthly payment."
				+ "\n---Number of payments made is: " + paymentsMade + " of " + loanTerm;
	}


	
	
}
