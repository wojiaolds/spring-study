package LRU;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * <p>使用HashMap和链表来实现LRU缓存</p>
 *
 * @author lds
 * @version $Id: LRU2.java , v 0.1 2018/12/11 15:16 By lds Edit  $$
 */
public class LRU2<K, V> {
	private final int MAX_CACHE_SIZE;
	private Entry<K, V> head;
	private Entry<K, V> tail;
	
	//其实完全可以用双向链表实现，但是这样获取数据会比较慢
	//另外用一个map来存放节点信息，这样获取数据就不需要遍历链表了
	//hashmap内部是把hash值相同的key的entry用一个链表串起来的，每次进来的都放到自己所对应的链表的最前面
	//然后每个链表的头结点是放到一个数组中的，这样查找数据的时候都是先根据key计算出hash值，再根据hash值得到对应的数组下标
	//然后根据下标取出对应的头结点，然后再去遍历链表查找数据
	//jdk8有所改动，当链表长度达到8就自动转为红黑树（平衡查找二叉树）
	
	
	private HashMap<K, Entry<K, V>> cache;
	
	public LRU2(int cacheSize) {
		MAX_CACHE_SIZE = cacheSize;
		cache = new HashMap<>();
	}
	
	public void put(K key, V value) {
		Entry<K, V> entry = getEntry(key);
		if (entry == null) {
			if (cache.size() >= MAX_CACHE_SIZE) {
				//删除尾结点
				cache.remove(tail.key);
				removeTail();
			}
			entry = new Entry<>(null,key,value,head);
			//往链表前端增加一个节点
			createToHead(entry);
			//map中存入数据
			cache.put(key, entry);
		} else {
			entry.value = value;
			//如果key存在，将key对应的节点移动到链表最前面
			moveToHead(entry);
		}
	}
	
	public V get(K key) {
		Entry<K, V> entry = getEntry(key);
		if (entry == null) {
			return null;
		}
		//将当前访问的节点移动到链表最前面
		moveToHead(entry);
		return entry.value;
	}
	
//	public void remove(K key) {
//		Entry<K, V> entry = getEntry(key);
//		if (entry != null) {
//			if (entry == head) {
//				Entry<K, V> next = head.next;
//				head.next = null;
//				head = next;
//				head.pre = null;
//			} else if (entry == tail) {
//				Entry<K, V> prev = tail.pre;
//				tail.pre = null;
//				tail = prev;
//				tail.next = null;
//			} else {
//				entry.pre.next = entry.next;
//				entry.next.pre = entry.pre;
//			}
//			cache.remove(key);
//		}
//	}
	
	private void removeTail() {
		if (tail != null) {
			Entry<K, V> prev = tail.pre;
			if (prev == null) {
				head = null;
				tail = null;
			} else {
				tail.pre = null;
				tail = prev;
				tail.next = null;
			}
		}
	}
	
	
	private void moveToHead(Entry<K, V> entry) {
		
		//如果当前更新的节点就是头结点(等价于当前节点的前一个节点为空)，直接返回
		if (entry == head) {
			return;
		}
		//当前要更新的节点的前一个节点的下一个节点指向当前要更新节点的下一个节点
		entry.pre.next = entry.next;
		
		if (entry.next != null) {
			//如果当前要更新节点的下一个节点不为空
			//就将当前节点的下一个节点的前一个节点指向当前要更新节点的前一个节点
			entry.next.pre = entry.pre;
		}else {
			//如果当前要更新节点的下一个节点为空
			//就将尾结点赋值成当期要更新节点的上一个节点
			tail = entry.pre;
			tail.next = null;
			
		}
		//当前要更新节点的下一个节点指向当前的头结点
		//当前头节点的前一个节点指向当前要更新的节点
		//当前要更新的节点前一个节点赋值为空
		//头结点赋值成当前要更新的节点
		entry.next = head;
		head.pre = entry;
		entry.pre = null;
		head = entry;
	}
	
	private void createToHead(Entry<K, V> entry) {
		Entry<K, V> h = head;
		Entry<K, V> t = tail;
		//头节点每次都赋值成当前插入的节点，
		// 尾结点一直保持不动，原来的头结点指向当前插入的节点
		head = entry;
		if(h == null)
			tail = entry;
		else
			h.pre = entry;
		
	
	}
	
	private Entry<K, V> getEntry(K key) {
		return cache.get(key);
	}
	
	private static class Entry<K, V> {
		Entry<K, V> pre;
		Entry<K, V> next;
		K key;
		V value;
		
		Entry( Entry<K, V> prev, K k,V v, Entry<K, V> next) {
			this.key = k;
			this.value = v;
			this.next = next;
			this.pre = prev;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		Entry<K, V> entry = head;
		while (entry != null) {
			stringBuilder.append(String.format("%s:%s ", entry.key, entry.value));
			entry = entry.next;
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		LRU2<Integer, Integer> lru2 = new LRU2<>(5);
		lru2.put(1, 1);
		System.out.println(lru2);
		lru2.put(2, 2);
		System.out.println(lru2);
		lru2.put(3, 3);
		System.out.println(lru2);
		lru2.get(1);
		System.out.println(lru2);
		lru2.put(4, 4);
		lru2.put(5, 5);
		lru2.put(6, 6);
		System.out.println(lru2);
		
		LinkedList linkedList = new LinkedList ();
		linkedList.push (1);
		
	}
}
