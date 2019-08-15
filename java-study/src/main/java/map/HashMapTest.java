package map;

import sun.misc.Unsafe;

import java.util.HashMap;

/**
 * @Author: lds
 * @Date: 2019/8/15 9:15
 */
public class HashMapTest {
	
	public static void main(String...argc){
		
		HashMap<String,Integer> hashMap = new HashMap <> ();
		hashMap.put ("1",1);
		hashMap.put (null,2);
		hashMap.put ("3",3);
		hashMap.put ("4",null);
		for ( String s : hashMap.keySet () ) {
			System.out.println (s);
		}
		for ( Integer integer : hashMap.values () ) {
			System.out.println (integer);
		}
	
	}
}
