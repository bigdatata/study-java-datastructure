package test.chapter2;

import java.util.Random;

import org.junit.Test;

import chapter2.GreatestCommonDivisor2_7;

public class GreatestCommonDivisor2_7Test {

	private static int N=1000000;
	private static int[] dataX=new int[N];
	private static int[] dataY=new int[N];
	private static Random rand=new Random();
	static{
		for(int i=0;i<N;i++){
			dataX[i]=Math.abs(rand.nextInt());
			dataY[i]=Math.abs(rand.nextInt());
		}
	}
	/**
	 * 0.173
	 */
	@Test
	public void gcd1Test(){
		for(int i=0;i<N;i++){
			GreatestCommonDivisor2_7.gcd1(dataX[i],dataY[i]);
		}
	}
	/**
	 * 0.170
	 */
	@Test
	public void gcd2Test(){
		for(int i=0;i<N;i++){
			GreatestCommonDivisor2_7.gcd2(dataX[i],dataY[i]);
		}
	}
	/**
	 * stackoverflow
	 */
//	@Test
//	public void gcd3Test(){
//		for(int i=0;i<N;i++){
//			GreatestCommonDivisor2_7.gcd3(dataX[i],dataY[i]);
//		}
//	}
	/**
	 * 0.360
	 */
	@Test
	public void gcd4Test(){
		for(int i=0;i<N;i++){
			GreatestCommonDivisor2_7.gcd4(dataX[i],dataY[i]);
		}
	}
	/**
	 * 0.688
	 */
	@Test
	public void gcd5Test(){
		for(int i=0;i<N;i++){
			GreatestCommonDivisor2_7.gcd5(dataX[i],dataY[i]);
		}
	}
}
