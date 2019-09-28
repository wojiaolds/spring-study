package thread.Atomic;

import utils.DateUtil;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 这个带时间戳可以解决CAS的ABA问题
 * @Author: lds
 * @Date: 2019/8/15 16:35
 */
public class AtomicStampedReferenceTest {
	
	public static void main ( String[] args ) {
		
		
		AtomicStampedReference atomicStampedReference = new AtomicStampedReference <Integer> (0,
																							  Integer
																								  .valueOf (
																									  DateUtil
																										  .getFullTime (
																											  DateUtil.DATE_FMT_17)));
		System.out.println (atomicStampedReference.getStamp ());
		ExecutorService executorService = Executors.newFixedThreadPool (5);
		for ( int i = 0 ; i < 10 ; i++ ) {
			executorService.submit (() -> {
				for ( int j = 0 ; j < 100 ; j++ ) {
					Integer value;
					int stamp;
					do {
						value = ( Integer ) atomicStampedReference.getReference ();
						stamp = atomicStampedReference.getStamp ();
					}while (!atomicStampedReference.compareAndSet (value, value + 1, stamp,
																  stamp + 1));
					
				}
			});
		}
		executorService.shutdown ();
		while(Thread.activeCount()>2)  //保证前面的线程都执行完
			Thread.yield();
		System.out.println (
			atomicStampedReference.getReference () + "  " + atomicStampedReference.getStamp ());
		
		List list = Collections.synchronizedList(new ArrayList<Integer> ());
		list.add (1);
		list.contains (3);
		
	}
}
