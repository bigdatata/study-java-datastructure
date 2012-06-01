package chapter7;

import org.junit.Test;

import analysis.in.java.chapter7.Sort;

public class SortTest {

	@Test
	public void testInsertSort(){
		Integer[] a={1,2,25,6,6,8,9,12,0,23,45,34};
		Sort.insertSort(a);
		printArray(a);
	}
	
	@Test
	public void testShellSort(){
		Integer[] a={1,2,25,6,6,8,9,12,0,23,45,34};
		Sort.shellSort(a);
		printArray(a);
	}
	
	@Test
	public void testHeapSort(){
		Integer[] a={1,2,25,6,6,8,9,12,0,23,45,34};
		Sort.heapSort(a);
		printArray(a);
	}
	
	@Test
	public void testMergeSort(){
		Integer[] a={1,2,25,6,6,8,9,12,0,23,45,34};
		Sort.mergeSort(a);
		printArray(a);
	}
	@Test
	public void testQuickSort(){
		Integer[] a={1,2,25,6,6,8,9,12,0,23,45,34};
		Sort.quickSort(a);
		printArray(a);
	}
	
	@Test
	public void testBucketSort(){
		int[] a={1,2,25,6,6,8,9,12,0,23,45,34};
		Sort.bucketSort(a,45);
		for(int temp:a){
			System.out.format("%d ",temp);
		}
		System.out.println();
	}
	
	private <AnyType>void printArray(AnyType[] a){
		for(AnyType temp:a){
			System.out.format("%s ",temp);
		}
		System.out.println();
	}
}
