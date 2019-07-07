package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.revature.beans.Offer;
import com.revature.service.UserMenu;

public class OffersData {
	//All offers by customer
	public static HashMap<String, ArrayList<Offer>> customerOffers = new HashMap<>();
	//All offer objects
	public static ArrayList<Offer> offersByCustomer = new ArrayList<>();
	//ArrayList for indexing and unique ID creation
	public static ArrayList<Integer> currentOffersNumber = new ArrayList<>();
	
	public static int getCurrentOfferNumber() {
		Random randInt = new Random();
		int numberDecider = randInt.nextInt((60000 - 10000) + 1) + 10000;
		if (currentOffersNumber.contains(numberDecider)) {
			getCurrentOfferNumber();
		} 
		return numberDecider;
	}
	
	public static boolean createOffer(int sku, double offerAmount) {
		if (offerAmount == 0.0) {
			System.out.println("Offer not made");
			return false;
		}
		int offerNumber = getCurrentOfferNumber();
		String customer = UserMenu.currentUserList.get(0);
		Double price = FirstStructure.lotInventory.get(sku).getPrice();
		Offer offer = new Offer(offerNumber, customer, sku, price, offerAmount);
		System.out.println("Your offer has been made:\n" + offer);
		currentOffersNumber.add(offerNumber);
		offersByCustomer.add(offer);
		customerOffers.put(customer, offersByCustomer);
		return true;
	}
	
	public static boolean showOffers() {
		System.out.println("\n " + customerOffers.get(UserMenu.currentUserList.get(0)) + "\n ");
		return true;
	}

}
