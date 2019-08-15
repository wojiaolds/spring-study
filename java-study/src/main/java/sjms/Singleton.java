package sjms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

/**
 * <p>单例  懒汉模式</p>
 *
 * @author lds
 * @version $Id: Singleton.java , v 0.1 2019/1/4 9:40 By lds Edit  $$
 */
public class Singleton {
	
	/**
	 * 如果没有volatile关键字(可以阻止指令重排序),问题可能会出在singleton = new Singleton();
	 * 这句,用伪代码表示
	 inst = allocat()； // 分配内存
	 sSingleton = inst;      // 赋值
	 constructor(inst); // 真正执行构造函数
	 
	 可能会由于虚拟机的优化等导致赋值操作先执行,而构造函数还没完成,
	 导致其他线程访问得到singleton变量不为null,但初始化还未完成,导致程序崩溃。
	 */
	private volatile static Singleton singleton = null;
	
	private Singleton (){}
	
	private static synchronized void init(){
		if(singleton == null){
			try {
				Thread.sleep (1);
				singleton = new Singleton ();
			}catch ( Exception e ){
				System.out.println (e);
			}
		}
	}
	
	public static Singleton getInstance(){
		if (singleton == null) {
			init();
		}
		return singleton;
		
	}
	
	public static void main(String[] args) throws Exception {
		Integer loopNum = 10;
		
		Set<Object> instanceSet = new HashSet<> ();
		
		ExecutorService executor = Executors.newFixedThreadPool (10);
		
		CountDownLatch countDownLatch = new CountDownLatch(loopNum);
		
		for (int i = 0; i < loopNum; i++) {
			executor.execute(() -> {
				Singleton instance = Singleton.getInstance ();
				System.out.println (instance);
				//                instanceSet.add(obj);
				countDownLatch.countDown();
			});
		}
		executor.shutdown();
		
		System.out.println ("Main Thread wait!");
		countDownLatch.await ();
		System.out.println ("Main thread end!");
		
		
		System.out.println(instanceSet);
		
	}
	
//	public static void main(String...args) throws Exception{
//		Singleton singleton = Singleton.getInstance ();
//
//		int []a = new int[10];
//		List list = Arrays.asList (a);
//
//		list.stream ().forEach (System.out::println);
//		System.out.println (((int[])list.toArray ()[0]).length);
//
//		String []s = new String[10];
//		List list1 = Arrays.asList (s);
//		System.out.println(s.length);
//		list1.stream ().forEach (System.out::println);
//
//		Thread t = new Thread(()->pong ());
//		//start()用来启动一个线程，
//		// 当调用start方法后，
//		// 系统才会开启一个新的线程，
//		// 进而调用run()方法来执行任务，
//		// 而单独的调用run()就跟调用普通方法是一样的，
//		// 已经失去线程的特性了。因此在启动一个线程的时候一定要使用start()而不是run()。
//		t.start ();
//		t.run ();
//		System.out.print("ping");
//	}
	
	static void pong() {
		
		System.out.print("pong");
		
	}
}
