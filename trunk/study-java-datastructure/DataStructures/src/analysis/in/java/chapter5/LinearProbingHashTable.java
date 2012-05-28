package analysis.in.java.chapter5;

public class LinearProbingHashTable<AnyType> implements MyHashTable<AnyType>{

	private AnyType[] datas;   // the table
	private int currentSize;   // the size
	private int d;   // t.length = 2^d
	// is equal to currentSize  plus the number of removed  values in datas 
	private final static int DEFAULT_SIZE=16;
	
	public LinearProbingHashTable(){
		this(DEFAULT_SIZE);
	}
	public LinearProbingHashTable(int size){
		datas=(AnyType[]) new Object[size];
		currentSize=0;
		d=0;
		while((size>>=1)>0){
			d++;
		}
	}
	private int getTableSize(){
		return datas.length;
	}
	@Override
	public boolean contains(AnyType x) {
		int position=findPosition(x);
		if(null==datas[position]){
			return false;
		}
		return true;
	}

	@Override
	public void insert(AnyType x) {
		int position=findPosition(x);
		if(null==datas[position]){
			if (2*(currentSize+1)>getTableSize()){
					resize();   // max 50% occupancy
				}
			datas[position]=x;
			currentSize++;
		}
	}

	@Override
	public void makeEmpty() {
		int tableSize=getTableSize();
		for(int i=0;i<tableSize&&currentSize>0;i++){
			if(null!=datas[i]){
				datas[i]=null;
				currentSize--;
			}
		}
	}

	@Override
	public void remove(AnyType x) {
		int position=findPosition(x);
		if(null!=datas[position]){
			datas[position]=null;
			currentSize--;
			 if (8*currentSize < getTableSize()){
				 resize(); // min 12.5% occupancy
			 }
		}
	}
	/**
	 * internal method to find the position that the element x would deal.
	 * when the element of this position is null,the element x is not in the table,
	 * others the element of this position would be x. 
	 * @param x
	 * @return
	 */
	private int findPosition(AnyType x){
		int tableSize=getTableSize();
		int position=x.hashCode()%tableSize;
		if(position<0){
			position+=tableSize;
		}
		while(null!=datas[position]&&!datas[position].equals(x)){
			position++;
			if(position>=tableSize){
				position-=tableSize;
			}
		}
		return position;
	}

	private void resize() {
        d = 1;
        int tableSize=getTableSize();
        while ((1<<d) < 3*tableSize) d++;
        AnyType[] told = datas;
        datas = (AnyType[]) new Object[1<<d];
        // insert everything in told
        for (int k = 0; k < told.length; k++) {
            if (told[k] != null) {
            	insert(told[k]);
            }
        }
    }
	
}
