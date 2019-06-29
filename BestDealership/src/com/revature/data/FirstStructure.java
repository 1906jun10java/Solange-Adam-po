package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.revature.beans.Car;

public class FirstStructure {
	int K = 1002;
	
	//TODO create a data structure to hold cars
	//TODO create a data structure to hold users
	//TODO create a data structure to hold offers
	static HashMap<Integer, Car> lotInventory = new HashMap<>();
	static ArrayList<String> carMakes = new ArrayList<>();

	
	public static void buildTestLot() {
		Random randInt = new Random();
		int skuDecider = randInt.nextInt((600000-100000) + 1) + 100000;
		if (lotInventory.containsKey(skuDecider)) {
			buildTestLot();
		} else {
			lotInventory.put(skuDecider, carBuilder(skuDecider));
		}
	}
	
	public static Car carBuilder(int sku) {
		String make = randomMake();
		String model = randomModel();
		String color = randomColor();
		int miles = randomMiles();
		int year = randomYear();
		double price = 150000.00 - miles + year;
		
		Car nextCar = new Car(sku, make, model, color, miles, year, price);
		return nextCar;
	}
	
	private static int randomYear() {
		Random randInt = new Random();
		int yearDecider = randInt.nextInt((1960-1953) + 1) + 1953;
		return yearDecider;
	}

	private static int randomMiles() {
		Random randInt = new Random();
		int milesDecider = randInt.nextInt((1960-3000) + 1) + 1953;
		return milesDecider;
	}

	private static String randomColor() {
		// TODO Auto-generated method stub
		return null;
	}

	private static String randomModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String randomMake() {
		carMakes.add("Chrysler");
		carMakes.add("Dodge");
		carMakes.add("DeSoto");
		Random randInt = new Random();
		int makeDecider = randInt.nextInt(4) - 1;
		return "Dodge for now";
	}

}
