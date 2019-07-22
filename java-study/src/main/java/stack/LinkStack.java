package stack;

/**
 * <p>注释</p>
 *
 * @author lds
 * @version $Id: LinkStack.java , v 0.1 2018/12/20 14:25 By lds Edit  $$
 */
public class LinkStack<E> {
	
	private class Node<E>{
		private E data;
		private Node<E> next;
		Node(E e,Node next){
			this.data = e;
			this.next = next;
			
		}
	}
	
	private Node<E> top; //队列首元素
	private int size;
	
	public LinkStack(){
		top = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0 ;
	}
	
	public void push(E e){
		top = new Node <E> (e,top);
		size ++;
	}
	
	public E pop(){
		if(size == 0){
			throw new RuntimeException("栈为空！");
		}
		Node<E> tmp = top;
		E e = tmp.data;
		top = top.next;
		tmp.next = null;
//		tmp =null;
		size --;
		return e;
	}
	
	public E peek(){
		if(size == 0){
			throw new RuntimeException("栈为空！");
		}
		return top.data;
	}
	
	public String toString(){
		if(size () == 0) return "[]";
		StringBuilder stringBuilder = new StringBuilder ("[");
		Node<E> tmp = top;
		while(tmp != null){
			stringBuilder.append (tmp.data);
			tmp = tmp.next;
			if(tmp != null) {
				stringBuilder.append (",");
			}
			
		}
		stringBuilder.append ("]");
		return stringBuilder.toString ();
	}
	
	public static void main(String[] agrs){
		LinkStack<Integer> linkStack = new LinkStack<>();
		System.out.println (linkStack.size ());
		System.out.println (linkStack.isEmpty ());
		linkStack.push (1);
		linkStack.push (2);
		System.out.println (linkStack);
		System.out.println (linkStack.pop ());
		System.out.println (linkStack.size ());
		System.out.println (linkStack.isEmpty ());
		linkStack.push (3);
		System.out.println (linkStack);
		System.out.println (linkStack.pop ());
		System.out.println (linkStack.pop ());
		System.out.println (linkStack);
		
		linkStack.push (3);
		linkStack.push (3);
		linkStack.push (3);
		System.out.println (linkStack.peek ());
		System.out.println (linkStack);
		
		
	}


}
