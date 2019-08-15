package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: lds
 * @Date: 2019/8/15 10:35
 */
public class UnsafeTest {
	
	private double a;
	private int f = 5;
	private volatile int b;
	private volatile char c;
	private volatile short d;
	private volatile double e;
	
	
	private static  Unsafe unsafe;
	static {
		try {
			@SuppressWarnings ( "ALL" ) Field f = Unsafe.class.getDeclaredField ("theUnsafe");
			f.setAccessible (true);
			unsafe = ( Unsafe ) f.get (null);
		}catch ( Exception e ){
			System.out.println (e);
		}
	}
	
	
	public static void main(String...argc) throws Exception{
		try {
			System.out.println (
				"double  " + unsafe.objectFieldOffset (UnsafeTest.class.getDeclaredField ("a")));
			System.out.println ("volatile int  " + unsafe.objectFieldOffset (UnsafeTest.class.getDeclaredField ("b")));
			System.out.println ("volatile char  " + unsafe.objectFieldOffset (UnsafeTest.class.getDeclaredField ("c")));
			System.out.println ("volatile short  " + unsafe.objectFieldOffset (UnsafeTest.class.getDeclaredField ("d")));
			System.out.println ("volatile double " + unsafe.objectFieldOffset (UnsafeTest.class.getDeclaredField ("e")));
			System.out.println ("int  " + unsafe.objectFieldOffset (UnsafeTest.class.getDeclaredField ("f")));
			System.out.println (unsafe.staticFieldOffset (UnsafeTest.class.getDeclaredField ("unsafe")));
			
			UnsafeTest unsafeTest = ( UnsafeTest ) unsafe.allocateInstance (UnsafeTest.class);
			Field unsafeAField = unsafeTest.getClass ().getDeclaredField ("f");
			System.out.println (unsafe.getInt (unsafeTest, unsafe.objectFieldOffset (unsafeAField)));
			unsafe.putInt (unsafeTest, unsafe.objectFieldOffset (unsafeAField), 40);
			System.out.println (unsafe.getInt (unsafeTest, unsafe.objectFieldOffset (unsafeAField)));
			System.out.println (unsafe.getInt (unsafeTest, unsafe.objectFieldOffset (unsafeAField)) & 8 );
			System.out.println (unsafe.getInt (unsafeTest, 0L) & 3); //无锁标志
			synchronized (unsafeTest){
				System.out.println (unsafe.getInt (unsafeTest, 0L) & 3); //轻量级锁标志
			}
			
			ExecutorService executorService = Executors.newFixedThreadPool (5);
			for ( int i = 0; i < 5; i++ ) {
				executorService.submit (() -> {
					synchronized (unsafeTest) {
						//存在竞争的时候会膨胀为重量级锁
						System.out.println (unsafe.getInt (unsafeTest, 0L)&3);
						
					}
				});
			}
			executorService.shutdown ();
			
		}catch ( Exception e ){
			System.out.println(e);
		}
		
		
	}
}
