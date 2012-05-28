package analysis.in.java.chapter5;

public class DoubleHashHashTable<AnyType> implements MyHashTable<AnyType> {

	public DoubleHashHashTable(){
		this(DEFAULT_SIZE);
	}
	
	public DoubleHashHashTable(int size){
		allocateArray(size);
		currentSize=0;
	}
	@Override
	public boolean contains(AnyType x) {
		int position=getPosition(x);
		boolean contain=true;
		if(null==array[position]||!array[position].equals(x)){
			contain=false;
		}
		return contain;
	}

	@Override
	public void insert(AnyType x) {
		int position=getPosition(x);
		if(null==array[position]){
			array[position]=x;
			currentSize++;
		}
	}

	@Override
	public void makeEmpty() {
		currentSize=0;
		for(int i=0;i<getTableSize();i++){
			array[i]=null;
		}
	}

	@Override
	public void remove(AnyType x) {
		int position=getPosition(x);
		if(null!=array[position]){
			array[position]=null;
			currentSize--;
		}
		
	}
	
	private static final int DEFAULT_SIZE=11;
	
	private AnyType[] array;
	private int currentSize;
	
	private void allocateArray(int size){
		if(size<=0){
			size=DEFAULT_SIZE;
		}
		array = (AnyType[])new Object[size]; 
	}
	private int getTableSize(){
		return array.length;
	}
	private int myhash(AnyType x){
		int tableSize=getTableSize();
		int position=x.hashCode()%tableSize;
		if(position<0){
			position+=tableSize;
		}
		return position;
	}
	private int hash2(int x){
		return 7-(x%7);
	}
	private int getPosition(AnyType element){
		int position=myhash(element);
		int temp=0;
		while(null!=array[position+temp*hash2(position)]&&
					!array[position+temp*hash2(position)].equals(element)){
			temp++;
		}
		return position+temp*hash2(position);
	}
	
	
	/**
	 * Internal method to find a prime number at least as large as n.
	 * 
	 * @param n
	 *            the starting number (must be positive).
	 * @return a prime number larger than or equal to n.
	 */
	private static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;

		for (; !isPrime(n); n += 2)
			;
		return n;
	}

	/**
	 * Internal method to test if a number is prime. Not an efficient algorithm.
	 * 
	 * @param n
	 *            the number to test.
	 * @return the result of the test.
	 */
	private static boolean isPrime(int n) {
		if (n == 2 || n == 3)
			return true;

		if (n == 1 || n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;

		return true;
	}

}
