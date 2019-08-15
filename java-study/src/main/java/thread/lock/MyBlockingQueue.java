package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 循环阻塞队列
 * @Author: lds
 * @Date: 2019/8/15 18:22
 */
public class MyBlockingQueue<T> {
	
	private T[] mItems;
	
	// 同步锁
	private final Lock      mLock     = new ReentrantLock ();
	// 队列满时的条件
	private       Condition mNotFull  = mLock.newCondition();
	// 队列为空时条件
	private       Condition mNotEmpty = mLock.newCondition();
	
	private int mCount = 0;
	private int mHeadIdx = 0;
	private int mTailIdx = 0;
	
	//默认队列大小
	private static final int DEFAULT_QUEUE_SIZE = 10;
	
	public MyBlockingQueue() {
		this(DEFAULT_QUEUE_SIZE);
	}
	
	public MyBlockingQueue(int size) {
		mItems = (T[]) new Object[size];
	}
	
	// 放入元素
	public void put(T item) throws InterruptedException {
		// 获取读写锁
		mLock.lock();
		try {
			// 此处会进行阻塞,直到有元素取出
			while (mCount == getCapacity()) {
				// 挂起,并释放锁,条件满足时,重新获取锁
				mNotFull.await();
			}
			mItems[mTailIdx] = item;
			// 填满元素
			if (++mTailIdx == getCapacity()) {
				mTailIdx = 0;
			}
			++mCount;
			// 对阻塞住的take()进行唤醒
			mNotEmpty.signalAll();
		} finally {
			mLock.unlock();
		}
	}
	
	// 取出元素
	public T take() throws InterruptedException {
		mLock.lock();
		try {
			while (mCount == 0) {
				// 挂起,并释放锁,条件满足时,重新获取锁
				mNotEmpty.await();
			}
			T item = mItems[mHeadIdx];
			mItems[mHeadIdx] = null; // for GC
			if (++mHeadIdx == getCapacity()) {
				mHeadIdx = 0;
			}
			--mCount;
			mNotFull.signalAll();
			return item;
		} finally {
			mLock.unlock();
		}
	}
	
	public int getCapacity() {
		return mItems.length;
	}
	
	public static void main ( String[] args ) {
		MyBlockingQueue<String> sQueue = new MyBlockingQueue<>();
		new Thread(() -> {
			try {
				// 阻塞5秒
				Thread.sleep(5000);
				sQueue.put("Hello");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		// 从阻塞队列中取值
		try {
			String item = sQueue.take();
			System.out.println(item);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
}
