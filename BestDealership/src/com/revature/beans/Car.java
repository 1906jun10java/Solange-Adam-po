package com.revature.beans;

public class Car {
	
	private int sku = 100000;
	private String color = "White";
	private String make = "Make";
	private String model = "Model";
	private int miles = 0;
	private int year = 9999;
	private double price = 150000.00;
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int sku, String make,String model, String color, int miles, int year, double price) {
		super();
		this.sku = sku;
		this.color = color;
		this.miles = miles;
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
	
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		color = color;
	}
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	@Override
	public String toString() {
		return "Car [sku=" + sku + ", color=" + color + ", make=" + make + ", model=" + model + ", miles=" + miles
				+ ", year=" + year + ", price=" + price + "]";
	}


}
