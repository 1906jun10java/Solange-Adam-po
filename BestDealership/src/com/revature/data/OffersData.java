package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.apache.log4j.Logger;

import com.revature.beans.Offer;
import com.revature.beans.User;
import com.revature.service.UserMenu;

public class OffersData {
	public static Logger log = Logger.getRootLogger();
	// All offers by customer
	public static HashMap<Integer, Offer> customerOffers = new HashMap<>();
	// All offer objects
	public static ArrayList<Integer> offersByCustomer = new ArrayList<>();
	// ArrayList for indexing and unique ID creation
//	public static ArrayList<Integer> currentOffersNumber = new ArrayList<>();

	public static int getCurrentOfferNumber() {
		Random randInt = new Random();
		int numberDecider = randInt.nextInt((60000 - 10000) + 1) + 10000;
		if (offersByCustomer.contains(numberDecider)) {
			getCurrentOfferNumber();
		}
		return numberDecider;
	}

	public static boolean createOffer(int sku, double offerAmount, User currentUser) {
		if (offerAmount == 0.0) {
			System.out.println("Offer not made");
			return false;
		}
		int offerNumber = getCurrentOfferNumber();
//		String customer = UserMenu.currentUserList.get(currentUser);
		String customer = currentUser.getUserName();
		Double price = FirstStructure.lotInventory.get(sku).getPrice();
		Offer offer = new Offer(offerNumber, customer, sku, price, offerAmount);
		System.out.println("Your offer has been made:\n" + offer);
		offersByCustomer.add(offerNumber);
		customerOffers.put(offerNumber, offer);
		return true;
	}
	//Currently un-used and only for testing
	public static boolean showOffers() {
		try {
			//TODO Build a similar menu to the inventory screen
			System.out.println("\n " + customerOffers + "\n ");
			return true;
		} catch (Exception e) {
			System.out.println("\nThere are curently no offers.  \n");
			log.info(e);
			return false;
		}
	}

	public static void showMyOffers(User currentUser) {
		System.out.println("\nFinding your offers:\n");
		for(int i = 0; i < offersByCustomer.size(); i++) {
//			if(map value  == .equals(currentUser.getUserName()))
			if(customerOffers.get(offersByCustomer.get(i)).getCustomer().equals(currentUser.getUserName())) {
				System.out.println(customerOffers.get(offersByCustomer.get(i)));	
			}
		}
	}
	
	//TODO Move this to an OwnedData
	public static void showMyCars(User currentUser) {
		System.out.println("\nFinding your offers:\n");
		for(int i = 0; i < offersByCustomer.size(); i++) {
//			if(map value  == .equals(currentUser.getUserName()))
			if(customerOffers.get(offersByCustomer.get(i)).getCustomer().equals(currentUser.getUserName())) {
				System.out.println(customerOffers.get(offersByCustomer.get(i)));	
			}
		}
	}

	public static int offersViewer(int skuIndex, int offersRemaining) {
		int menuNumber = 1;
		if (offersRemaining > 5) {
			int menuLimit = skuIndex + 5;
			while (skuIndex < menuLimit) {
				System.out.println((menuNumber) + ":  " + customerOffers.get(offersByCustomer.get(skuIndex)));
				menuNumber = menuNumber + 1;
				skuIndex = skuIndex + 1;
			}
		} else if (offersRemaining == 0) {
			System.out.println("All offers searched, returning to Main Menu");
		} else {
			int menuLimit = skuIndex + offersRemaining;
			while (skuIndex < menuLimit) {
				System.out.println((menuNumber) + ":  " + customerOffers.get(offersByCustomer.get(skuIndex)));
				menuNumber = menuNumber + 1;
				skuIndex = skuIndex + 1;
			}
		}
		return skuIndex;
	}

	public static void removeOffer() {
		//this is stuff for removing an offer
	}


}









