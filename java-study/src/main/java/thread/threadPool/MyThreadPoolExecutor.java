package thread.threadPool;

import java.util.concurrent.*;

/**
 * @Author: lds
 * @Date: 2019/8/14 14:52
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {
	
	public MyThreadPoolExecutor (
		int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
		BlockingQueue <Runnable> workQueue ) {
		
		super (corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	public MyThreadPoolExecutor (
		int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
		BlockingQueue <Runnable> workQueue, ThreadFactory threadFactory ) {
		
		super (corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
	}
	
	public MyThreadPoolExecutor (
		int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
		BlockingQueue <Runnable> workQueue, RejectedExecutionHandler handler ) {
		
		super (corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
	}
	
	public MyThreadPoolExecutor (
		int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
		BlockingQueue <Runnable> workQueue, ThreadFactory threadFactory,
		RejectedExecutionHandler handler ) {
		
		super (corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory,
			   handler);
	}
	
	@Override
	protected void beforeExecute ( Thread t, Runnable r ) {
		System.out.println (this.getActiveCount ()+" "+
							this.getCompletedTaskCount ()+" "+
							this.getTaskCount ());
		System.out.println ("thread run start");
		System.out.println (t.getThreadGroup ()+" "+t.getName ()+" "+t.getId ());
		
	}
	
	@Override
	protected void afterExecute ( Runnable r, Throwable t ) {
		System.out.println ("thread run end");
		System.out.println (this.getActiveCount ()+" "+
							this.getCompletedTaskCount ()+" "+
							this.getTaskCount ());
	
		
	
	}
}
