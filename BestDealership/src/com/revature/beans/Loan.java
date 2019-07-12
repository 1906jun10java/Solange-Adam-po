package com.revature.beans;

public class Loan {
	private String signOffEmployee = "approvalEmployee";
	private int sku = 100000;
	private String owner = "CustomerUserName";
	private double balance = 100000.00;
	private double payment = 999.99;
	private int loanTerm = 96;
	private int paymentsMade = 0;
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(String signOffEmployee, int sku, String owner, double balance, double payment, int loanTerm,
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

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
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
//		return "this is a lone loan";
//	}
	
	public String toString() {
		return "Loan [signOffEmployee=" + signOffEmployee + ", sku=" + sku + ", owner=" + owner + ", balance=" + balance
				+ ", payment=" + payment + ", loanTerm=" + loanTerm + ", paymentsMade=" + paymentsMade + "]";
	}
	
	
}
