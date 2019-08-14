package thread.cyclicbarrier;

/**
 * @Author: lds
 * @Date: 2019/8/1 15:54
 */

import java.util.concurrent.*;

public class CyclicBarrierDemo {
	
	
	public static void main ( String args[] ) throws Exception {
		/**
		 * LinkedBlockingQueue的容量默认大小是Integer.Max，
		 * 在任务没有填满这个容量之前线程池大小是不会超过设定的核心线程数量2的。
		 */
		//第一个线程阻塞在那里，第二个任务进来放进了队列中（等待空闲的核心线程），
		// 第三个任务进来线程池另开了一个线程执行
		ThreadPoolExecutor executor = new ThreadPoolExecutor (1, 1,
								0L, TimeUnit.MILLISECONDS,
								new LinkedBlockingQueue<>(1));
		
		
		/**
		 * CyclicBarrier与CountDownLatch的区别
			 A、CountDownLatch的作用是允许1或N个线程等待其他线程完成执行；
				而CyclicBarrier则是允许N个线程相互等待；
			 B、CountDownLatch的计数器无法被重置；而CyclicBarrier的计数器可以被重置后使用，
				因此它被称为是循环的barrier。
		 */
		// 当所有的线程都执行到await()方法时，它们会一起返回继续自己的工作
		// 3是指barrier.await的次数，
		// barrier设置了runnable,await都执行了的时候会接着执行它的run方法
		// 然后接着执行所有await后面的任务
		CyclicBarrier barrier = new CyclicBarrier (4, new TotalTask ());
		
		BillTask worker1 = new BillTask ("111", barrier);
		BillTask worker2 = new BillTask ("222", barrier);
		BillTask worker3 = new BillTask ("333", barrier);
		

//		worker1.start ();
//		worker2.start ();
//		worker3.start ();
		
		executor.submit (worker1);
		executor.submit (worker2);
		executor.submit (worker3);
		executor.shutdown ();
		
		System.out.println ("Main Thread wait!");
		barrier.await ();
		System.out.println ("Main thread end!");
	}
	
	static class TotalTask extends Thread {
		
		@Override
		public void run () {
			
			System.out.println ("所有子任务都执行完了，就开始执行主任务了。");
		}
	}
	
	
	
	
	static class BillTask extends Thread {
		
		private String        billName;
		
		private CyclicBarrier barrier;
		
		public BillTask ( String workerName, CyclicBarrier barrier ) {
			
			this.billName = workerName;
			this.barrier = barrier;
		}
		
		@Override
		public void run () {
			
			try {
				System.out.println ("市区:" + billName + "运算开始：");
				Thread.sleep (1000L);//模仿第一次运算；
				System.out.println ("市区:" + billName + "运算完成，等待中...");
				barrier.await ();//假设一次运算不完，第二次要依赖第一次的运算结果。都到达这个节点之后后面才会继续执行；
				System.out.println ("全部都结束，市区" + billName + "才开始后面的工作。");
			} catch ( InterruptedException e ) {
				e.printStackTrace ();
			} catch ( BrokenBarrierException e ) {
				e.printStackTrace ();
			}
		}
	}
	
}
