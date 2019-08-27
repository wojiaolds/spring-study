package test;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.*;
import java.util.Map.Entry;

/**
 * @Author: lds
 * @Date: 2019/8/21 9:09
 */
public class LetterCount {
	
	public static void main(String[] args) {
		String str = "asdasda251.,[]";
		countLittle(str);
	}
	public static void countLittle(String str) {
		Map<Character,Integer> map = new HashMap<> ();
		char[] ch = str.toCharArray();
		for(int i = 0;i<ch.length;i++) {
			if(ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >= 'A' && ch[i] <= 'Z') {
				if (!map.containsKey (ch[i])) {
					map.put (ch[i], 1);
				} else {
					map.put (ch[i], map.get (ch[i]) + 1);
				}
			}
		}
		
		List<Entry<Character,Integer>> list = new ArrayList<> (map.entrySet());
//		Collections.sort(list,
//						 Comparator.comparingInt(Entry<Character,Integer>::getValue).reversed ());
//		Collections.sort(list,
//						 Comparator.comparingInt(Entry<Character,Integer>::getValue).reversed ().thenComparing (Entry<Character,Integer>::getKey));
		Collections.sort(list,(o1,o2)->{
			if((o2.getValue ()-o1.getValue ())>0)
				return 1;
			else if((o1.getValue ()-o2.getValue ()) > 0)
				return -1;
			else{
				if((o1.getKey ()-o2.getKey ()) > 0)
					return 1;
				else
					return -1;
			}
		});
		
		for (Map.Entry<Character,Integer> entry:list) {
			System.out.print (entry.getKey ()+":"+entry.getValue ()+";");
		}

		
	}
}
