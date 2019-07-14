package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Loan;
import com.revature.beans.Offer;
import com.revature.beans.User;
import com.revature.service.ScannerFinder;

public class SoldData {
	static ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	static Scanner scannerActual = scannerRomeo.runScanner();
	public static Logger log = Logger.getRootLogger();
	public static HashMap<Integer, Loan> soldCars = new HashMap<>();
	// All offer objects
	public static ArrayList<Integer> soldCarsIndex = new ArrayList<>();
		
	public static void sellCar(User currentUser, Offer acceptedOffer) {
		Loan aLoan = loanBuilder(currentUser, acceptedOffer);
		//adding lone to local database
		soldCarsIndex.add(aLoan.getLoanNumber());
		soldCars.put(aLoan.getLoanNumber(), aLoan);
		//removing car from lot and rejecting all other offers
		FirstStructure.removeCar(aLoan.getSku());
	}
	
	public static Loan loanBuilder(User currentUser, Offer acceptedOffer) {
		Loan loan = new Loan();
		int loanNumber = loanNumber();
		loan.setLoanNumber(loanNumber);
		loan.setSignOffEmployee(currentUser.getUserName());
		loan.setSku(acceptedOffer.getCarSKU());
		loan.setOwner(acceptedOffer.getCustomer());
		loan.setBalance(acceptedOffer.getOfferMade());
		double loanTerm = 60;
		double r = 0.04;
		double loanPayment = (((r/12) * loan.getBalance()) / (1 - Math.pow(1 + (r/12) ,(-1 * loanTerm))));
		loan.setPayment(loanPayment);
		loan.setLoanTerm(loanTerm);
		
		return loan;
	}
	
	public static int loanNumber() {
	Random randInt = new Random();
		int loanNumberDecider = randInt.nextInt((99999 - 10000) + 1) + 10000;
		if (soldCarsIndex.contains(loanNumberDecider)) {
			loanNumber();
		} 
		return loanNumberDecider;
	}
	
	public static int loanViewer(int skuIndex, int loansRemaining) {
		int menuNumber = 1;
		if (loansRemaining > 5) {
			int menuLimit = skuIndex + 5;
			while (skuIndex < menuLimit) {
				System.out.println((menuNumber) + ":  " + soldCars.get(soldCarsIndex.get(skuIndex)));
				menuNumber = menuNumber + 1;
				skuIndex = skuIndex + 1;
			}
		} else if (loansRemaining == 0) {
			System.out.println("All offers searched, returning to Main Menu");
		} else {
			int menuLimit = skuIndex + loansRemaining;
			while (skuIndex < menuLimit) {
				System.out.println((menuNumber) + ":  " + soldCars.get(soldCarsIndex.get(skuIndex)));
				menuNumber = menuNumber + 1;
				skuIndex = skuIndex + 1;
			}
		}
		return skuIndex;
	}
	
	public static boolean makePayment(User currentUser, Loan loan) {
		System.out.println("Making payement for: " + currentUser + "\nLoan: " + loan);
		loan.setBalance(loan.getBalance() - loan.getPayment());
		loan.setPaymentsMade(loan.getPaymentsMade() + 1);
		System.out.println("\n\nCurrent loan information:" + loan);
		log.info("Payment made for loan: " + loan + " "
				+ "\n        by customer:" + currentUser);
		return true;
	}
	
}
