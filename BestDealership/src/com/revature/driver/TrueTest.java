package com.revature.driver;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.service.ProgramOperations;


public class TrueTest {

	@Test
	public void programOperationsTest() {
		ProgramOperations testOP = new ProgramOperations();
		boolean actualResult = testOP.startProgram();
		//value expected is 'true'
		assertEquals(true, actualResult);

	}

}
