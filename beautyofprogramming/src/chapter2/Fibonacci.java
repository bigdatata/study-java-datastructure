package chapter2;

/**
 * 计算Fibonacci序列最直接的方法就是利用递推公式 F(n+2)=F(n+1)+F(n)。
 * n=1 f(1)=1,n=0 f(0)=0
 * 而用通项公式来求解是错误的，用浮点数表示无理数本来就有误差，经过n次方后，
 * 当n相当大时，误差能足够大到影响浮点数转为整数时的精度，得到的结果根本不准。
 * 用矩阵来计算，虽然时间复杂度降到O(log n)，但要用到矩阵类，相当麻烦。
 *
 */
public class Fibonacci {

	public static int recursion(int n){
		if(n<=0){
			return 0;
		}else if(n==1){
			return 1;
		}else{
			return recursion(n-1)+recursion(n-2);
		}
	}
	public static int recursionWithRecord(int n){
		
		if(n<=0){
			return 0;
		}else if(n==1){
			return 1;
		}else{
			return recursionWithRecord(n-1)+recursionWithRecord(n-2);
		}
	}
	
	public static int nonRecursion(int n){
		int lastLast=0;
		int last=1;
		int current=0;
		while(n-->0){
			lastLast=last;
			last=current;
			current=last+lastLast;
		}
		return current;
	}
	public static void main(String[] args){
		System.out.println(recursion(10));
		System.out.println(nonRecursion(10));
	}
}
