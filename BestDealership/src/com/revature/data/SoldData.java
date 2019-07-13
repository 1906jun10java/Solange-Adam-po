package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Loan;
import com.revature.beans.Offer;
import com.revature.beans.User;
import com.revature.service.ScannerFinder;

public class SoldData {
	ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	Scanner scannerActual = scannerRomeo.runScanner();
	public static Logger log = Logger.getRootLogger();
	public static HashMap<Integer, Offer> soldCars = new HashMap<>();
	// All offer objects
	public static ArrayList<Integer> soldCarsIndex = new ArrayList<>();
	
	public static void loanOperations(Loan loan) {
		
		//TODO add lone id to Array
		//TODO add loan to Map(id, loan)
		//TODO remove offer from offer map/array
		//TODO remove car from lot
	}
	
	public static Loan loanBuilder(User currentUser, Offer acceptedOffer) {
		Loan loan = new Loan();
		loan.setSignOffEmployee(currentUser.getUserName());
		loan.setSku(acceptedOffer.getCarSKU());
		loan.setOwner(acceptedOffer.getCustomer());
		loan.setBalance(acceptedOffer.getOfferMade());
		double loanTerm = 60;
		double r = 0.04;
		double loanPayment = ( (r * loan.getBalance()) / (1-(Math.pow((1+r), loanTerm))));
		loan.setPayment(loanPayment);
		loan.setLoanTerm(loanTerm);
		
		return loan;
	}
	
	
	
	
}
