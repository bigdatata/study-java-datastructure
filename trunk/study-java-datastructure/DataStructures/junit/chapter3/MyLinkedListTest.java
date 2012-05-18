package chapter3;

import org.junit.Test;

import analysis.in.java.chapter3.MyLinkedList;

public class MyLinkedListTest {

	@Test
	public void test(){
		 MyLinkedList<Integer> list=new MyLinkedList<Integer>();
		 for(int i=0;i<10;i++){
			 list.add(i);
		 }
		 printList(list);
		 list.add(0,10);
		 printList(list);
		 System.out.println(list.remove(0));
		 System.out.println(list.set(5, 55));
		 printList(list);
	}
	private void printList(MyLinkedList list){
		for(Object object:list){
			System.out.print(object+"¡¡");
		}
		System.out.println();
	}
}
