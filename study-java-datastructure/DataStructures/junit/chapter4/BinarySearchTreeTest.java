package chapter4;

import org.junit.Test;

import analysis.in.java.chapter4.BinarySearchTree;

public class BinarySearchTreeTest {

	@Test
	public void test(){
		BinarySearchTree<Integer> tree=new BinarySearchTree<Integer>();
		int[] items={6,2,8,1,4,3};
		for(Integer item:items){
			tree.insert(item);
		}
		System.out.println("--------------");
		tree.printTree();
		System.out.println("--------------");
		System.out.println(tree.findMax());
		System.out.println(tree.findMin());
		System.out.println(tree.contains(5));
		System.out.println(tree.contains(4));
		tree.remove(2);
		System.out.println("--------------");
		tree.printTree();
		System.out.println("--------------");
		System.out.println(tree.isEmpty());
		tree.makeEmpty();
		System.out.println(tree.isEmpty());
		
	}
}
