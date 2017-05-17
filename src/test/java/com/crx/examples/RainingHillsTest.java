package com.crx.examples;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.crx.examples.service.RainingHillsService;
import com.crx.examples.service.RainingHillsServiceImpl;

/**
 * 
 * @author mina.nashed RainingHillsTest JUnit Test Class for run test cases to
 *         test the calculation of units of raining hills
 *
 */
public class RainingHillsTest {

	Integer[] firstTest;
	Integer[] secondTest;
	Integer[] thirdTest;
	Integer[] fourthTest;
	Integer[] fifthTest;
	Integer[] sixthTest;
	Integer[] seventhTest;

	private RainingHillsService serviceImpl;

	/**
	 * <p>
	 * load all test cases before run test cases and initiate object of
	 * RainingHillsServiceImpl class to call calculate method
	 * </p>
	 * 
	 * @return void
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		serviceImpl = new RainingHillsServiceImpl();

		firstTest = new Integer[] { 3, 2, 4, 1, 2 };
		// test Empty
		secondTest = new Integer[] {};

		thirdTest = new Integer[] { 4, 1, 1, 0, 2, 3 };

		fourthTest = new Integer[] { 4, 1, 1, 0, 2, 3, 1, 2, 3, 3, 3 };
		// test null
		fifthTest = null;
		// test single value
		sixthTest = new Integer[] { 4 };

		seventhTest = new Integer[] { 4, 2 };

	}

	/**
	 * Run All test Cases
	 * 
	 */
	@Test
	public void Test() {

		// first case
		int expect = serviceImpl.calculate(firstTest);
		assertTrue("first test case expected 2", expect == 2);
		// second case
		expect = serviceImpl.calculate(secondTest);
		assertTrue("second test case expected 0", expect == 0);

		// third case
		expect = serviceImpl.calculate(thirdTest);
		assertTrue("third test case expected 0", expect == 8);

		// fourth case
		expect = serviceImpl.calculate(fourthTest);
		assertTrue("fourth test case expected 0", expect == 11);

		// fifth case
		expect = serviceImpl.calculate(fifthTest);
		assertTrue("fifth test case expected 0", expect == 0);

	}

}
