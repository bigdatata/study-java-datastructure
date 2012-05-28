import org.junit.Test;


public class TestUtil {

	@Test
	public void test(){
		
		int d=0;
		int n=16;
		while((n>>=1)>0){
			d++;
		}
		System.out.println(d);
	}
}
