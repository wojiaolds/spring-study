import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @Author: lds
 * @Date: 2019/7/18 16:02
 */
public class IntegerTest {
	
	public static void main(String...argv){
		System.out.println(123);
		
		Integer a = new Integer (1);
		Integer b = new Integer (1);
		System.out.println (a==b);
		
		//Integer
		Integer c = Integer.valueOf (-128);
		Integer d = Integer.valueOf (-128);
		System.out.println (c==d);
		
		Integer c1 = Integer.valueOf (-129);
		Integer d1 = Integer.valueOf (-129);
		System.out.println (c1==d1);
		
		Integer c2 = Integer.valueOf (127);
		Integer d2 = Integer.valueOf (127);
		System.out.println (c2==d2);
		
		Integer c3 = Integer.valueOf (128);
		Integer d3 = Integer.valueOf (128);
		System.out.println (c3==d3);
		
		Double e = Double.valueOf (4);
		Float f = Float.valueOf ("3");
		
		
	}
}
