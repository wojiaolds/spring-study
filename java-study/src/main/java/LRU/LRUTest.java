package LRU;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <p>注释</p>
 *
 * @author lds
 * @version $Id: LRUTest.java , v 0.1 2018/12/11 13:30 By lds Edit  $$
 */
public class LRUTest<K, V> {
	private final int MAX_CACHE_SIZE;
	private final float DEFAULT_LOAD_FACTORY = 0.75f;
	
	LinkedHashMap<K, V> map;
	
	public LRUTest(int cacheSize) {
		
		MAX_CACHE_SIZE = cacheSize;
		int capacity = (int)Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTORY) + 1;
        /*
         * 第三个参数设置为true，代表linkedlist按访问顺序排序，可作为LRU缓存
         * 第三个参数设置为false，代表按插入顺序排序，可作为FIFO缓存
         */
		map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTORY, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > MAX_CACHE_SIZE;
			}
		};
	}
	
	public synchronized void put(K key, V value) {
		map.put(key, value);
	}
	
	public synchronized V get(K key) {
		return map.get(key);
	}
	
	public synchronized void remove(K key) {
		map.remove(key);
	}
	
	public synchronized Set<Entry<K, V>> getAll() {
		return map.entrySet();
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<K, V> entry : map.entrySet()) {
			stringBuilder.append(String.format("%s: %s  ", entry.getKey(), entry.getValue()));
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		LRUTest lruTest = new LRUTest<Integer, Integer>(5);
		lruTest.put(1, 1);
		lruTest.put(2, 2);
		lruTest.put(3, 3);
		System.out.println(lruTest);
		lruTest.get(1);
		System.out.println(lruTest);
		lruTest.put(4, 4);
		lruTest.put(5, 5);
		lruTest.put(6, 6);
		System.out.println(lruTest);
	}
}
