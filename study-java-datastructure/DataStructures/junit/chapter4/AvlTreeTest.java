package chapter4;

import org.junit.Test;

import analysis.in.java.chapter4.AvlTree;
import analysis.in.java.chapter4.AvlTree.Traveral;

public class AvlTreeTest {

	@Test
	public void test(){
		AvlTree<Integer> tree=new AvlTree<Integer>();
		for(int i=1;i<8;i++){
			tree.insert(i);
		}
		tree.insert(16);
		tree.insert(15);
		tree.insert(14);
		tree.insert(13);
		tree.insert(12);
		tree.insert(11);
		tree.insert(10);
		tree.insert(8);
		tree.insert(9);
		System.out.println("----------");
		tree.printTree(Traveral.PRE_ORDER);
		System.out.println("----------");
		tree.printTree(Traveral.IN_ORDER);
		System.out.println("----------");
		tree.printTree(Traveral.POST_ORDER);
	}
}
