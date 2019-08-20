import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * <p>两个队列实现栈</p>
 *
 * @author lds
 * @version $Id: QueuesToStack.java , v 0.1 2018/12/20 13:05 By lds Edit  $$
 */
public class QueuesToStack<T> {
	
//	LinkedList<T> queue1 =new LinkedList();
//	LinkedList<T> queue2 =new LinkedList();

	StacksToQueue<T> queue1 =new StacksToQueue();
	StacksToQueue<T> queue2 =new StacksToQueue();
	
	public void push(T value)//入栈
	{
		queue1.addLast(value);
		
	}


	public T pop()//出栈     必须是非空的栈才能出栈啊
	{
		if(sSize()!=0)//栈不为空
		{
			//移动一个队的n-1个到另一个中
			if(!queue1.isEmpty())//q1 空
			{
				putN_1ToAnthor();
				
				return queue1.removeFirst();
			}
			else  //q2 空
			{
				putN_1ToAnthor();
				return queue2.removeFirst();
			}
		}
		else
		{
			System.out.println("栈已经为空啦，不能出栈");
			throw new NoSuchElementException ();
		}
		
	}
	
	public int sSize()
	{
		return queue1.size()+queue2.size();
	}
	
	public void putN_1ToAnthor()//从非空中出队n-1个到另一个队列   因为队列总是一空一非空
	{
		if(!queue1.isEmpty())
		{
			while(queue1.size()>1)
			{
				queue2.addLast(queue1.removeFirst());
			}
		}
		else if(!queue2.isEmpty())
		{
			while(queue2.size()>1)
			{
				queue1.addLast(queue2.removeFirst());
			}
		}
	}
	public static void main(String[] args)
	{
		//后进先出
		QueuesToStack<Integer> stack=new QueuesToStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(5);
		stack.push(6);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		LinkedList<Integer> linkedList = new LinkedList();
		linkedList.addLast (1);
		linkedList.add (1);
		
		
		
	}
	
}
