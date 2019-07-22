package stack;



import java.util.HashSet;

/**
 * <p>基于数组实现的顺序栈</p>
 *
 * @author lds
 * @version $Id: Stack.java , v 0.1 2018/12/20 14:14 By lds Edit  $$
 */
public class Stack<E> {

	
	private Object[] data = null;
	private int maxSzie;
	private int top = -1; //数组中最后一个元素的索引值
	private final static int DEFAULT_SIZE = 5;
	
	public Stack(){
		this(DEFAULT_SIZE);
	}
	
	public Stack(int initSize){
		if(initSize < 0){
			throw new RuntimeException("初始化大小不能小于0：" + initSize);
		}
		maxSzie = initSize;
		data = new Object[initSize];
	}
	
	public boolean isEmpty(){
		return top == -1 ? true : false;
	}
	
	public void push(E e){
		if(top == maxSzie -1){ //数组满了就扩容
			Object[] tmp = data;
			maxSzie *= 2;
			data = new Object[maxSzie]; //元数据引用重新指向另一个素组空间
			System.arraycopy(tmp, 0, data, 0, top+1);
			System.out.println ("-----扩容完毕-----");
		}
		data[++top] = e;
	}
	
	//出栈
	public E pop(){
		if(top == -1){
			throw new RuntimeException("栈为空！");
		}
		
		return ( E ) data[top--];
	
		
	}
	//获取栈顶
	public E peek(){
		if(top == -1){
			throw new RuntimeException("栈为空！");
		}
		return (E)data[top];
	}
	
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder ();
		stringBuilder.append ("[");
		int i=top;
		if(top == -1){
			return "[]";
		}
		while (top > 0){
			stringBuilder.append (pop());
			stringBuilder.append (",");
		}
		if(top == 0){
			stringBuilder.append (pop());
			stringBuilder.append ("]");
		}
		top = i;
		
		
		return stringBuilder.toString ();
		
	}
	
	public static void main(String...args){
//		System.out.println (args.length);
		Stack<Integer> stack = new Stack<>();
		stack.push (1);
		stack.push (2);
		stack.push (3);
		stack.push (4);
		stack.push (5);
		stack.push (6);
		stack.push (7);
		stack.push (8);
		System.out.println (stack.maxSzie);
		System.out.println (stack.top);
		System.out.println (stack);

		
		HashSet<String> set = new HashSet<> (); //语句(1)
		System.out.println(set.add("abc" )); //语句(2)
		
		Stack<Integer> stack1 = new Stack<>();
		System.out.println (stack1);
		
		System.out.println (stack);
		System.out.println (stack.pop ());
		System.out.println (stack.top);
		
		
		
	}
	
}
