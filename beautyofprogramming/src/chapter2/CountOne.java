package chapter2;

public class CountOne {

	/**
	 * �ⷨһ��ֱ�ӳ�2 ��s����2������Ϊ1��count��1��
	 * ʱ�临�Ӷ�ΪO(logv) vΪs�Ķ�����λ��
	 * 
	 * @param s
	 * @return s��һ������
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
	 * �ⷨ����ʹ��λ���� ��sʹ��λ���㣬��s��0x01��λ�룬
	 * Ϊ1 ��count��1 ʱ�临�Ӷ�ΪO(logv)��vΪs�Ķ�����λ��
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
	 * �ⷨ����ֻ����1�ĸ���
	 * �����s=15=1111, 
	 * s=s&(s-1)=1111&1110=1110,result=1; 
	 * s=s&(s-1)=1110&1101=1100,result=2; 
	 * s=s&(s-1)=1100&1011=1000,result=3; 
	 * s=s&(s-1)=1000&0111=0000,result=4; 
	 * ʱ�临�Ӷ�O(M)��MΪs��1�ĸ���
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
	 * Ԥ����Ľ����
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
	 * �ⷨ�ģ����
	 * ����֪�������sΪnλ���Ļ�������Ԥ�ȴ��ÿ���� 
	 * �ж��ٸ�1��Ȼ��ʱ��ֱ�Ӳ�ѯ���ɡ�������Ҫ������ 
	 * 2^n��ô������������棬����ʱ�临�Ӷ�ΪO(1) 
	 * �˴�nΪ8
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
