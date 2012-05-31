package analysis.in.java.chapter6;


public class BinomialQueue <AnyType extends Comparable<? super AnyType>>{

	@SuppressWarnings("unchecked")
	public BinomialQueue(){
        theTrees = new Node[DEFAULT_TREES];
        currentSize=0;
        makeEmpty( );
    }
	public BinomialQueue(AnyType item){
		this();
		currentSize = 1;
		theTrees[0]=new Node<AnyType>(item);
	}
	/**
	 * Merge rhs into the priority queue.
	 * rhs becomes empty. rhs must be different from this.
	 * @param rhs the other binomial queue.
	 */
	public void merge(BinomialQueue<AnyType> rhs){
		if(this==rhs){
			return; //avoid aliasing problems
		}
		currentSize+=rhs.currentSize;
		if(currentSize>capacity()){
			int maxLength=Math.max(theTrees.length, rhs.theTrees.length);
			expandTheTrees(maxLength+1);
		}
		Node<AnyType> carry=null;
		for(int i=0,j=1;j<=currentSize;i++,j*=2){
			Node<AnyType> t1=theTrees[i];
			Node<AnyType> t2=i<rhs.theTrees.length?rhs.theTrees[i]:null;
			int whichCase=t1==null?0:1;
			whichCase+=t2==null?0:2;
			whichCase+=carry==null?0:4;
			
			switch(whichCase){
			case 0:	/*no trees*/
			case 1:/*Only this*/
				break;
			case 2:/*Only rhs*/
				theTrees[i]=t2;
				rhs.theTrees[i]=null;
				break;
			case 3:/*this and rhs*/
				carry=combineTrees(t1,t2);
				theTrees[i]=null;
				rhs.theTrees[i]=null;
				break;
			case 4:/*Only carry*/
				theTrees[i]=carry;
				break;
			case 5:/*this and carry*/
				carry=combineTrees(t1,carry);
				theTrees[i]=null;
				break;
			case 6:/*rhs and carry*/
				carry=combineTrees(carry,t2);
				rhs.theTrees[i]=null;
				break;
			case 7:/*this,rhs and carry*/
				theTrees[i]=carry;
				carry=combineTrees(t1,t2);
				theTrees[i]=null;
				rhs.theTrees[i]=null;
				break;
			}
		}
		for(int k=0;k<rhs.theTrees.length;k++){
			rhs.theTrees[k]=null;
		}
		rhs.currentSize=0;
	}
	public void insert(AnyType x){
		merge(new BinomialQueue<AnyType>(x));
	}
	public AnyType findMin(){
		int index=findMinIndex();
		return theTrees[index].element;
	}
	public AnyType deleteMin(){
		if( isEmpty( ) ){
			return null;
		}
		int index=findMinIndex();
		AnyType element=theTrees[index].element;

        int minIndex = findMinIndex( );
        //construct h''
        Node deletedTree = theTrees[ minIndex ].leftChild;
        BinomialQueue<AnyType> deletedQueue = new BinomialQueue<AnyType>( );
        deletedQueue.currentSize = ( 1 << minIndex ) - 1;
        for( int j = minIndex - 1; j >= 0; j-- )
        {
            deletedQueue.theTrees[ j ] = deletedTree;
            deletedTree = deletedTree.nextSibling;
            deletedQueue.theTrees[ j ].nextSibling = null;
        }
        //construct h'
        theTrees[ minIndex ] = null;
        currentSize -= deletedQueue.currentSize + 1;
        
        merge(deletedQueue);
		return element;
	}
	public boolean isEmpty(){
		return currentSize==0;
	}
	public void makeEmpty(){
		for(int i=0;i<theTrees.length;i++){
			theTrees[i]=null;
		}
	}
	private static class Node<AnyType>{
		AnyType element;
		Node<AnyType> leftChild;
		Node<AnyType> nextSibling;
		
		public Node(AnyType elment){
			this(elment, null, null);
		}
		
		public Node(AnyType element, Node<AnyType> leftChild,
				Node<AnyType> nextSibling) {
			this.element = element;
			this.leftChild = leftChild;
			this.nextSibling = nextSibling;
		}
	}
	private static final int DEFAULT_TREES=1;
	private int currentSize;
	private Node<AnyType>[] theTrees;
	private void expandTheTrees(int newNumTrees){
		
	}
	/**
	 *Return the result of merging equal-sized t1 and t2. 
	 */
	private Node<AnyType> combineTrees(Node<AnyType> t1,Node<AnyType> t2){
		if(t1.element.compareTo(t2.element)>0){
			return combineTrees(t2,t1);
		}
		t2.nextSibling=t1.leftChild;
		t1.leftChild=t2;
		return t1;
	}
	private int capacity(){
		return ((1<<theTrees.length)-1);
	}
	private int findMinIndex(){
		if(isEmpty()){
			throw new RuntimeException();
		}
		int minIndex=0;
		for(int i=1;i<theTrees.length;i++){
			if(theTrees[i].element.compareTo(theTrees[minIndex].element)<0){
				minIndex=i;
			}
		}
		return minIndex;
	}
}
