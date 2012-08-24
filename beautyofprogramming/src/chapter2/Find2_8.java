package chapter2;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 任意给定一个正整数N，求一个最小的正整数M(M>1)，使得N*M的十进制表示形式里只含有1和0.
 *
 */
public class Find2_8 {

	/**
	 * 判断一个正整数是否是由1和0组成
	 */
	private static boolean hasOnlyOneAndZero(long number){
		assert(number>0);
		while(number!=0){
			if(number%10>1){
				return false;
			}
			number/=10;
		}
		return true;
	}
	/**
	 * http://blog.csdn.net/wens07/article/details/6706141
	 * 方法一：
	 * 给定N，令M从2开始，枚举M的值直到遇到一个M使得N*M的十进制表示中只有1和0.
	 */
	public static long find1(int n){
		long product=0;
		for(long m=2;;m++){
			product=n*m;
			if(hasOnlyOneAndZero(product)){
				System.out.printf("N=%d,M=%d,M*N=%d",n,m,product);
				return m;
			}
		}
	}
	/**
	 * 方法二：
	 * 求出10的次方序列模N的余数序列并找出循环节。然后搜索这个余数序列，
	 * 搜索的目的就是要在这个余数序列中找到一些数出来让它们的和是N的倍数。
	 * 例如N=13，这个序列就是1,10,9,12,3,4然后不断循环。很明显有1+12=13，
	 * 而1是10的0次方，12是10的3次方，所以这个数就是1000+1=1001，M就是1001/13=77。
	 */
	public static long find2(int n){
		int[] remainders=new int[n+1];
		remainders[0]=1;
		int i=1;
		for(;i<n;i++){
			remainders[i]=remainders[i-1]*10%n;
			if(remainders[i]==1){
				break;
			}
		}
		/**
		 * 找到一些数出来让它们的和是N的倍数。
		 */
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 方法三：
	 * 因为N*M的取值就是1,10,11,100,101,110,111,......所以直接在这个空间搜索，
	 * 这是对方法一的改进。搜索这个序列直到找到一个能被N整除的数，它就是N*M，然后可计算出M。
	 */
	public static long find3(int n){ 
	    Queue<Long> queue=new LinkedBlockingQueue<Long>();
	    queue.add((long)1);
	    while(!queue.isEmpty()){
	    	long t=queue.poll();
	    	if(t%n==0){
	    		System.out.printf("N=%d,M=%d,M*N=%d\n",n,t/n,t);
	    		return t/n;
	    	}
	    	queue.add(t * 10); 
	    	queue.add(t * 10 + 1);
	    	
	    }
		return 0;
	}
	/**
	 * 方法四：对方法三的改进。将方法三的搜索空间按模N余数分类，
	 * 使得搜索时间和空间都由原来的指数级降到了O(N)。
	 * 改进的原理：假设当前正在搜索由0，1组成的K位十进制数，
	 * 这样的K位十进制数共有2^k个。假设其中有两个数X、Y，它们模N同余，
	 * 那么在搜索由0、1组成的K+1位十进制数时，X和Y会被扩展出四个数
	 * ：10X, 10X+1, 10Y, 10Y+1。因为X和Y同余（同余完全可以看作相等），
	 * 所以10X与10Y同余，10X+1与10Y+1同余。
	 * 也就是说由Y扩展出来的子树和由X扩展产生出来的子树产生完全相同的余数，
	 * 如果X比Y小，那么Y肯定不是满足要求的最小的数，所以Y这棵子树可以被剪掉。
	 * 这样，2^K个数按照模N余数分类，每类中只保留最小的那个数以供扩展。
	 * 原来在这一层需要搜索2^K个数，现在只需要搜索O(N)个数。
	 */
	public static long find4(int n){ 
		boolean[] remainders=new boolean[n];
		Queue<Long> queue=new LinkedBlockingQueue<Long>();
		queue.add((long)1);
		while(!queue.isEmpty()){
			int len=queue.size();
			for(int i=0;i<n;i++){
				remainders[i]=false;
			}
			while(len-->0){
				long t=queue.poll();
				long yu=t%n;
				if(yu==0){
					System.out.printf("N=%d,M=%d,M*N=%d\n",n,t/n,t);
					return t/n;
				}else if(!remainders[(int)yu]){
					remainders[(int)yu]=true;
					queue.add(t * 10); 
					queue.add(t * 10 + 1);
				}
			}
	    	
	    }
		return 0;
	}
	
	/**
	 * 书上的解法
	 * @param n
	 * @return
	 */
	public static long find5(int n){ 
		boolean[] isVisited=new boolean[n];
		for(int i=0;i<n;i++){
			isVisited[i]=false;
		}
		boolean[] needUpdate=new boolean[n];
		long[] numbers=new long[n];
		int temp=63;
		for(long j=1;temp-->0;j=j*10){
			
			long yu=j%n;
			int index=(int)yu;
			index=(index+n)%n;
			
			for(int i=0;i<n;i++){
				needUpdate[i]=false;
			}
			for(int k=1;k<n;k++){
				if(isVisited[k]){
					int newIndex=(k+index)%n;
					if(!isVisited[newIndex]){
						needUpdate[newIndex]=true;
						numbers[newIndex]=j+numbers[k];
					}
					if(newIndex==0){
						System.out.printf("N=%d,M=%d,M*N=%d\n",n,numbers[0]/n,numbers[0]);
						return numbers[0]/n;
					}
				}
			}
			for(int i=0;i<n;i++){
				if(needUpdate[i]){
					isVisited[i]=true;
				}
			}
			if(!isVisited[index]){
				isVisited[index]=true;
				numbers[index]=j;
			}
		}
		return 0;
	}
	
	public static void main(String[] args){
		//find1(99); 时间太长 
		find3(99);
		find4(99);
		find5(99);
	}
}
