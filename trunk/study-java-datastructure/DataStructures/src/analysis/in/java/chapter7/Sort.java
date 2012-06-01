package analysis.in.java.chapter7;

public class Sort {

	/**
	 * Simple insertion sort
	 * @param a an array of Comparable items
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void insertSort(AnyType[] a){
		if(null==a){
			return;
		}
		int j;
		AnyType temp;
		for(int i=1;i<a.length;i++){
			temp=a[i];
			for(j=i;j>0&&temp.compareTo(a[j-1])<0;j--){
				a[j]=a[j-1];
			}
			a[j]=temp;
		}
	}
	/**
	 * Shell sort using Shell's (poor) increments.
	 * @param a  an array of Comparable items
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void shellSort(AnyType[] a){
		if(null==a){
			return;
		}
		int j;
		AnyType temp;
		for(int gap=a.length/2;gap>0;gap/=2){
			for(int i=gap;i<a.length;i+=gap){
				temp=a[i];
				for(j=i;j>=gap&&temp.compareTo(a[j-gap])<0;j-=gap){
					a[j]=a[j-gap];
				}
				a[j]=temp;
			}
		}
	}
	
	public static <AnyType extends Comparable<? super AnyType>>
	void heapSort(AnyType[] a){
		for(int i=a.length/2;i>=0;i--){
			percDown(a,i,a.length);
		}
		for(int i=a.length-1;i>0;i--){
			swapReferences(a,0,i);
			percDown(a,0,i);
		}
		
	}
	
	private static<AnyType> void swapReferences(AnyType[] a,int i,int j){
		AnyType temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	private static int leftChild(int i){
		return i+i+1;
	}
	private static <AnyType extends Comparable<? super AnyType>>
	void percDown(AnyType[] a,int i,int n){
		AnyType temp=a[i];
		int child;
		for(;leftChild(i)<n;i=child){
			child=leftChild(i);
			if(child!=n-1&&a[child].compareTo(a[child+1])<0){
				child++;
			}
			if(a[child].compareTo(temp)>0){
				a[i]=a[child];
			}else{
				break;
			}
		}
		a[i]=temp;
	}
	/**
	 * Merge Sort algorithm.
	 * @param a an array of Comparable item.
	 */
	@SuppressWarnings("unchecked")
	public static <AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType[] a){
		AnyType[] tempArray=(AnyType[])new Comparable[a.length];
		mergeSort(a,tempArray,0,a.length);
	}
	/**
	 * Internal method that makes recursive calls.
	 * @param a an array of Comparable item.
	 * @param temp an array to place the merge result.
	 * @param left the left-most index of the sub-array.
	 * @param right the right-most index of the sub-array.
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	void mergeSort(AnyType[] a,AnyType[] temp,int left,int right){
		if(left<right){
			int middle=(left+right)/2;
			mergeSort(a,temp,left,middle);
			mergeSort(a,temp,middle,right);
			merge(a,temp,left,middle+1,right);
		}
	}
	/**
	 * Internal method that merge two sorted halves of a sub-array.
	 * @param a  an array of Comparable item.
	 * @param temp an array to place the merge result.
	 * @param leftPos the left-most index of the sub-array.
	 * @param rightPos the index of the start of the second  half.
	 * @param rightEnd the right-most index of the sub-array.
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	void merge(AnyType[] a,AnyType[] temp,int leftPos,int rightPos,int rightEnd){
		int i=leftPos,j=rightPos,leftEnd=rightPos-1,k=leftPos;
		while(i<=leftEnd&&j<=rightEnd){
			if(a[i].compareTo(a[j])>=0){
				temp[k++]=a[i++];
			}else{
				temp[k++]=a[j++];
			}
		}
		while(i<=leftEnd){
			temp[k++]=a[i++];
		}
		while(j<=rightEnd){
			temp[k++]=a[j++];
		}
		for(int m=rightEnd;m>=leftPos;m--){
			a[m]=temp[m];
		}
	}
	/**
	 * Quick sort algorithm
	 * @param a  an array of Comparable item.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	void quickSort(AnyType[] a){
		
	}
	/**
	 * Return median of left,center and right.
	 * Order these and hide the pivot
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	AnyType median3(AnyType[] a,int left,int right){
		int center=(left+right)/2;
		if(a[center].compareTo(a[left])<0){
			swapReferences(a,center,left);
		}
		if(a[right].compareTo(a[left])<0){
			swapReferences(a,left,right);
		}
		if(a[right].compareTo(a[center])<0){
			swapReferences(a,center,right);
		}
		//place pivot at position right-1
		swapReferences(a,center,right-1);
		return a[right-1];
	}
	/**
	 * Internal quick sort method that makes recursive calls.
	 * Uses median-of-tree partitioning and a cutoff of 10.
	 * @param a  an array of Comparable item.
	 * @param left the left-most index of the sub-array
	 * @param right the right-most index of the sub-array
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	void quickSort(AnyType[] a,int left,int right){
		if(left+CUTOFF<=right){
			AnyType pivot=median3(a,left,right);
			//begin partitioning
			int i=left,j=right-1;
			for(;;){
				while(a[++i].compareTo(pivot)<0){}
				while(a[--j].compareTo(pivot)>0){}
				if(i<j){
					swapReferences(a,i,j);
				}else{
					break;
				}
			}
			//restore pivot
			swapReferences(a,i,right-1);
			quickSort(a,left,i-1);//sort small elements
			quickSort(a,i+1,right);//sort large elements
		}else{
			insertionSort(a,left,right);
		}
	}
	private static final int CUTOFF=10;
	
	/**
	 * do an insertion sort on the sub-array
	 * @param a
	 * @param left
	 * @param right
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	void insertionSort(AnyType[] a,int left,int right){
		int j;
		for(int i=left+1;i<=right;i++){
			AnyType temp=a[i];
			j=i;
			for(;j>left&&a[j-1].compareTo(temp)>0;j--){
				a[j]=a[j-1];
			}
			a[j]=temp;
		}
	}
	
	
}
