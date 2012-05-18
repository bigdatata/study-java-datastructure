package chapter3;

import org.junit.Test;

import analysis.in.java.chapter3.MyArrayStack;
import analysis.in.java.chapter3.MyLinkedStack;
import analysis.in.java.chapter3.MyStack;

public class MyStackTest {

	@Test
	public void testArrayStack(){
		MyStack<Integer> stack=new MyArrayStack<Integer>();
		stack.push(1);
		System.out.println(stack.top());
		stack.push(2);
		System.out.println(stack.pop());
		for(int i=0;i<10;i++){
			stack.push(i);
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+ " ");
		}
		System.out.println();
	}
	@Test
	public void testLinkedStack(){
		MyStack<Integer> stack=new MyLinkedStack<Integer>();
		stack.push(1);
		System.out.println(stack.top());
		stack.push(2);
		System.out.println(stack.pop());
		for(int i=0;i<10;i++){
			stack.push(i);
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+ " ");
		}
		System.out.println();
	}
}
