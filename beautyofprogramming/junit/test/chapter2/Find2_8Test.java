package test.chapter2;

import java.util.Random;

import org.junit.Test;

import chapter2.Find2_8;

public class Find2_8Test {

	private static  int N=100;
	private static int[] datas=new int[100];
	private static Random rand=new Random();
	static{
		for(int i=0;i<N;i++){
			datas[i]=1+Math.abs(rand.nextInt(100));
		}
	}
	/**
	 * too slow 98.736
	 */
//	@Test
//	public void find1Test(){
//		for(int i=0;i<N;i++){
//			Find2_8.find1(datas[i]);		
//		}
//	}
	/**
	 * unsupported
	 */
//	@Test
//	public void find2Test(){
//		for(int i=0;i<N;i++){
//			Find2_8.find2(datas[i]);		
//		}
//	}
	/**
	 * 0.568
	 */
	@Test
	public void find3Test(){
		for(int i=0;i<N;i++){
			Find2_8.find3(datas[i]);		
		}
	}
	/**
	 * 0.020
	 */
	@Test
	public void find4Test(){
		for(int i=0;i<N;i++){
			Find2_8.find4(datas[i]);		
		}
	}
	/**
	 * 0.017
	 */
	@Test
	public void find5Test(){
		for(int i=0;i<N;i++){
			Find2_8.find5(datas[i]);		
		}
	}
	
}
