package analysis.in.java.chapter5;

public class LinearProbingHashTable<AnyType> implements MyHashTable<AnyType>{

	private AnyType[] datas;   // the table
	private int currentSize;   // the size
	private int d;   // t.length = 2^d
	// is equal to currentSize  plus the number of removed  values in datas 
	private int q;   // number of non-null entries in t
	private final static int DEFAULT_SIZE=16;
	
	public LinearProbingHashTable(){
		this(DEFAULT_SIZE);
	}
	public LinearProbingHashTable(int size){
		datas=(AnyType[]) new Object[size];
		currentSize=0;
		q=0;
		while((size>>1)>0){
			
		}
	}
	@Override
	public boolean contains(AnyType x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(AnyType x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(AnyType x) {
		// TODO Auto-generated method stub
		
	}

	
}
