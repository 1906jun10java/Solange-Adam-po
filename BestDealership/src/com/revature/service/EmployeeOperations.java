package com.revature.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.data.FirstStructure;
import com.revature.data.OffersData;
import com.revature.data.SoldData;


public class EmployeeOperations {
	static ScannerFinder scannerRomeo = ScannerFinder.getScannerInstance();
	static Scanner scannerActual = scannerRomeo.runScanner();
	public static Logger log = Logger.getRootLogger();
	
	
	// vvvvvv View and accept offers vvvvvv
	// first call of this needs to be 0, 1
	public static void findCurrentOffers(int indexMover, int pageMover, User currentUser) {
		int currentIndex = 0 + indexMover;
		int indexLimit = 5 + indexMover;
		int offerMenuBreak = 0;
		int pageNumber = 0 + pageMover;
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Viewing current offers");
		System.out.println("Current number of cars in inventory is:  " + OffersData.offersByCustomer.size());
		System.out.println("Page " + pageNumber);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Please select the number of the offer you wish to accept:  \n");

		while (offerMenuBreak != 1) {
			// TODO Fix this statement
			OffersData.offersViewer(currentIndex, OffersData.offersByCustomer.size() - (currentIndex));
			System.out.println("6:  For The Next Page\n");
			System.out.println("7:  To Exit");
			String carMenu = scannerActual.next();
			currentOffersMenu(carMenu, currentIndex, pageNumber, currentUser);
			offerMenuBreak = 1;
		}
	}
	//TODO make SoldData Map and companion 
	public static int currentOffersMenu(String carMenu, int currentIndex, int pageNumber, User currentUser) {
		int menuChoice = 0;
		String possibleEntry = ("1,2,3,4,5,6,7");
		if (carMenu.length() > 1 || carMenu.charAt(0) != possibleEntry.charAt(0)
				& carMenu.charAt(0) != possibleEntry.charAt(2) & carMenu.charAt(0) != possibleEntry.charAt(4)
				& carMenu.charAt(0) != possibleEntry.charAt(6) & carMenu.charAt(0) != possibleEntry.charAt(8)
				& carMenu.charAt(0) != possibleEntry.charAt(10) & carMenu.charAt(0) != possibleEntry.charAt(12)) {
			System.out.println("Please enter 1 - 7");
			currentOffersMenu(scannerActual.next(), currentIndex, pageNumber, currentUser);
		} else {
			switch (carMenu) {
			case "1":
				System.out.println("Accepting:  " + OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 0)));
				SoldData.sellCar(currentUser, OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 0)));
				menuChoice = 1;
				break;
			case "2":
				try {
					System.out.println("Accepting:  " + OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 1)));
					SoldData.sellCar(currentUser, OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 1)));
				} catch (Exception e) {
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				menuChoice = 2;
				break;
			case "3":
				try {
					System.out.println("Accepting:  " + OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 2)));
					SoldData.sellCar(currentUser, OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 2)));
				} catch (Exception e) {
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "4":
				try {
					System.out.println("Accepting:  " + OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 3)));
					SoldData.sellCar(currentUser, OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 3)));
				} catch (Exception e) {
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "5":
				try {
					System.out.println("Accepting:  " + OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 4)));
					SoldData.sellCar(currentUser, OffersData.customerOffers.get(OffersData.offersByCustomer.get(currentIndex + 4)));
				} catch (Exception e) {
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "6":
				int indexMover = currentIndex + 5;
				int pageMover = pageNumber + 1;
				findInventory(indexMover, pageMover);
				menuChoice = 6;
				break;
			case "7":
				menuChoice = 7;
				break;
			}

		}
		return menuChoice;
	}

	public static boolean removeCarSelect(Integer sku) {
		System.out.println("Are you sure you wish to remove car:  "+ FirstStructure.lotInventory.get(sku) + "?"
				+ "\n Enter \"1\" to comfirm removal from the lot.  WARNING - This action is final"
				+ "\n Enter \"2\" to cancel removal.");
		String offerAmountInput = scannerActual.next();
		//USING .equals MAKES IT WAY BETTER THEN THE COMPLICATED STRING VERSION
		if (offerAmountInput.equals("1")) {
			FirstStructure.removeCar(sku);
			return true;
		}
		return false;
	}
	
	
	//vvvvvv View and remove Cars vvvvvv
	// first call of this needs to be 0, 1
	public static void findInventory(int indexMover, int pageMover) {
		int currentIndex = 0 + indexMover;
		int indexLimit = 5 + indexMover;
		int offerMenuBreak = 0;
		int pageNumber = 0 + pageMover;
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Viewing current inventory:");
		System.out.println("Current number of offers is:  " + FirstStructure.lotInventory.size());
		System.out.println("Page " + pageNumber);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Please select the number of the car you wish to remove:  \n");

		while (offerMenuBreak != 1) {
			// TODO Fix this statement
			FirstStructure.carViewer(currentIndex, FirstStructure.lotInventory.size() - (currentIndex));
			System.out.println("6:  For The Next Page\n");
			System.out.println("7:  To Exit");
			String carMenu = scannerActual.next();
			inventoryMenu(carMenu, currentIndex, pageNumber);
			offerMenuBreak = 1;
		}
	}
		
	public static int inventoryMenu(String carMenu, int currentIndex, int pageNumber) {
		int menuChoice = 0;
		String possibleEntry = ("1,2,3,4,5,6,7");
		if (carMenu.length() > 1 || carMenu.charAt(0) != possibleEntry.charAt(0)
				& carMenu.charAt(0) != possibleEntry.charAt(2) & carMenu.charAt(0) != possibleEntry.charAt(4)
				& carMenu.charAt(0) != possibleEntry.charAt(6) & carMenu.charAt(0) != possibleEntry.charAt(8)
				& carMenu.charAt(0) != possibleEntry.charAt(10) & carMenu.charAt(0) != possibleEntry.charAt(12)) {
			System.out.println("Please enter 1 - 7");
			inventoryMenu(scannerActual.next(), currentIndex, pageNumber);
		} else {
			switch (carMenu) {
			case "1":
				System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 0));
				removeCarSelect(FirstStructure.usedSKU.get(currentIndex + 0));
				menuChoice = 1;
				break;
			case "2":
				try {
					System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 1));
					removeCarSelect(FirstStructure.usedSKU.get(currentIndex + 1));
				} catch (Exception e) {
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				menuChoice = 2;
				break;
			case "3":
				try {
					System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 2));
					removeCarSelect(FirstStructure.usedSKU.get(currentIndex + 2));
				} catch (Exception e) {
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "4":
				try {
					System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 3));
					removeCarSelect(FirstStructure.usedSKU.get(currentIndex + 3));
				} catch (Exception e) {
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "5":
				try {
					System.out.println("Removing:  " + FirstStructure.usedSKU.get(currentIndex + 4));
					removeCarSelect(FirstStructure.usedSKU.get(currentIndex + 4));
				} catch (Exception e) {
					System.out.println("Unable to remove - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "6":
				int indexMover = currentIndex + 5;
				int pageMover = pageNumber + 1;
				findInventory(indexMover, pageMover);
				menuChoice = 6;
				break;
			case "7":
				menuChoice = 7;
				break;
			}

		}
		return menuChoice;
	}
	
	//!!!!!!!vvvvvvv Viewing Sold Cars and Payments vvvvvvv!!!!!!!
	
	public static void findCurrentSoldCars(int indexMover, int pageMover, User currentUser) {
		int currentIndex = 0 + indexMover;
		int indexLimit = 5 + indexMover;
		int offerMenuBreak = 0;
		int pageNumber = 0 + pageMover;
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Viewing Sold Cars");
		System.out.println("Current number of cars sold:  " + SoldData.soldCarsIndex.size());
		System.out.println("Page " + pageNumber);
		System.out.println("-------------------------------------------------------------------");
		System.out.println(" \n");

		while (offerMenuBreak != 1) {
			// TODO Fix this statement
			SoldData.loanViewer(currentIndex, SoldData.soldCarsIndex.size() - (currentIndex));
			System.out.println("6:  For The Next Page\n");
			System.out.println("7:  To Exit");
			String carMenu = scannerActual.next();
			currentSoldCars(carMenu, currentIndex, pageNumber, currentUser);
			offerMenuBreak = 1;
		}
	}
	
	
	public static int currentSoldCars(String carMenu, int currentIndex, int pageNumber, User currentUser) {
		int menuChoice = 0;
		String possibleEntry = ("1,2,3,4,5,6,7");
		if (carMenu.length() > 1 || carMenu.charAt(0) != possibleEntry.charAt(0)
				& carMenu.charAt(0) != possibleEntry.charAt(2) & carMenu.charAt(0) != possibleEntry.charAt(4)
				& carMenu.charAt(0) != possibleEntry.charAt(6) & carMenu.charAt(0) != possibleEntry.charAt(8)
				& carMenu.charAt(0) != possibleEntry.charAt(10) & carMenu.charAt(0) != possibleEntry.charAt(12)) {
			System.out.println("Please enter 1 - 7");
			currentSoldCars(scannerActual.next(), currentIndex, pageNumber, currentUser);
		} else {
			switch (carMenu) {
			case "1":
				System.out.println(SoldData.soldCars.get(SoldData.soldCarsIndex.get(currentIndex + 0)));

				menuChoice = 1;
				break;
			case "2":
				try {
					System.out.println(SoldData.soldCars.get(SoldData.soldCarsIndex.get(currentIndex + 0)));

				} catch (Exception e) {
					System.out.println("Unable to view - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				menuChoice = 2;
				break;
			case "3":
				try {
					System.out.println(SoldData.soldCars.get(SoldData.soldCarsIndex.get(currentIndex + 0)));

				} catch (Exception e) {
					System.out.println("Unable to view - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "4":
				try {
					System.out.println(SoldData.soldCars.get(SoldData.soldCarsIndex.get(currentIndex + 0)));

				} catch (Exception e) {
					System.out.println("Unable to view - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "5":
				try {
					System.out.println(SoldData.soldCars.get(SoldData.soldCarsIndex.get(currentIndex + 0)));

				} catch (Exception e) {
					System.out.println("Unable to view - ask your co-worker why to decrease productivity");
					log.info(e);
				}
				break;
			case "6":
				int indexMover = currentIndex + 5;
				int pageMover = pageNumber + 1;
				findInventory(indexMover, pageMover);
				menuChoice = 6;
				break;
			case "7":
				menuChoice = 7;
				break;
			}

		}
		return menuChoice;
	}
	
	
}
