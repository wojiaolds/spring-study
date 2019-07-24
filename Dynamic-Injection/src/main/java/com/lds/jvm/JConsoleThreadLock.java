package com.lds.jvm;


/**
 * 线程死锁演示
 * 这段代码开了200个线程去分别计算1+2以及2+1的值，其实for循环是可省略的，
 * 两个线程也可能会导致死锁，不过那样概率太小，需要尝试运行很多次才能看到效果。
 * 一般的话，带for循环的版本最多运行2～3次就会遇到线程死锁，程序无法结束。
 * 造成死锁的原因是Integer.valueOf（）方法基于减少对象创建次数和节省内存的考虑，
 * [-128，127]之间的数字会被缓存[3]，
 * 当valueOf（）方法传入参数在这个范围之内，将直接返回缓存中的对象。
 * 也就是说，代码中调用了200次Integer.valueOf（）方法一共就只返回了两个不同的对象。
 * 假如在某个线程的两个synchronized块之间发生了一次线程切换，
 * 那就会出现线程A等着被线程B持有的Integer.valueOf（1），
 * 线程B又等着被线程A持有的Integer.valueOf（2），结果出现大家都跑不下去的情景

 * @Author: lds
 * @Date: 2019/7/18 15:43
 */
public class JConsoleThreadLock {
	
	/**
	 * 线程死锁等待演示
	 */
	static class SynAddRunalbe implements Runnable {
		int a, b;
		public SynAddRunalbe(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public void run() {
			System.out.print (Thread.currentThread ().getId ());
			System.out.print("  start  ");
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.print(a + b);
				}
			}
			System.out.print("  ");
			System.out.print (Thread.currentThread ().getId ());
			System.out.println("  end");
		}
	}
	

	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			new Thread(new SynAddRunalbe(1, 2)).start();
			new Thread(new SynAddRunalbe(2, 1)).start();
		}
	}
	
}
