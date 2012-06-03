package chapter10;

import org.junit.Test;

import analysis.in.java.chapter10.DynamicProgramming;

public class DynamicProgrammingTest {

	@Test
	public void eval3(){
		System.out.println(DynamicProgramming.eval3(20));
	}
	@Test
	public void eval2(){
		System.out.println(DynamicProgramming.eval2(20));
	}
	@Test
	public void eval(){
		System.out.println(DynamicProgramming.eval(20));
	}
	@Test
	public void optSearchTree(){
		String[] words={"a","am","and","egg","if","the","two"};
		double[] weights={0.22,0.18,0.20,0.05,0.25,0.02,0.08};
		double[][] m=new double[words.length][words.length];
		int[][] lastChange=new int[words.length][words.length];
		DynamicProgramming.optSearchTree(words, weights, m, lastChange);
		System.out.println(m[0][words.length-1]);
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words.length;j++){
				System.out.format("%f ",m[i][j]);
			}
			System.out.println();
		}
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words.length;j++){
				System.out.format("%d ",lastChange[i][j]);
			}
			System.out.println();
		}
	}
}
