package queue;

/**
 * <p>队列的顺序存储结构实现</p>
 *
 * @author lds
 * @version $Id: Queue.java , v 0.1 2018/12/20 15:02 By lds Edit  $$
 */
public class Queue<E> {
	
	private Object[] data = null;
	private int maxSize;
	private int head;
	private int tail;
	
	private final static int DEFAULT_SIZE = 5;
	
	public Queue(){
		this(DEFAULT_SIZE);
	}
	
	public Queue(int initSize){
		if(initSize < 0){
			throw new RuntimeException("初始化大小不能小于0：" + initSize);
		}
		data = new Object[initSize];
		maxSize = initSize;
		head = 0;
		tail = -1;
	}
	
	public boolean isEmpty(){
		return tail == -1;
	}
	
	public int size(){
		return tail-head+1;
	}
	
	public void addLast(E e){
		if(tail == maxSize-1){ //扩容
			Object[] tmp = data;
			maxSize *= 2;
			data = new Object[maxSize];
			System.arraycopy (tmp,0,data,0,tail+1);
			System.out.println ("----扩容完毕----");
		}
		data[++tail] = e;
	}
	
	public E removeFirst(){
		if(isEmpty ()){
			throw new RuntimeException("空队列异常！");
		}
		E e = (E)data[head];
		data[head++] = null;
		return e;
	
	}
	
	public String toString(){
		
		if(size () == 0){return "[]";}
		StringBuilder stringBuilder = new StringBuilder ("[");
		int tmp = head;
		while(head <= tail){
			stringBuilder.append (data[head++]);
			if(head <= tail) stringBuilder.append(",");
		}
		stringBuilder.append ("]");
		head = tmp;
		
		return stringBuilder.toString ();
	}
	
	


	
	public static void main(String ...argv){
		
		Queue<Integer> queue = new Queue <> ();
		System.out.println (queue.maxSize);
		
		queue.addLast (1);
		queue.addLast (2);
		queue.addLast (3);
		
		System.out.println (queue);
		
		System.out.println (queue.removeFirst ());
		System.out.println (queue);
		
		queue.addLast (4);
		System.out.println (queue.removeFirst ());
		System.out.println (queue);
		queue.addLast (4);
		queue.addLast (4);
		queue.addLast (4);
		queue.addLast (4);
		System.out.println (queue);
		
		
		
		
		
	}
	
}
