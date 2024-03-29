package analysis.in.java.chapter5;

import java.util.LinkedList;
import java.util.List;


public class SeparateChainingHashTable<AnyType> implements MyHashTable<AnyType>{
	/**
	 * Construct the hash table.
	 */
	public SeparateChainingHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}

	/**
	 * Construct the hash table.
	 * 
	 * @param size approximate table size.
	 */
	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable(int size) {
		theLists = new LinkedList[nextPrime(size)];
		for (int i = 0; i < theLists.length; i++)
			theLists[i] = new LinkedList<AnyType>();
	}

	/**
	 * Insert into the hash table. If the item is already present, then do
	 * nothing.
	 * 
	 * @param x
	 *            the item to insert.
	 */
	@Override
	public void insert(AnyType x) {
		List<AnyType> whichList = theLists[myhash(x)];
		if(!whichList.contains(x)){
			whichList.add(x);
			//Rehash; see Section 5.5
//			if(++currentSize>theLists.length){
//				rehash();
//			}
		}
			
	}

	/**
	 * Remove from the hash table.
	 * 
	 * @param x
	 *            the item to remove.
	 */
	@Override
	public void remove(AnyType x) {
		List<AnyType> whichList = theLists[myhash(x)];
		if(whichList.contains(x)){
			whichList.remove(x);
			currentSize--;
		}
	}

	@Override
	public boolean contains(AnyType x){
		List<AnyType> whichList = theLists[myhash(x)];
		return whichList.contains(x);
	}

	/**
	 * Make the hash table logically empty.
	 */
	@Override
	public void makeEmpty() {
		for (int i = 0; i < theLists.length; i++)
			theLists[i].clear();
		currentSize=0;
	}
	private static final int DEFAULT_TABLE_SIZE = 101;

	/** The array of Lists. */
	private List<AnyType>[] theLists;
	
	private int currentSize;

	
	private int myhash(AnyType x){
		int hashVal=x.hashCode();
		hashVal%=theLists.length;
		if(hashVal<0){
			hashVal+=theLists.length;
		}
		return hashVal;
	}
	/**
	 * Rehashing for separate chaining hash table.
	 */
	private void rehash(){
		List<AnyType>[] oldLists=theLists;
		//create new double-sized,empty table
		theLists=new List[nextPrime(2*theLists.length)];
		for(int i=0;i<theLists.length;i++){
			theLists[i] = new LinkedList<AnyType>();
		}
		//copy table over
		for(int i=0;i<oldLists.length;i++){
			for(AnyType element:oldLists[i]){
				insert(element);
			}
		}
	}

	/**
	 * A hash routine for String objects.
	 * 
	 * @param key
	 *            the String to hash.
	 * @param tableSize
	 *            the size of the hash table.
	 * @return the hash value.
	 */
	public static int hash(String key, int tableSize) {
		int hashVal = 0;

		for (int i = 0; i < key.length(); i++)
			hashVal = 37 * hashVal + key.charAt(i);

		hashVal %= tableSize;
		if (hashVal < 0)
			hashVal += tableSize;

		return hashVal;
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

	// Simple main
	public static void main(String[] args) {
		SeparateChainingHashTable<Integer> H = new SeparateChainingHashTable<Integer>();

		final int NUMS = 4000;
		final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			H.insert(new Integer(i));
		for (int i = 1; i < NUMS; i += 2)
			H.remove(new Integer(i));

		for (int i = 2; i < NUMS; i += 2)
			if (!H.contains(new Integer(i)))
				System.out.println("Find fails " + i);

		for (int i = 1; i < NUMS; i += 2) {
			if (H.contains(new Integer(i)))
				System.out.println("OOPS!!! " + i);
		}
	}

}
