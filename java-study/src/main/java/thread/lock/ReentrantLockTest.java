package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lds
 * @Date: 2019/8/15 14:03
 */
public class ReentrantLockTest {
	
	public static void main(String...argc){
		
		ReentrantLock reentrantLock = new ReentrantLock ();
		reentrantLock.tryLock ();
		reentrantLock.lock ();
		reentrantLock.unlock ();
	}
}
