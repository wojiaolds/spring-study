package thread.Atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lds
 * @Date: 2019/8/1 15:21
 */
public class AtomicIntegerTest {
	
	public static AtomicInteger count = new AtomicInteger (0);
	public volatile static int cnt = 0;
	public volatile static int cnt1 = 0;
	public volatile static int cnt2 = 0;
	public static int cnt3 = 0;
	public static Object lock = new Object ();
	public static ReentrantLock reentrantLock = new ReentrantLock (true);
	public static void main ( String[] args ) throws InterruptedException {
		
		for ( int i = 0 ; i < 100 ; i++ ) {
			new Thread (() -> {
				for ( int j = 0 ; j < 1000 ; j++ ) {
					count.getAndIncrement ();
				}
			}).start ();
		}
		
		for ( int i = 0 ; i < 100 ; i++ ) {
			new Thread (() -> {
				for ( int j = 0 ; j < 1000 ; j++ ) {
					synchronized (lock) {
						cnt++;
					}
				}
			}).start ();
		}
		
		for ( int i = 0 ; i < 100 ; i++ ) {
			new Thread (() -> {
				for ( int j = 0 ; j < 1000 ; j++ ) {
						cnt1++;
				}
			}).start ();
		}
		
		for ( int i = 0 ; i < 100 ; i++ ) {
			new Thread (() -> {
				for ( int j = 0 ; j < 1000 ; j++ ) {
					reentrantLock.lock ();
					cnt2++;
					reentrantLock.unlock ();
				}
			}).start ();
		}
		
		for ( int i = 0 ; i < 100 ; i++ ) {
			new Thread (() -> {
				for ( int j = 0 ; j < 1000 ; j++ ) {
					cnt3++;
				}
			}).start ();
		}
		
		while(Thread.activeCount()>2)  //保证前面的线程都执行完
			Thread.yield();
		System.out.println ("AtomicInteger count: " + count);
		System.out.println ("cnt: " + cnt);
		System.out.println ("cnt1: " + cnt1);
		System.out.println ("cnt2: " + cnt2);
		System.out.println ("cnt3: " + cnt3);
	}
	

	
}
