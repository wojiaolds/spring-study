package sjms;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: lds
 * @Date: 2019/8/13 16:34
 */
public enum EnumSingleton {
	
	INSTANCE("1");
	
	EnumSingleton ( String str) {
	}
	
	
	
	public static void main(String[] args) throws Exception {
		Integer loopNum = 10;
		
		ExecutorService executor = Executors.newFixedThreadPool (10);
		
		CountDownLatch countDownLatch = new CountDownLatch(loopNum);
		
		for (int i = 0; i < loopNum; i++) {
			executor.execute(() -> {
				EnumSingleton instance = EnumSingleton.INSTANCE;
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
