package analysis.in.java.chapter5;

public interface MyHashTable<AnyType> {

	boolean contains(AnyType x);
	
	void insert(AnyType x);
	
	void remove(AnyType x);
	
	void makeEmpty();
}
