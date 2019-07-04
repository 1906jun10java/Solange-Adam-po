package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.revature.beans.Offer;
import com.revature.service.UserOperations;

public class OffersData {
	
	public static HashMap<Integer, Offer> currentOffers = new HashMap<>();
	public static ArrayList<Integer> currentOffersNumber = new ArrayList<>();
	
	public static int getCurrentOfferNumber() {
		Random randInt = new Random();
		int numberDecider = randInt.nextInt((60000 - 10000) + 1) + 10000;
		if (currentOffersNumber.contains(numberDecider)) {
			getCurrentOfferNumber();
		} 
		return numberDecider;
	}
	
	public static void createOffer(int sku) {
		int offerNumber = getCurrentOfferNumber();
		String customer = UserOperations.currentUserList.get(0);
		Double price = FirstStructure.lotInventory.get(sku).getPrice();
		Double offerAmount = 100000.00;
		Offer offer = new Offer(offerNumber, customer, sku, price, offerAmount);
		System.out.println("Your offer has been made:\n" + offer);
		currentOffersNumber.add(offerNumber);
		currentOffers.put(offerNumber, offer);
	}

}
