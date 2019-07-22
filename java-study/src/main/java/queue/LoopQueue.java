package queue;

import java.util.Arrays;

/**
 * <p>循环队列的顺序存储结构实现</p>
 *
 * @author lds
 * @version $Id: LoopQueue.java , v 0.1 2018/12/21 10:25 By lds Edit  $$
 */
public class LoopQueue<E> {
	
	private Object[] data = null;
	private int maxSize;
	private int head;
	private int tail;
	private int size=0; //队列当前长度
	
	private final static int DEFAULT_SIZE = 5;
	
	public LoopQueue(){
		this(DEFAULT_SIZE);
	}
	
	public LoopQueue(int initSize){
		if(initSize < 0){
			throw new RuntimeException("初始化大小不能小于0：" + initSize);
		}
		data = new Object[initSize];
		maxSize = initSize;
		head = tail = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	// 判空
	public int size() {
		return size ;
	}
	
	
	public void addLast(E e){
		if(size == maxSize){
			throw new RuntimeException("队列已满，无法插入新的元素！");
		}
		data[tail] = e;
		tail = (tail+1)%maxSize;
		size++;
	}
	
	public E removeFirst(){
		if(isEmpty ()){
			throw new RuntimeException("空队列异常！");
		}
		E e = (E)data[head];
		data[head] = null;
		head = (head+1)%maxSize;
		size -- ;
		return e;
		
	}
	
	//清空循环队列
	public void clear(){
		Arrays.fill(data, null);
		size = 0;
		head = 0;
		tail = 0;
	}



	
}
