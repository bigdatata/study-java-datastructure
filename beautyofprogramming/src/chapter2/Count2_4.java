package chapter2;

public class Count2_4 {

	public static int countOneInAInteger(int number){
		int count=0;
		while(number>0){
			if((number%10)==1){
				count++;
			}
			number/=10;
		}
		return count;
	}
	public static long countOneFromOneToAInteger(int number){
		long count=0;
		for(int i=1;i<=number;i++){
			count+=countOneInAInteger(i);
		}
		return count;
	}

	/**
	 * 假设N=abcde，这里a、b、c、d、e分别是十进制数N的各个位数上的数字。如果要计算百位上出现1的次数，它将会受到三个因素的影响：百位上的数字
	 * ，百位以下(低位)的数字，百位(更高位)以上的数字。
	 * 如果百位上的数字为0，则可以知道，百位上可能出现1的次数由更高位决定，比如12013，则可以知道百位出现1的情况可能是100~199，1
	 * 100~1 199，2 100~2 199，…，11 100~11
	 * 199，一共有1200个。也就是由更高位数字（12）决定，并且等于更高位数字（12）*当前位数（100）。
	 * 如果百位上的数字为1，则可以知道，百位上可能出现1的次数不仅受更高位影响
	 * ，还受低位影响，也就是由更高位和低位共同决定。例如对于12113，受更高位影响，百位出现1的情况是100~199，1 100~1 199，2
	 * 100~2 199，…，11 100~11
	 * 199，一共有1200个，和上面第一种情况一样，等于更高位数字（12）*当前位数（100）。它还受低位影响，百位出现1的情况是12 100~12
	 * 113，一共114个，等于低位数字（113）+1。 如果百位上数字大于1（即为2~9），则百位上可能出现1的次数也仅由更高位决定，比如12
	 * 213，则百位出现1的可能性为100~199，1 100~1 199，2 100~2 199，…，11 100~11 199，12 100~12
	 * 199，一共有1300个，并且等于更高位数字+1（12+1）*当前位数（100）。
	 * 通过上面的归纳和总结，我们可以写出如下的更高效算法来计算f(N)：
	 * ‍其算法思路是：通过对数字进行有规律的总结，发现从1到N，中出现的所有的1的总数。可以从N这个数总结出来的。
	 * 那么出现1的总数应该等于，个位上出现1的次数+十位上出现1的次数+百位上出现1的次数+。。。。。。 所以对于一个数abcde，取百位上的c来计算，
	 * 假若c是"1",那么百位上1的个数是由他的高位和低位来决定的。等于ab*100+cde+1; 假若c是"0",那么百位上1的个数是ab*100；
	 * 假如c是大于1，那么 百位上1的个数是（ab+1）*100；
	 * 
	 * @param number
	 * @return
	 */
	public static long countOneFromOneToAInteger2(int number){
		return countOneFromOneToABaseNumber(number,10);
	}
	public static long countOneFromOneToABinary(int number){
		return countOneFromOneToABaseNumber(number,2);
	}
	/**
	 * 
	 * @param number
	 * @param base 进制
	 * @return
	 */
	public static long countOneFromOneToABaseNumber(int number,int base)
	{
		long count=0;
		/**
		 * factor 表示当前是那位1,base,base^2,base^3....分别代表0位，1位，2位，3位，....
		 * lowerNumber 由number的低于factor位组成的数
		 * currentNumber factor位的数字
		 * higherNumber 由number的高于factor位组成的数
		 */
		int factor=1;
		int lowerNumber=0;
		int currentNumber=0;
		int higherNumber=0;
		while(number/factor!=0){
			lowerNumber=number%factor;
			currentNumber=number/factor%base;
			higherNumber=number/factor/base;
			switch(currentNumber){
			case 0:
				count+=higherNumber*factor;
				break;
			case 1:
				count+=higherNumber*factor+lowerNumber+1;
				break;
			/**
			 * 对于二进制只有0,1故下面代码不会执行也不会影响结果
			 */
			default:
				count+=(higherNumber+1)*factor;
				break;		
			}
			factor*=base;
		}
		//System.out.println(Integer.toBinaryString(number));
		return count;
	}
	
	public static void main(String[] args){
		System.out.println(countOneFromOneToAInteger(112));
		System.out.println(countOneFromOneToAInteger2(112));
		System.out.println(countOneFromOneToABinary(11));
		
	}
}
