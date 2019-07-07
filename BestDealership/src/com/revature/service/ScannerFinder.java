package com.revature.service;

import java.util.Scanner;

public class ScannerFinder {
	static ScannerFinder scannerRomeo = null;
	private static Scanner scannerActual = new Scanner(System.in);
	
	private ScannerFinder() {
		super();
	}
	public static ScannerFinder getScannerInstance() {
		//TODO Find out how to use scanner here
		if(scannerRomeo == null) {
			scannerRomeo = new ScannerFinder();
		}
		return scannerRomeo;
	}
	
	public Scanner runScanner() {
		return scannerActual;
	}
	

}
