package analysis.in.java.chapter5;

public class QuadraticProbingHashTable<AnyType> implements MyHashTable<AnyType>{

	public QuadraticProbingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}
	public QuadraticProbingHashTable(int size){
		allocateArray(size);
		makeEmpty();
	}
	@Override
	public boolean contains(AnyType x) {
		int position = getPosition(x);
		return isActive(position);
	}

	@Override
	public void insert(AnyType x) {
		int position = getPosition(x);
		if(isActive(position)){
			return ;
		}
		array[position] = new HashEntry<AnyType>(x);
		//Rehash; see Section 5.5
		if(++currentSize>getTableSize()/2){
			rehash();
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
		int position = getPosition(x);
		if(isActive(position)){
			array[position].isActive=false;
		}
		
	}
	
	private static class HashEntry<AnyType>{
		public AnyType element;
		public boolean isActive;
		public HashEntry(AnyType e){
			this(e,true);
		}
		public HashEntry(AnyType e,boolean active){
			this.element=e;
			this.isActive=active;
		}
	}
	private static final int DEFAULT_TABLE_SIZE=11;
	
	private HashEntry<AnyType>[] array; 
	
	private int currentSize;
	
	private void allocateArray(int arraySize){
		if(arraySize<=0){
			arraySize=DEFAULT_TABLE_SIZE;
		}
		array=new HashEntry[arraySize];
	}
	
	private boolean isActive(int currentPos){
		return null!=array[currentPos]&&!array[currentPos].isActive;
	}
	
	private int getPosition(AnyType x){
		int offset=1;
		int position=myhash(x);
		while(null!=array[position]&&!array[position].equals(x)){
			position+=offset;//compute ith probe
			offset+=2;
			if(position>=getTableSize()){
				position-=getTableSize();
			}
		}
		return position;
	}
	
	private void rehash(){
		HashEntry<AnyType>[] oldArray=array;
		int oldSize=getTableSize();
		allocateArray(nextPrime(2*oldSize));
		currentSize=0;
		//copy table over
		for(int i=0;i<oldSize;i++){
			if(null!=oldArray[i]&&oldArray[i].isActive){
				insert(oldArray[i].element);
			}
		}
	}
	
	private int myhash(AnyType x){
		int tableSize=getTableSize();
		int position=x.hashCode()%tableSize;
		if(position<0){
			position+=tableSize;
		}
		return position;
	}
	
	private int getTableSize(){
		return array.length;
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
