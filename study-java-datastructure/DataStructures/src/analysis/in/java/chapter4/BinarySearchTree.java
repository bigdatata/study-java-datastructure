package analysis.in.java.chapter4;

import analysis.in.java.util.UnderflowException;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

	private static class BinaryNode<AnyType>{
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
		
		public BinaryNode(AnyType element){
			this(element,null,null);
		}
		
		public BinaryNode(AnyType element,BinaryNode<AnyType> left,
				BinaryNode<AnyType> right){
			this.element=element;
			this.left=left;
			this.right=right;
		}
	}

	private BinaryNode<AnyType> root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	public void makeEmpty(){
		root=null;
	}
	
	public boolean isEmpty(){
		return null==root;
	}
	
	public boolean contains(AnyType element){
		return contains(element,root);
	}
	
	public AnyType findMin(){
		if(isEmpty()){
			throw new UnderflowException();
		}
		return findMin(root).element;
	}
	
	public AnyType findMax(){
		if(isEmpty()){
			throw new UnderflowException();
		}
		return findMax(root).element;
	}
	
	public void insert(AnyType element){
		root=insert(element,root);
	}
	public void remove(AnyType element){
		root = remove(element,root);
	}
	
	public void printTree(){
		printTree(root);
	}
	
	/**
	 * Internal method to search an item in a subtree
	 * @param element the item to search for.
	 * @param t the node that roots the subtree. 
	 * @return whether the subtree has a node that containing the search element.
	 */
	private boolean contains(AnyType element,BinaryNode<AnyType> t){
		if(null==t){
			return false;
		}
		int compareResult=element.compareTo(t.element);
		if(compareResult<0){
			return contains(element,t.left);
		}else if(compareResult>0){
			return contains(element,t.right);
		}
		//Match
		return true;
	}
	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node that containing the smallest item.
	 */
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if(null!=t){
			while(t.left!=null){
				t=t.left;
			}
		}
		return t;
	}
	/**
	 * Internal method to find the largest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node that containing the largest item.
	 */
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if(null!=t){
			while(t.right!=null){
				t=t.right;
			}
		}
		return t;
	}
	
	/**
	 * Internal method to insert into a subtree
	 * @param element the item to insert
	 * @param t the node that roots the subtree
	 * @return the new root of the subtree
	 */
	private BinaryNode<AnyType> insert(AnyType element,BinaryNode<AnyType> t){
		if(null==t){
			return new BinaryNode<AnyType>(element);
		}
		int compareResult=element.compareTo(t.element);
		if(compareResult<0){
			t.left = insert(element,t.left);
		}else if(compareResult>0){
			t.right = insert(element,t.right);
		}else{
			//Duplicate; do nothing
		}
		return t;
	}
	/**
	 * Internal method to remove from a subtree.
	 * @param element the item to remove.
	 * @param t the node that roots the subtree
	 * @return the new root of the subtree
	 */
	private BinaryNode<AnyType> remove(AnyType element,BinaryNode<AnyType> t){
		if(null==t){
			return t;
		}
		int compareResult=element.compareTo(t.element);
		if(compareResult<0){
			t.left = remove(element,t.left);
		}else if(compareResult>0){
			t.right = remove(element,t.right);
		}else if(null!=t.left&&null!=t.right){
			//Two children
			t.element=findMin(t.right).element;
			t.right=remove(t.element,t.right);
		}else{
			//One child
			t=(null!=t.left)?t.left:t.right;
		}
		return t;
	}
	
	/**
	 * Internal method to print a subtree in sorted order
	 * @param t the node that roots the subtree
	 */
	private void printTree(BinaryNode<AnyType> t){
		if(null!=t){
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
}
