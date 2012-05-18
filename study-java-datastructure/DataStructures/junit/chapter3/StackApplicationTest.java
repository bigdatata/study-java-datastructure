package chapter3;

import org.junit.Test;

import analysis.in.java.chapter3.StackApplication;

public class StackApplicationTest {

//	@Test
//	public void parseExpression(){
//		String[] inputs={
//				"[]","()","[1]","(2)","1","[)","[[","[(","((","(]","([","[()]","1[2()2()1]1"
//		};
//		for(String input:inputs){
//			System.out.print(input+" ");
//			System.out.println(StackApplication.parseExpression(input));
//		}
//	}
	
	@Test
	public void testCalculatePostfixExpression(){
		String  express="6 5 2 3 + 8 * + 3 + *";
		System.out.println(StackApplication.calculatePostfixExpression(express));
	}
	
	@Test
	public void testInfixToPostfixExpression(){
		String  express="a + b * c + ( d * e + f ) * g";
		System.out.println(StackApplication.infixToPostfixExpression(express));
	}
	
	
	@Test
	public void isOperator(){
		String[] inputs={
				"+","-","*","/","(",")","123"
		};
		long begin=System.currentTimeMillis();
		for(int i=0;i<100000;i++){	
			for(String input:inputs){
				StackApplication.isOperator(input);
			}
		}
		System.out.println(System.currentTimeMillis()-begin);
	}
	@Test
	public void isOperator2(){
		String[] inputs={
				"+","-","*","/","(",")","123"
		};
		long begin=System.currentTimeMillis();
		for(int i=0;i<100000;i++){	
			for(String input:inputs){
				StackApplication.isOperator2(input);
			}
		}
		System.out.println(System.currentTimeMillis()-begin);
	}
}
