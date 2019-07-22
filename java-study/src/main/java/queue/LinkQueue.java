package queue;


/**
 * <p>注释</p>
 *
 * @author lds
 * @version $Id: LinkQueue.java , v 0.1 2018/12/21 10:36 By lds Edit  $$
 */
public class LinkQueue<E> {
	
	private class Node<E>{
		private E data;
		private Node<E> next;
		public Node(E e,Node next){
			this.data = e;
			this.next = next;
			
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	
	public LinkQueue(){
		head = tail = null;
	}
	
	public int size(){
		return size;
	}
	
	public  boolean isEmpty(){
		return size == 0;
	}
	
	public void addLast(E e){
		if(isEmpty ()){
			head = tail = new Node <> (e,null);
		}else{
			Node<E> node = new Node <> (e,null);
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public E removeFirst(){
		if(isEmpty ()){
			throw new RuntimeException("空队列异常！");
		}else{
			E e = head.data;
			Node node = head;
			head = node.next;
			node.next = null;
			size --;
			return e;
			
		}
	}
	
	public String toString(){
		Node node = head;
		StringBuilder stringBuilder = new StringBuilder ();
		stringBuilder.append ("[");
		while(node!=tail) {
			
			stringBuilder.append (node.data);
			stringBuilder.append (",");
			node = node.next;
			
		}
		stringBuilder.append (node.data);
		stringBuilder.append ("]");
		return stringBuilder.toString ();
	}
	
	public static void main(String...args){
		LinkQueue<Integer> linkQueue = new LinkQueue <> ();
		linkQueue.addLast (1);
		linkQueue.addLast (2);
		linkQueue.addLast (3);
		linkQueue.addLast (3);
		System.out.println (linkQueue);
		System.out.println (linkQueue.removeFirst ());
		System.out.println (linkQueue.removeFirst ());
		System.out.println (linkQueue);
	}
}
