package test;

import java.util.*;
import java.util.Map.Entry;

/**
 * Description: 十万个数据,找出重复次数最多的十个数据并打印
 * @Author: lds
 * @Date: 2019/8/21 9:48
 */
public class NumberRepetMost {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis ();
		
		final int NUM = 100000;//十万个
		int t = 0;
		Random random = new Random ();
		HashMap <Integer, Integer> hashMap = new HashMap <Integer, Integer> (NUM);//key:数据 value:出现次数
		while (t < NUM) {
			Integer i = random.nextInt (1000);
			if (hashMap.containsKey (i)) {  //如果存在,出现次数+1,不存在出现次数为1
				hashMap.put (i, hashMap.get (i) + 1);
			} else {
				hashMap.put (i, 1);
			}
			t++;
		}
		
		//用来存储最终的十个结果
		PriorityQueue <Entry <Integer, Integer>> priorityQueue = new PriorityQueue <> (
			10, Comparator.comparingInt (Entry::getValue));
		
		//通过hashmap的entrySet进行遍历.
		Iterator <Map.Entry <Integer, Integer>> iterator = hashMap.entrySet ().iterator ();
		//先放10个
		for ( int i = 0 ; i < 10 ; i++ ) {
			priorityQueue.add (iterator.next ());
		}
		
		//再放其他的
		while (iterator.hasNext ()) {
			Map.Entry <Integer, Integer> curEntry = iterator.next (); //当前遍历的.
			Map.Entry <Integer, Integer> topEntry = priorityQueue.peek (); //获得队列中最小的那一个.
			
			if (curEntry.getValue () > topEntry.getValue ()) {
				priorityQueue.remove (topEntry);
				priorityQueue.add (curEntry);
			}
		}
		
		//打印结果
		Iterator <Entry <Integer, Integer>> iterator2 = priorityQueue.iterator ();
		while (iterator2.hasNext ()) {
			Map.Entry <Integer, Integer> entry = iterator2.next ();
			System.out.println (entry.getKey () + ":出现了" + entry.getValue () + "次");
		}
		
		long end = System.currentTimeMillis ();
		
		System.out.println ("花费时间："+(end-start));
		
	}

}
