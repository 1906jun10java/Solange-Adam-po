package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.revature.beans.Car;

public class FirstStructure {

	// TODO create a data structure to hold users
	// TODO create a data structure to hold offers
	static HashMap<Integer, Car> lotInventory = new HashMap<>();


	public static void buildTestLot() {
		Random randInt = new Random();
		int skuDecider = randInt.nextInt((600000 - 100000) + 1) + 100000;
		if (lotInventory.containsKey(skuDecider)) {
			buildTestLot();
		} else {
			lotInventory.put(skuDecider, carBuilder(skuDecider));
		}
	}

	public static Car carBuilder(int sku) {
		String make = randomMake();
		String model = randomModel(make);
		String color = randomColor();
		int miles = randomMiles();
		int year = randomYear();
		double price = 150000.00 - miles + year;

		Car nextCar = new Car(sku, make, model, color, miles, year, price);
		System.out.println("Adding to Lot Car:  " + nextCar);
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

}
