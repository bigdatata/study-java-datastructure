package test.chapter2;

import org.junit.Test;

import chapter2.Count2_4;

public class Count2_4Test {

	private int bigNumber=100000000;
	
	/**
	 * 12.436s
	 */
	@Test
	public void countOneFromOneToAIntegerTest(){
		Count2_4.countOneFromOneToAInteger(bigNumber);
	}
	/**
	 * 0.001s
	 */
	@Test
	public void countOneFromOneToAInteger2Test(){
		Count2_4.countOneFromOneToAInteger2(bigNumber);
	}
}
