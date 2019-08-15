package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: lds
 * @Date: 2019/8/14 14:20
 */
public class HashSetTest {
	
	public static void  main(String...argc){
		//无序的，不可重复的  LinkedHashSet是按插入顺序
		HashSet<Integer> hashSet = new HashSet<>();
		
		hashSet.add (4);
		hashSet.add (null);
		hashSet.add (5);
		hashSet.add (3);
		hashSet.add (34);
		hashSet.add (23);
		hashSet.add (56);
		hashSet.add (67);
		hashSet.add (4);
		hashSet.add (5);
		hashSet.add (null);
		
		Iterator iterator = hashSet.iterator ();
		while (iterator.hasNext ()){
			System.out.println (iterator.next ());
		}
		
		TreeSet<Integer> treeSet = new TreeSet <Integer> ();
		
	}
}
