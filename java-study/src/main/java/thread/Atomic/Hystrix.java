package thread.Atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

/**
 * @Author: lds
 * @Date: 2019/8/1 17:13
 */
public class Hystrix implements Callable <String> {
	
	private AtomicLong atomicLong = new AtomicLong (0);
	
	private Long limit;
	
	public Hystrix ( Long limit ) {
		
		this.limit = limit;
	}
	
	public void invokeMethod () {
	
	}
	
	public static void main ( String... argv ) {
		
		Hystrix hystrix = new Hystrix (10L);
		ExecutorService executorService = Executors.newFixedThreadPool (1000);
		List <Future> list = new ArrayList <> ();
		for ( int i = 0 ; i < 1000 ; i++ ) {
			Future <String> future = executorService.submit (hystrix);
			list.add (future);
		}
		list.forEach (( f ) -> {
			
			try {
				System.out.println (f.get ());
			}catch ( Exception e ){
				System.out.println (e);
			}
			
		});
		executorService.shutdown ();
	}
	
	@Override
	public String call () throws Exception {
		
		try {
			long currentThreadCnt = atomicLong.incrementAndGet ();
		
			if (currentThreadCnt > limit) {
				return ( "服务繁忙 请重新请求！！！" );
			} else {
				sleep (1);
				return ( "请求成功！！！" );
			}
			
		} catch ( Exception e ) {
			System.out.println (e);
			return null;
		} finally {
			atomicLong.decrementAndGet ();
		}
		
	}
}
