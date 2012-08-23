package chapter2;

public class CountOne {

	/**
	 * 解法一：直接除2 对s除以2，余数为1则count加1，
	 * 时间复杂度为O(logv) v为s的二进制位数
	 * 
	 * @param s
	 * @return s中一个个数
	 */
	public static int count1(int s) {
		int count = 0;
		while (s != 0) {
			if (s % 2 == 1)
				count++;
			s /= 2;
		}
		return count;
	}

	/**
	 * 解法二：使用位操作 对s使用位运算，将s与0x01做位与，
	 * 为1 则count加1 时间复杂度为O(logv)，v为s的二进制位数
	 * 
	 * @param s
	 * @return
	 */
	public static int count2(int s) {
		int count = 0;
		while (s != 0) {
			if ((s & 0x01) == 1)
				count++;
			s >>= 1;

		}
		return count;
	}

	/**
	 * 解法三：只考虑1的个数
	 * 例如对s=15=1111, 
	 * s=s&(s-1)=1111&1110=1110,result=1; 
	 * s=s&(s-1)=1110&1101=1100,result=2; 
	 * s=s&(s-1)=1100&1011=1000,result=3; 
	 * s=s&(s-1)=1000&0111=0000,result=4; 
	 * 时间复杂度O(M)，M为s中1的个数
	 * @param s
	 * @return
	 */
	public static int count3(int s) {
		int count = 0;
		while (s != 0) {
			s &= (s - 1);
			count++;
		}
		return count;
	}
	/**
	 * 预定义的结果表
	 */
	private static byte countTable[]={
		0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,
		1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,
		1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,
		2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,
		1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,
		2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,
		2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,
		3,4,4,5,4,5,5,6,4,5,5,6,5,6,6,7,
		1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,
		2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,
		2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,
		3,4,4,5,4,5,5,6,4,5,5,6,5,6,6,7,
		2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,
		3,4,4,5,4,5,5,6,4,5,5,6,5,6,6,7,
		3,4,4,5,4,5,5,6,4,5,5,6,5,6,6,7,
		4,5,5,6,5,6,6,7,5,6,6,7,6,7,7,8
	};
	/**
	 * 解法四：查表法
	 * 假设知道输入的s为n位数的话，可以预先存好每个数 
	 * 有多少个1，然后到时候直接查询即可。这样需要多申请 
	 * 2^n那么大的数组来保存，但是时间复杂度为O(1) 
	 * 此处n为8
	 * @param s
	 * @return
	 */
	public static int count4(int s) {
		return countTable[s];
	}
	

	public static void main(String[] args) {
//		int i=0xf7;
//		System.out.println(count1(i));
//		System.out.println(count2(i));
//		System.out.println(count3(i));
//		System.out.println(count4(i));
//		for(int i=0;i<256;i++){
//			System.out.printf("0x%x,",i);
//			if(i%16==15){
//				System.out.println();
//			}
//		}
	}
}
