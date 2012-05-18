package analysis.in.java.chapter3;

public interface MyQueue<AnyType> {
	
	void enqueue(AnyType element);
	
	AnyType dequeue();
	
	boolean isEmpty();
	
	int currentSize();

}
