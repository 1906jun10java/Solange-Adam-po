package com.revature.beans;

public class BeanExample {
	private int x = 0;
     
	private int y = 5;
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BeanExample(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "BeanExample [x=" + x + "]";
	}
	
	
}
