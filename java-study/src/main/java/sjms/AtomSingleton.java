package sjms;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;

/**
 * @Author: lds
 * @Date: 2019/8/13 16:06
 */
public class AtomSingleton {
	
	/**
	 * 通过CAS设置value。这保证了：当某线程池通过CAS函数(如compareAndSet函数)
	 * 设置value时，它的操作是原子的，即线程在操作value时不会被中断。CAS是一种无阻塞的锁,
	 * 采用不断比较设值的方式来避免并发问题,不会有锁的等待和上下文切换问题,性能消耗较小
	 */
	private static final AtomicReference<AtomSingleton> INSTANCE = new AtomicReference<AtomSingleton>();
	private AtomSingleton (){}
	public static  AtomSingleton getInstance() {
		for (;;) {
			try {
				AtomSingleton current = INSTANCE.get ();
				if (current != null) {
					return current;
				}
//				sleep (1);
				current = new AtomSingleton ();
				if (INSTANCE.compareAndSet (null, current)) {
					return current;
				}
			}catch ( Exception e ){
				System.out.println (e);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Integer loopNum = 10;
		
		ExecutorService executor = Executors.newFixedThreadPool (10);
		
		CountDownLatch countDownLatch = new CountDownLatch(loopNum);
		
		for (int i = 0; i < loopNum; i++) {
			executor.execute(() -> {
				AtomSingleton instance = AtomSingleton.getInstance ();
				System.out.println (instance);
				countDownLatch.countDown();
			});
		}
		executor.shutdown();
		
		System.out.println ("Main Thread wait!");
		countDownLatch.await ();
		System.out.println ("Main thread end!");
		
	}
	
}
