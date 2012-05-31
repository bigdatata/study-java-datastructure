package analysis.in.java.chapter6;

import analysis.in.java.util.UnderflowException;


public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {

	public LeftistHeap(){
		root=null;
	}
	
	/**
	 * Merge rhs into the priority queue.
	 * rhs becomes empty,rhs must be different from this.
	 * @param rhs the leftist heap
	 */
	public void merge(LeftistHeap<AnyType> rhs){
		if(this==rhs){
			return;
		}
		root=merge(this.root,rhs.root);
		rhs.root=null;
	}
	public void insert(AnyType element){
		root = merge(new Node<AnyType>(element),root);
	}
	public AnyType findMin(){
		if(isEmpty()){
			throw new UnderflowException();
		}
		return  root.element;
	}
	public AnyType deleteMin(){
		if(isEmpty()){
			throw new UnderflowException();
		}
		AnyType temp=root.element;
		root=merge(root.left,root.right);
		return temp;
	}
	public boolean isEmpty(){
		return null==root;
	}
	public void makeEmpty(){
		root=null;
	}
	private static class Node<AnyType>{
		AnyType element;
		Node<AnyType> left;
		Node<AnyType> right;
		int npl;		//null path length		
		public Node(AnyType element){
			this(element,null,null);
		}
		
		public Node(AnyType element,Node<AnyType> left,
				Node<AnyType> right){
			this.element=element;
			this.left=left;
			this.right=right;
		}
	}
	
	private Node<AnyType> root;
	
	/**
	 * Internal method to merge two roots.
	 * Deals with deviant cases and calls recursive merge1
	 */
	private Node<AnyType> merge(Node<AnyType> h1,Node<AnyType> h2){
		if(null==h1){
			return h2;
		}
		if(null==h2){
			return h1;
		}
		if(h1.element.compareTo(h2.element)<0){
			return merge1(h1,h2);
		}else{
			return merge1(h2,h1);
		}
	}
	/**
	 * Internal method to merge two roots.
	 * Assumes trees are not empty,and h1's root contains smallest item.
	 */
	private Node<AnyType> merge1(Node<AnyType> h1,Node<AnyType> h2){
		//Single node
		if(null==h1.left){
			h1.left=h2;
		}else{
			h1.right=merge(h1.right,h2);
			if(h1.left.npl<h1.right.npl){
				swapChildren(h1);
			}
			h1.npl=h1.right.npl+1;
		}
		return h1;
	}
	private void swapChildren(Node<AnyType> t){
		Node<AnyType> temp;
		if(null!=t){
			temp=t.left;
			t.left=t.right;
			t.right=temp;
		}
	}
}
