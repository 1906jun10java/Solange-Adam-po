package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.revature.beans.Car;

public class FirstStructure {

	// TODO create a data structure to hold users
	// TODO create a data structure to hold offers
	public static HashMap<Integer, Car> lotInventory = new HashMap<>();
	public static ArrayList<Integer> usedSKU = new ArrayList<Integer>();

	public static void buildTestLot(int loudOn) {
		Random randInt = new Random();
		int skuDecider = randInt.nextInt((600000 - 100000) + 1) + 100000;
		if (usedSKU.contains(skuDecider)) {
			buildTestLot(loudOn);
		} else {
			usedSKU.add(skuDecider);
			lotInventory.put(skuDecider, carBuilder(skuDecider, loudOn));
		}
	}

	public static Car carBuilder(int sku, int loudOn) {
		String make = randomMake();
		String model = randomModel(make);
		String color = randomColor();
		int miles = randomMiles();
		int year = randomYear();
		int randomPriceAdjuster = miles;
		// casting int to double
		double priceAdjuster = (double) randomPriceAdjuster;
		double price = (89999.99 - priceAdjuster);
		Car nextCar = new Car(sku, make, model, color, miles, year, price);
		if (loudOn == 1) {
			System.out.println("Adding to Lot Car:  \n" + nextCar);
		}
		return nextCar;
	}

	private static int randomYear() {
		Random randInt = new Random();
		int yearDecider = randInt.nextInt((1959 - 1955) + 1) + 1955;
		return yearDecider;
	}

	private static int randomMiles() {
		Random randInt = new Random();
		int milesDecider = randInt.nextInt((25000 - 500) + 1) + 500;
		return milesDecider;
	}

	private static String randomColor() {
		Random randInt = new Random();
		int colorDecider = randInt.nextInt(6) + 1;
		String nextColor = "nextColor";
		switch (colorDecider) {
		case 1:
			nextColor = "Teal";
			break;
		case 2:
			nextColor = "Seafoam Green";
			break;
		case 3:
			nextColor = "Indigo";
			break;
		case 4:
			nextColor = "Coral";
			break;
		case 5:
			nextColor = "Salmon";
			break;
		case 6:
			nextColor = "Magnolia";
			break;
		}
		return nextColor;
	}

	private static String randomModel(String nextMake) {
		Random randInt = new Random();
		int modelDecider = randInt.nextInt(3) + 1;
		String nextModel = "nextModel";
		switch (nextMake) {
		case "Dodge":
			switch (modelDecider) {
			case 1:
				nextModel = "Royal Lancer";
				break;
			case 2:
				nextModel = "Coronet";
				break;
			case 3:
				nextModel = "C-Series Truck";
				break;
			}
			break;
		case "Chrysler":
			switch (modelDecider) {
			case 1:
				nextModel = "300";
				break;
			case 2:
				nextModel = "Imperial";
				break;
			case 3:
				nextModel = "New Yorker";
				break;
			}
			break;
		case "DeSoto":
			switch (modelDecider) {
			case 1:
				nextModel = "FireDome";
				break;
			case 2:
				nextModel = "Adventurer";
				break;
			case 3:
				nextModel = "FireFlite";
				break;
			}
			break;
		}
		return nextModel;
	}

	public static String randomMake() {
		Random randInt = new Random();
		int makeDecider = randInt.nextInt(3) + 1;
		String nextMake = "nextMake";
		switch (makeDecider) {
		case 1:
			nextMake = "Dodge";
			break;
		case 2:
			nextMake = "Chrysler";
			break;
		case 3:
			nextMake = "DeSoto";
			break;
		}
		return nextMake;
	}

	public static void lotInventoryPrint() {
		System.out.println(lotInventory);
	}

	public static int carViewer(int skuIndex, int carsRemaining) {
		int menuNumber = 1;
		if (carsRemaining > 5) {
			int menuLimit = skuIndex + 5;
			while (skuIndex < menuLimit) {
				System.out.println((menuNumber) + ":  " + lotInventory.get(usedSKU.get(skuIndex)));
				menuNumber = menuNumber + 1;
				skuIndex = skuIndex + 1;
			}
		} else if (carsRemaining == 0) {
			System.out.println("All cars searched, returning to Main Menu");
		} else {
			int menuLimit = skuIndex + carsRemaining;
			while (skuIndex < menuLimit) {

				System.out.println((menuNumber) + ":  " + lotInventory.get(usedSKU.get(skuIndex)));
				menuNumber = menuNumber + 1;
				skuIndex = skuIndex + 1;
			}
		}
		return skuIndex;
	}
}
