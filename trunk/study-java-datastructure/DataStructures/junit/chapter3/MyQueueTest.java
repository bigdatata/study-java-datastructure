package chapter3;

import org.junit.Test;

import analysis.in.java.chapter3.MyArrayQueue;
import analysis.in.java.chapter3.MyLinkedQueue;
import analysis.in.java.chapter3.MyQueue;

public class MyQueueTest {

	@Test
	public void testArrayQueue(){
		MyQueue<Integer> queue=new MyArrayQueue<Integer>();
		for(int i=0;i<10;i++){
			queue.enqueue(i);
		}
		for(int i=0;i<5&&!queue.isEmpty();i++){
			System.out.println(queue.dequeue());
		}
		for(int i=10;i<20;i++){
			queue.enqueue(i);
		}
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}
	@Test
	public void testLinkedQueue(){
		MyQueue<Integer> queue=new MyLinkedQueue<Integer>();
		for(int i=0;i<10;i++){
			queue.enqueue(i);
		}
		for(int i=0;i<5&&!queue.isEmpty();i++){
			System.out.println(queue.dequeue());
		}
		for(int i=10;i<20;i++){
			queue.enqueue(i);
		}
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
	}
	}
}
