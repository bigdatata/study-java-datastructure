package analysis.in.java.chapter10;

public class DynamicProgramming {

	/**
	 * recursive 
	 * Compute Fibonacci numbers ad described in Chapter1
	 * @param n
	 * @return
	 */
	public static int fib(int n){
		if(n<=1){
			return 1;
		}
		return fib(n-1)+fib(n-2);
	}
	
	/**
	 * Compute Fibonacci numbers ad described in Chapter1
	 */
	public static int fibonacci(int n){
		if(n<=1){
			return 1;
		}
		int nextToLast=1;
		int last=1;
		int answer=1;
		for(int k=2;k<=n;k++){
			answer=last+nextToLast;
			nextToLast=last;
			last=answer;
		}
		return answer;
	}
	
	/**
	 * @param n
	 * @return
	 */
	public static double eval(int n){
		if(n==0){
			return 1;
		}
		double sum=0;
		for(int i=0;i<n;i++){
			sum+=eval(i);
		}
		return 2*sum/n+n;
	}
	
	public static double eval2(int n){
		double[] c=new double[n+1];
		c[0]=1;
		for(int i=1;i<=n;i++){
			double sum=0;
			for(int j = 0; j < i; j++){
				sum+=c[j];
			}
			c[i]=2*sum/i+i;
		}
		return c[n];
	}
	/**
	 * C(N)= 2/N*(C(0)+C(1)+......+C(N-1))+N
	 * @param n
	 * @return
	 */
	public static double eval3(int n){
		if(n==0){
			return 1;
		}
		double sum=1;
		double answer=1;
		for(int i=1;i<=n;i++){
			answer=sum*2/i+i;
			sum+=answer;
		}
		return answer;
	}
	/**
	 * Compute optimal ordering of matrix multiplication
	 * c contains the number of columns for each of the n numbers.
	 * c[0] is the number of rows in matrix 1.
	 * the minimum number of multiplication is left in m[1][n].
	 * Actual ordering is computed via another procedure using lastChange.
	 * m and lastChange are indexed stated at 1,instead of 0.
	 * Note: Entries below main diagonals of m and lastChange are meaningless and uninitialized
	 */
	public static void optMatrix(int[] c, long [][] m, int [][] lastChange){
		int n=c.length-1;
		for(int left=1;left<=n;left++){
			m[left][left]=0;
		}
		for(int k=1;k<n;k++){//k is right-left
			for(int left=1;left<=n-k;left++){
				//for each position
				int right=left+k;
				m[left][right]=Long.MAX_VALUE;
				for(int i=left;i<right;i++){
					long thisCost=m[left][i]+m[i][right]+c[left-1]*c[i]*c[right];
					if(thisCost<m[left][right]){
						m[left][right]=thisCost;
						lastChange[left][right]=i;
					}
				}
			}
		}
	}
	
	public static void optSearchTree(String[] words, double [] weights, 
			double [][] m, int [][] lastChange){
		int n=words.length;
		for(int left=0;left<n;left++){
			m[left][left]=0;
		}
		
		for(int k=0;k<n;k++){//k is right-left
			for(int left=0;left<n-k;left++){
				//for each position
				int right=left+k;
				m[left][right]=Double.MAX_VALUE;
				for(int i=left;i<=right;i++){
					double thisCost;
					if(i==left&&i==right){
						thisCost=0;
					}else if(i==left){
						thisCost=m[i+1][right];
					}else if(i==right){
						thisCost=m[left][i-1];
					}else{
						thisCost=m[left][i-1]+m[i+1][right];
					}
					for(int j=left;j<=right;j++){
						thisCost+=weights[j];
					}
					if(thisCost<m[left][right]){
						m[left][right]=thisCost;
						lastChange[left][right]=i;
					}
				}
			}
		}
	}

	/**
	 * Compute all-shortest paths.
	 * a[][] contains the adjacency matrix with a[i][i] presumed to be zero.
	 * d[] contains the values of the shortest path.
	 * Vertices are numbered starting at 0;all arrays
	 * have equal dimension.A negative cycle exists if
	 * d[i][i] is set to a negative value.
	 * Actual path can be computed using path[][]
	 * NOT_A_VERTEX is -1
	 */
	public static void allPairs(int [][] a, int [][] d, int [][] path){
		final int NOT_A_VERTEX=-1;
		int n=a.length;
		//Initialize d and path
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				d[i][j]=a[i][j];
				path[i][j]=NOT_A_VERTEX;
			}
		}
		for(int k=0;k<n;k++){
			//Consider each vertex as an intermediate
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					int temp=a[i][k]+a[k][j];
					if(temp<a[i][j]){
						a[i][j]=temp;
						path[i][j]=k;
					}
				}
			}
		}
	}
}
