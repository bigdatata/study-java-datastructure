package analysis.in.java.chapter2;

public class ContiguousSubsequenceSum {

	/**
	 * Cubic maximum contiguous subsequence sum algorithm
	 */
	public static int maxSubSum1(int [] a){
		int maxSum=0;
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){
				int thisSum=0;
				for(int k=i;k<=j;k++){
					thisSum+=a[k];
				}
				if(thisSum>maxSum){
					maxSum=thisSum;
				}
			}
		}
		return maxSum;
	}
	
	/**
	 * Quadratic maximum contiguous subsequence sum algorithm
	 */
	public static int maxSubSum2(int [] a){
		int maxSum=0;
		for(int i=0;i<a.length;i++){
			int thisSum=0;
			for(int j=i;j<a.length;j++){
				thisSum+=a[j];
				if(thisSum>maxSum){
					maxSum=thisSum;
				}
			}
		}
		return maxSum;
	}
	
	/**
	 * Driver for divide-and-conquer maximum contiguous subsequence sum algorithm
	 */
	public static int maxSubSum3(int [] a){
		return maxSumRec(a,0,a.length-1);
	}
	
	/**
	 * Recursive maximum contiguous subsequence sum algorithm.
	 * Finds maximum sum in sub-array spanning a[left...right].
	 * Does not attempt to maintain actual best sequence.
	 */
	private static int maxSumRec(int [] a, int left,int right){
		if(left==right){
			if(a[left]>0){
				return a[left];
			}else{
				return 0;
			}
		}
		int center=(left+right)/2;
		int maxLeft=maxSumRec(a,left,center);
		int maxRight=maxSumRec(a,center+1,right);
		int maxLeftBoderSum=0,leftBorderSum=0;
		for(int i = center;i >= left;i--){
			leftBorderSum+=a[i];
			if(leftBorderSum>maxLeftBoderSum){
				maxLeftBoderSum = leftBorderSum;
			}
		}
		int maxRightBorderSum=0,rightBorderSum=0;
		for(int i=center+1;i<=right;i++){
			rightBorderSum += a[i];
			if(rightBorderSum>maxRightBorderSum){
				maxRightBorderSum = rightBorderSum;
			}
		}
		return Math.max(maxRightBorderSum+maxLeftBoderSum, Math.max(maxLeft, maxRight));
	}
	
	/**
	 * Linear-time maximum contiguous subsequence sum algorithm
	 */
	public static int maxSubSum4(int [] a){
		int maxSum=0,thisSum=0;
		for(int i = 0;i < a.length;i++){
			thisSum += a[i];
			if(thisSum>maxSum){
				maxSum = thisSum;
			}else if(thisSum<0){
				thisSum = 0;
			}
		}
		return maxSum;
	}
}
