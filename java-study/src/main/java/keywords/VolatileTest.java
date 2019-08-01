package keywords;

import com.sun.deploy.util.SyncFileAccess;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: lds
 * @Date: 2019/8/1 9:08
 */
public class VolatileTest extends Thread {
	
	public static boolean flg = true;
	public static int cnt = 5;
	
	@Override
	public void run () {
		
		int i = 0;
		try {
			while (i++ < 100) {
				if (!flg) {
					break;
				}
				System.out.println (cnt);
				sleep (3);
				System.out.println (cnt);
			}
//			System.out.println (flg);
		} catch ( Exception e ){
			System.out.println (e);
		}
		
		System.out.println (currentThread ().getName () + " 结束 " + i);
		
	}
	
	public static void main ( String... argv ) throws Exception {
		VolatileTest[] volatileTest = new VolatileTest[5];
		for ( int i = 0 ; i < volatileTest.length ; i++ ) {
			volatileTest[i] = new VolatileTest ();
		}
		for ( VolatileTest t : volatileTest ) {
			t.start ();
			System.out.println (t + "启动");
		}
		sleep (1);
		flg = false;
		cnt = 6;
		for (int i = 0; i < volatileTest.length; i++)
			// 100个线程都执行完后继续
			volatileTest[i].join();
		
		System.out.println (flg);
	}
	
}
