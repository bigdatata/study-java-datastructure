package analysis.in.java.chapter3;

public class MyArrayQueue<AnyType> implements MyQueue<AnyType> {

	private AnyType[] theArray;
	private int front;
	private int back;
	private int currentSize;
	private int capacity;
	private static int DEFAULT_QUEUE_SIZE=10;
	
	public MyArrayQueue(int queueSize){
		initQueue(10);
	}
	public MyArrayQueue(){
		initQueue(DEFAULT_QUEUE_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	private void initQueue(int queueSize){
		theArray=(AnyType[])new Object[queueSize];
		front=0;
		back=-1;
		currentSize=0;
		capacity=queueSize;
	}
	
	@Override
	public int currentSize() {
		return currentSize;
	}

	@Override
	public AnyType dequeue() {
		AnyType element=null;
		if(!isEmpty()){
			element=theArray[front++];
			currentSize--;
			if(front>=capacity){
				front-=capacity;
			}
		}
		return element;
	}

	@Override
	public void enqueue(AnyType element) {
		if(currentSize==capacity){
			System.out.println("队列已满");
			return ;
		}
		currentSize++;
		++back;
		if(back>=capacity){
			back-=capacity;
		}
		theArray[back]=element;
	}

	@Override
	public boolean isEmpty() {
		return currentSize==0?true:false;
	}

}
