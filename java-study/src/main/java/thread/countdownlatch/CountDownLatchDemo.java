package thread.countdownlatch;

/**
 * @Author: lds
 * @Date: 2019/8/1 15:45
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
	
	public static void main ( String args[] ) throws Exception {
		//3是指执行countDown的次数，执行一次就减1
		final CountDownLatch latch = new CountDownLatch (3);
		ThreadPoolExecutor executor = new ThreadPoolExecutor (3, 5,
															  1L, TimeUnit.MILLISECONDS,
															  new LinkedBlockingQueue<> (1));
		
		String[] str= new String[]{"Jack 程序员","Rose 程序员","Json 程序员"};
		for ( int i = 0 ; i < 3 ; i++ ) {
			executor.execute (new Worker (str[i], latch));
		}
		
		System.out.println ("Main Thread wait!");
		System.out.println (latch.getCount ());
		latch.await ();
		System.out.println (latch.getCount ());
		System.out.println ("Main thread end!");
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			executor.execute (new Worker (str[i], latch));
		}
		latch.await (); //计数器不会重置，线程不会被挂起
		System.out.println ("Main thread end!");
		System.out.println (latch.getCount ());
		executor.shutdown ();
	}
	
	static class Worker extends Thread {
		
		private String workerName;
		
		private CountDownLatch latch;
		
		Worker ( String workerName, CountDownLatch latch ) {
			
			this.workerName = workerName;
			this.latch = latch;
		}
		
		@Override
		public void run () {
			
			try {
				System.out.println ("Worker:" + workerName + " is begin.");
				sleep (1000L);
				System.out.println ("Worker:" + workerName + " is end.");
			} catch ( InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace ();
			}finally {
				latch.countDown ();
			}
			
		}
	}
}
