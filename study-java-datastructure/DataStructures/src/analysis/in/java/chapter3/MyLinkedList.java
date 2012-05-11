package analysis.in.java.chapter3;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

	private int theSize;
	private int modCount=0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> prex;
		public Node<AnyType> next;
		public Node(AnyType data,Node<AnyType> prex,Node<AnyType> next){
			this.data=data;
			this.prex=prex;
			this.next=next;
		}
	}
	public MyLinkedList(){
		clear();
	}
	
	public void clear(){
		beginMarker=new Node<AnyType>(null,null,null);
		endMarker=new Node<AnyType>(null,beginMarker,null);
		beginMarker.next=endMarker;
		
		theSize=0;
		modCount++;
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public void add(AnyType data){
		add(size(),data);
	}
	
	public void add(int index,AnyType data){
		addBefore(getNode(index),data);
	}
	
	public AnyType get(int index){
		return getNode(index).data;
	}
	
	public AnyType set(int index,AnyType newValue){
		Node<AnyType> p=getNode(index);
		AnyType oldValue=p.data;
		p.data=newValue;
		return oldValue;
	}
	
	public AnyType remove(int index){
		return remove(getNode(index));
	}
	
	private void addBefore(Node<AnyType> p,AnyType data){
		Node<AnyType> newNode = new Node<AnyType>(data,p.prex,p);
		newNode.prex.next=newNode;
		p.prex=newNode;
		theSize++;
		modCount++;
	}
	
	private AnyType remove(Node<AnyType> p){
		p.prex.next=p.next;
		p.next.prex=p.prex;
		theSize--;
		modCount++;
		return p.data;
	}
	
	private Node<AnyType> getNode(int index){
		Node<AnyType> p=beginMarker.next;
		if(index<0||index>size()){
			throw new IndexOutOfBoundsException();
		}
		if(index<size()/2){
			p=beginMarker.next;
			for(int i=0;i<index;i++){
				p=p.next;
			}
		}else{
			p=endMarker;
			for(int i=size();i>index;i--){
				p=p.prex;
			}
		}
		return p;
	}
	@Override
	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements java.util.Iterator<AnyType>{

		private Node<AnyType> current = beginMarker.next;
		private int exceptedModCount = modCount;
		private boolean okToRemove = false;
		@Override
		public boolean hasNext() {
			return current!=endMarker;
		}

		@Override
		public AnyType next() {
			if(exceptedModCount!=modCount){
				throw new java.util.ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new java.util.NoSuchElementException();
			}
			AnyType nextItem = current.data;
			current=current.next;
			okToRemove = true;
			return nextItem;
		}

		@Override
		public void remove() {
			if(exceptedModCount!=modCount){
				throw new java.util.ConcurrentModificationException();
			}
			if(!okToRemove){
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prex);
			okToRemove = false;
			exceptedModCount++;
		}
		
	}

}
