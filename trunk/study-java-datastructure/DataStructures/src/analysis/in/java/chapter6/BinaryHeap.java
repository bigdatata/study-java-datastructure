package analysis.in.java.chapter6;

import analysis.in.java.util.UnderflowException;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

	public BinaryHeap(){
		this(DEFAULT_CAPACITY);
	}
	public BinaryHeap(int capacity){
		currentSize = 0;
        array = (AnyType[]) new Comparable[ capacity + 1 ];
	}
	
	public BinaryHeap(AnyType[] items){
		this(items.length + 1+DEFAULT_CAPACITY);
		currentSize=items.length;
		for(int i=1;i<=items.length;i++){
			array[i]=items[i-1];
		}
		buildHeap();
	}
	
	public void insert(AnyType item){
		if(currentSize==array.length-1){
			enlargeArray(array.length*2+1);
		}
		int hole=++currentSize;
		for(;hole>1&&item.compareTo(array[hole/2])<0;hole/=2){
			array[hole]=array[hole/2];
		}
		array[hole]=item;
	}
	
	public AnyType findMin(){
		return array[1];
	}
	
	public AnyType deleteMin(){
		if(isEmpty()){
			throw new UnderflowException();
		}
		AnyType minItem=findMin();
		array[1]=array[currentSize--];
		percolateDown(1);
		return minItem;
	}
	
	public boolean isEmpty(){
		return currentSize==0;
	}
	
	public void makeEmpty(){
		for(int i=1;i<=currentSize;i++){
			array[i]=null;
		}
		currentSize=0;
	}
	
	private static final int DEFAULT_CAPACITY=10;
	
	private int currentSize;
	
	private AnyType[] array;
	
	private void percolateDown(int hole){
		int child;
		AnyType tmp=array[hole];
		for(;hole*2<=currentSize;hole=child){
			child=hole*2;
			if(child<currentSize&&array[child].compareTo(array[child+1])>0){
				child++;
			}
			if(array[child].compareTo(tmp)<0){
				array[hole]=array[child];
			}else{
				break;
			}
		}
		array[hole]=tmp;
	}
	
	private void buildHeap(){
		for(int i=currentSize/2;i>0;i--){
			percolateDown(i);
		}
	}
	
	private void enlargeArray(int newSize){
		if(newSize<=array.length){
			return;
		}
		AnyType[] oldArray=array;
		array=(AnyType[])new Comparable[newSize];
		for(int i=1;i<=currentSize;i++){
			array[i]=oldArray[i];
		}
	}
	  // Test program
    public static void main( String [ ] args )
    {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<Integer>( numItems );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
        	h.insert(i);
        for( i = 1; i < numItems; i++ )
        	if( (( h.deleteMin( ) )).intValue( ) != i )
        		System.out.println( "Oops! " + i );
        
        for( i=1;i<=numItems;i++ )
        	h.insert(i);
        h.insert(0);
        i = 9999999;
        h.insert(i);
        h.deleteMin();
        for( i = 1; i <= h.currentSize; i++ )
        	if( (( h.deleteMin( ) )).intValue( ) != i )
        		System.out.println( "Oops! " + i + " " );
        h.deleteMin();
    }

}
