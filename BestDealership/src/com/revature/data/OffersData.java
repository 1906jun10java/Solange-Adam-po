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
	public static HashMap<String, Offer> customerOffers = new HashMap<>();
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
		customerOffers.put(customer, offer);
		return true;
	}

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

	public static boolean showMyOffers(User currentUser) {
		if (customerOffers.get(currentUser.getUserName()) == null) {
			System.out.println("You currently do not have any offers pending");
		} else {
			try {
				//TODO iterate through map for if(offer.getCustomer.equals(currentUser.getUserName))
				System.out.println("\n " + customerOffers.get(currentUser.getUserName()) + "\n ");
			} catch (Exception e) {
				System.out.println("\nThere are curently no offers.  \n");
				log.info(e);
				return false;
			}
		}
		//TODO break this off into a stand-alone method
		try {
			System.out.println("Cars you own");
		} catch (Exception e) {
			System.out.println("\nYou currently do not own any cars");
			log.info(e);
			return false;
		}
		return true;
	}
}









