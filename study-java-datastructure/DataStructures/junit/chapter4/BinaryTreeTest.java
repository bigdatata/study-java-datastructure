package chapter4;

import org.junit.Test;

import analysis.in.java.chapter3.MyArrayStack;
import analysis.in.java.chapter3.MyStack;
import analysis.in.java.chapter3.StackApplication;
import analysis.in.java.chapter4.BinaryTree;

public class BinaryTreeTest {

	@Test
	public void test(){
		String postExpress="a b + c d e + * *";
		BinaryTree<Character> binaryTree=postExpressToTree(postExpress);
		System.out.println("preOrder");
		binaryTree.preOrderTraveral();
		System.out.println("inOrder");
		binaryTree.inOrderTraveral();
		System.out.println("postOrder");
		binaryTree.postOrderTraveral();
		
	}
	/**
	 * get express tree from postExpress
	 * @param postExpress
	 * @return
	 */
	private BinaryTree<Character> postExpressToTree(String postExpress){
		if(null==postExpress||postExpress.equals("")){
			return null;
		}
		MyStack<BinaryTree<Character>> stack=new MyArrayStack<BinaryTree<Character>>();
		String[] inputs=postExpress.split(" ");
		for(String input:inputs){
			boolean isOperator=StackApplication.isOperator2(input);
			if(!isOperator){
				BinaryTree<Character> temp=new BinaryTree<Character>(input.charAt(0),null,null);
				stack.push(temp);
			}else{
				BinaryTree<Character> right=stack.pop();
				BinaryTree<Character> left=stack.pop();
				BinaryTree<Character> temp=new BinaryTree<Character>(input.charAt(0),left,right);
				stack.push(temp);
			}
		}
		return stack.pop();
	}
}
