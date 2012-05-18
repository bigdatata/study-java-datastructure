package analysis.in.java.chapter3;

public class MyLinkedStack<AnyType> implements MyStack<AnyType>{	
	private Node<AnyType> STACK_BOTTOM;
	private Node<AnyType> stackTop;
	public MyLinkedStack(){
		STACK_BOTTOM=new Node<AnyType>(null,null);
		stackTop=STACK_BOTTOM;
	}
	private static class Node<AnyType>{
		AnyType element;
		Node<AnyType> next;
		public Node(AnyType element,Node<AnyType> next){
			this.element=element;
			this.next=next;
		}
	}
	@Override
	public void push(AnyType data){
		stackTop=new Node<AnyType>(data,stackTop);
		
	}
	@Override
	public AnyType top(){
		if(isEmpty()){
			return null;
		}
		return stackTop.element;
	}
	@Override
	public AnyType pop() {
		if(isEmpty()){
			return null;
		}
		Node<AnyType> temp=stackTop;
		stackTop=stackTop.next;
		temp.next=null;
		return temp.element;
	}
	@Override
	public boolean isEmpty(){
		return stackTop==STACK_BOTTOM;
	}	
}
