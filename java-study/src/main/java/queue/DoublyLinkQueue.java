package queue;

/**
 * @Author: lds
 * @Date: 2019/7/22 15:07
 */
public class DoublyLinkQueue<E> {
	
	class Node<E>{
		E data;
		Node<E> pre;
		Node<E> next;
		Node(E data,Node pre,Node next){
			this.data = data;
			this.pre = pre;
			this.next = next;
		}
		Node(){}
	}
	
	private Node<E> first;
	private Node<E> last;
	
	public DoublyLinkQueue(){
		first = last = null;
	}
	
	public void insertHead( E e ) {
		
		if (first == null) {
			first = last = new Node<> (e,null,null);
		}else{
			Node<E> node = new Node<> (e,null,first);
			first.pre = node;
			first = node;
		}
	}
	
	public void insertTail(E e){
		if (last == null) {
			first = last = new Node<> (e,null,null);
		}else{
			Node<E> node = new Node<> (e,last,null);
			last.next = node;
			last = node;
		}
	}
	
	public String queryFromFirst(){
		if (first == null) return "[]";
		StringBuilder stringBuilder = new StringBuilder ("[");
		Node tmp = first;
		while(tmp != last){
			stringBuilder.append (tmp.data);
			stringBuilder.append (",");
			tmp = tmp.next;
		}
		stringBuilder.append (last.data);
		stringBuilder.append ("]");
		
		
		return stringBuilder.toString ();
		
	}
	
	public String queryFromTail(){
		if (last == null) return "[]";
		StringBuilder stringBuilder = new StringBuilder ("[");
		Node tmp = last;
		while(tmp != first){
			stringBuilder.append (tmp.data);
			stringBuilder.append (",");
			tmp = tmp.pre;
		}
		stringBuilder.append (first.data);
		stringBuilder.append ("]");
		
		
		return stringBuilder.toString ();
		
	}
	
	public static void main(String ...argv){
		DoublyLinkQueue<Integer> doublyLinkQueue = new DoublyLinkQueue <> ();
		doublyLinkQueue.insertHead (1);
		doublyLinkQueue.insertTail (2);
		doublyLinkQueue.insertHead (3);
		doublyLinkQueue.insertTail (4);
		
		
		System.out.println (doublyLinkQueue.queryFromFirst ());
		System.out.println (doublyLinkQueue.queryFromTail ());
	}
	
}
