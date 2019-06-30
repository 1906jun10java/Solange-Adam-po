package com.revature.service;

import java.util.Scanner;

public class ScannerFinder {
	static ScannerFinder sf = null;
	private static Scanner sc = new Scanner(System.in);
	
	private ScannerFinder() {
		super();
	}
	public static ScannerFinder getSFDouble() {
		//TODO Find out how to use scanner here
		if(sf == null) {
			sf = new ScannerFinder();
		}
		return sf;
	}
	
	public Scanner runScanner() {
		return sc;
	}
	

}
