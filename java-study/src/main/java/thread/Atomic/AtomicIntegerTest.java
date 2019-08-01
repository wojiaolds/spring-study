package thread.Atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lds
 * @Date: 2019/8/1 15:21
 */
public class AtomicIntegerTest {
	
	public static AtomicInteger count = new AtomicInteger (0);
	
	public static void main ( String[] args ) throws InterruptedException {
		
		for ( int i = 0 ; i < 100 ; i++ ) {
			new Thread (() -> {
				for ( int j = 0 ; j < 100 ; j++ ) {
					count.getAndIncrement ();
				}
			}).start ();
		}
		Thread.sleep (1000);
		System.out.println ("AtomicInteger count: " + count);
	}
	

	
}
