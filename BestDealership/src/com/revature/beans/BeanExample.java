package com.revature.beans;

public class BeanExample {
	public int x = 0;

	public BeanExample(int x) {
		super();
		this.x = x;
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
