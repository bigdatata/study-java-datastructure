package chapter2;

public class GreatestCommonDivisor2_7 {

	/**
	 * 辗转相除法 迭代实现
	 */
	public static int gcd1(int x,int y){
		return (y==0)?x:gcd1(y,x%y);
	}
	/**
	 * 非迭代实现
	 */
	public static int gcd2(int x,int y){
		int temp=0;
		while(y!=0){
			temp=x%y;
			x=y;
			y=temp;
		}
		return x;
	}
	
	/**
	 * 不用求余运算  用减法运算
	 * 
	 * 迭代实现
	 */
	public static int gcd3(int x,int y){
		if(x<y){
			return gcd3(y,x);
		}
		if(x==0){
			return x;
		}else{
			return gcd3(x-y,y);
		}
		
	}
	/**
	 * 非迭代实现
	 */
	public static int gcd4(int x,int y){
		int temp=0;
		while(y!=0){
			while(x>=y){
				x=x-y;
			}
			temp=x;
			x=y;
			y=temp;
		}
		return x;
	}
	/**
	 * 移位运算
	 */
	public static int gcd5(int x,int y){
		int k=1;
		int temp=0;
		while(y!=0){
			if(isEven(x)){
				if(isEven(y)){
					k+=k;
					x>>=1;y>>=1;
				}else{
					x>>=1;
				}
			}else{
				if(isEven(y)){
					y>>=1;
				}else{
					if(x>=y){
						x=x-y;
					}
				}
			}
			temp=x;
			x=y;
			y=temp;
		}
		return k*x;
	
	}
	/**
	 * 判断x是否是偶数
	 */
	private static boolean isEven(int x){
		return !((x&0x01)==0x01);
	}
	public static void main(String[] args){
		System.out.println(gcd1(56,18436));
		System.out.println(gcd2(56,18436));
		//System.out.println(gcd3(56,18436)); stackoverflow
		System.out.println(gcd4(56,18436));
		System.out.println(gcd5(56,18436));
		
	}
	
}
