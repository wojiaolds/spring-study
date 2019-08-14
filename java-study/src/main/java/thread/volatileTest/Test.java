package thread.volatileTest;

/**
 * @Author: lds
 * @Date: 2019/8/13 15:06
 */
public class Test {
	public volatile int inc = 0;
	
	public void increase() {
		inc++;
	}
	
	public static void main(String[] args) {
		final Test test = new Test();
		for(int i=0;i<10;i++){
			new Thread(()->{
					for(int j=0;j<1000;j++)
						test.increase();
				}).start();
		}
		/**
		 *
		 * IntelliJ Idea执行用户的代码使用的是反射的方式，
		 * 与此同时会创建一个Monitor Ctrl-Break的线程用于监控的目的。
		 * 所以主线程main+监控线层，最后会剩余两个线程。
		 相同的代码，用java命令执行就没有问题。
		 所以将Thread.activeCount的判断值改为Thread.activeCount > 2即可。
		 */
		while(Thread.activeCount()>2) { //保证前面的线程都执行完
			Thread.currentThread().getThreadGroup().list();
			System.out.println("活跃线程的数量1:"+Thread.activeCount());
			Thread.yield ();
		}
		System.out.println(test.inc);
	}
}
