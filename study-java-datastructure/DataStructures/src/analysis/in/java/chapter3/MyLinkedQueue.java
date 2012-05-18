package analysis.in.java.chapter3;

public class MyLinkedQueue<AnyType> implements MyQueue<AnyType> {
	
	private int currentSize;
	private Node<AnyType> head;
	private Node<AnyType> tail;
	public MyLinkedQueue(){
		head=new Node<AnyType>(null,null,null);
		tail=new Node<AnyType>(null,head,null);
		head.next=tail;
		currentSize=0;
	}
	private static class Node<AnyType>{
		AnyType element;
		Node<AnyType> prex;
		Node<AnyType> next;
		public Node(AnyType element,Node<AnyType> prex,Node<AnyType> next){
			this.element=element;
			this.prex=prex;
			this.next = next;
		}
	}

	@Override
	public int currentSize() {
		return currentSize;
	}

	@Override
	public AnyType dequeue() {
		AnyType element=null;
		if(!isEmpty()){
			currentSize--;
			Node<AnyType> temp=head.next;
			element=temp.element;
			temp.next.prex=head;
			head.next=temp.next;
			temp.next=null;
			temp.prex=null;
			temp=null;
		}
		return element;
	}

	@Override
	public void enqueue(AnyType element) {
		currentSize++;
		Node<AnyType> temp=new Node<AnyType>(element,tail.prex,tail);
		tail.prex.next=temp;
		tail.prex=temp;
	}

	@Override
	public boolean isEmpty() {
		return currentSize==0?true:false;
	}

}
