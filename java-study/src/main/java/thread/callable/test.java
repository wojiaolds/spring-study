package thread.callable;

import LRU.User;
import thread.countdownlatch.CountDownLatchDemo;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @Author: lds
 * @Date: 2019/8/1 14:37
 */
public class test {
	
	public static void main(String...argv) throws Exception{
		
		ExecutorService executor = Executors.newFixedThreadPool (2);
		Future<User> future = executor.submit (new MyCallable ("wojiaolds"));
		executor.shutdown ();

		sleep(2000);
		if(!future.isDone ()){  //检查子线程是否结束
			System.out.println ("子线程还未处理完");
		}
		//获取子线程的返回值，子线程没有结束就阻塞在这里直到子线程处理完成
		User user= future.get ();
		
		System.out.print (user.getName ());
		
		
	}
}
