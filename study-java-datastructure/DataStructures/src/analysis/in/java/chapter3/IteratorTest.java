package analysis.in.java.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest implements Iterator<Integer>{

	private List<Integer> datas=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
	private int index=0;
	@Override
	public boolean hasNext() {
		return index<datas.size()-1;
	}

	@Override
	public Integer next() {
		return datas.get(index++);
	}

	@Override
	public void remove() {
		datas.remove(index);
	}

}
