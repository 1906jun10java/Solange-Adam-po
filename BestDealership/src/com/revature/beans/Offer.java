package com.revature.beans;

import com.revature.data.FirstStructure;

public class Offer {
	private int offerNumber = 0;
	private String customer = "CustomerUserNameHere";
	private int carSKU = 100000;
	private double askingPrice = 150000;
	private double offerMade= 0.0;
	
	public Offer(int offerNumber, String customer, int carSKU, double askingPrice, double offerMade) {
		super();
		this.offerNumber = offerNumber;
		this.customer = customer;
		this.carSKU = carSKU;
		this.askingPrice = askingPrice;
		this.offerMade = offerMade;
	}

	public int getOfferNumber() {
		return offerNumber;
	}

	public void setOfferNumber(int offerNumber) {
		this.offerNumber = offerNumber;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getCarSKU() {
		return carSKU;
	}

	public void setCarSKU(int carSKU) {
		this.carSKU = carSKU;
	}

	public double getAskingPrice() {
		return askingPrice;
	}

	public void setAskingPrice(int askingPrice) {
		this.askingPrice = askingPrice;
	}

	public double getOfferMade() {
		return offerMade;
	}

	public void setOfferMade(double offerMade) {
		this.offerMade = offerMade;
	}

	@Override
	public String toString() {
		return ("\nYou made an offer of " + offerMade + " for the: \n" 
				+ FirstStructure.lotInventory.get(carSKU) + "\n ");
		
//		return "Offer [offerNumber=" + offerNumber + ", customer=" + customer + ", carSKU=" + carSKU + ", askingPrice="
//				+ askingPrice + ", offerMade=" + offerMade + "]";
	}

}
