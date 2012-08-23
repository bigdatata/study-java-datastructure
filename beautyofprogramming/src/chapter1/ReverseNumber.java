package chapter1;

public class ReverseNumber {

	public static long getReverseNumber(int[] datas){
		return 0;
	}
	
	public static long mergeReverse(int[] datas){
		int[] temp=new int[datas.length];
		return mergeReverse(datas,temp,0,datas.length-1);
	}
	
	private static long mergeReverse(int[] datas,int[] temp,int left,int right){
		long totalReverse=0;
		if(left<right){
			int middle=(left+right)/2;
			totalReverse+=mergeReverse(datas,temp,left,middle);
			totalReverse+=mergeReverse(datas,temp,middle+1,right);
			totalReverse+=merge(datas,temp,left,middle+1,right);
		}
		return totalReverse;
	}
	
	private static long merge(int[] datas,int[] temp,int leftPos,int rightPos,int rightEnd){
		int i=leftPos,j=rightPos,leftEnd=rightPos-1,k=leftPos;
		long change=0;
		long count=0;long total=0;
		while(i<=leftEnd&&j<=rightEnd){
			if(datas[i]<=datas[j]){
				temp[k++]=datas[i++];
				total+=count;
			}else{
				temp[k++]=datas[j++];
				count++;
				//change+=leftEnd-i+1;
			}
		}
		while(i<=leftEnd){
			temp[k++]=datas[i++];
			total+=count;
		}
		while(j<=rightEnd){
			temp[k++]=datas[j++];
		}
//		while(--k>=leftPos){
//			datas[k]=temp[k];
//		}
		for(int m=rightEnd;m>=leftPos;m--){
			datas[m]=temp[m];
		}
		return total;//change;
	}
	public static void main(String[] args){
		int[][] datas={{1,2},{2,1},{3,2,1},{4,3,2,1}};
		System.out.println(datas.length);
		for(int[] data:datas){
			System.out.println(mergeReverse(data));
		}
	}
}
