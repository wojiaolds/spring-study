

import stack.LinkStack;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * <p>两个栈实现队列</p>
 *
 * @author lds
 * @version $Id: StacksToQueue.java , v 0.1 2018/12/20 13:02 By lds Edit  $$
 */
public class StacksToQueue<T> {

//	Stack<T> stack1 =new Stack();
//	Stack<T> stack2 =new Stack();
	
	LinkStack<T> stack1 =new LinkStack();
	LinkStack<T> stack2 =new LinkStack();
	
	public void addLast(T x)//添加元素到队尾   --进队---
	{
		stack1.push(x);
		
	}
	public T removeFirst()//删除对首      --出队---    不需是队不为空才能删除呀~~~~
	{
		if( size()!=0)//队列不为空
		{
			if(stack2.isEmpty())//若stack2为空，则把stack1全部加入stack2
				stack1ToStack2();
			return  stack2.pop();
			
		}
		else
		{
			System.out.println("队列已经为空，不能执行从队头出队");
			throw new EmptyStackException ();
		}
		
	}
	
	public void stack1ToStack2()//把stack1全部放入stack2
	{
		while(!stack1.isEmpty())
			stack2.push(stack1.pop());
	}
	
	public int size()//队列size()
	{
		return  stack1.size()+stack2.size();//两个都为空队列才是空
	}
	
	public boolean isEmpty(){
		return  stack1.size()+stack2.size() == 0;
	}
	
	public static void main(String[] args) throws Exception
	{
		//先进先出
		StacksToQueue<Integer>  q=new StacksToQueue ();
		q.addLast(1);
		q.addLast(2);
		q.addLast(3);
		q.addLast(4);
		System.out.println(q.removeFirst ());
		System.out.println(q.removeFirst());
		q.addLast(5);
		System.out.println(q.removeFirst());
		System.out.println(q.removeFirst());
		System.out.println(q.removeFirst());
		System.out.println(q.removeFirst());
	}
	
}
