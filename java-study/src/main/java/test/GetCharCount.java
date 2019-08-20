package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: lds
 * @Date: 2019/8/19 16:50
 */
public class GetCharCount {
	
	public static void main(String[] args) {
		String str = "aaabbbrcc";
		String reg = "^[a-z]*$";
		if (str.matches(reg)) {
			HashMap<Character, Integer> map = getCharCount(str);
		
			for (Map.Entry<Character, Integer> e : map.entrySet()) {
				System.out.println(e.getKey() + ": " + e.getValue());
			}
		}else {
			System.out.println("输入的字符不合法，不是小写字母");
		}
	}
	public static HashMap<Character,Integer> getCharCount(String str) {
		HashMap<Character,Integer> map = new HashMap<> ();
	
		char[] arr = str.toCharArray();
		for(int i = 0;i<str.length();i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], new Integer(1));
			}else {
				map.put(arr[i],map.get(arr[i])+1);
			}
			
		}

		return map;
		
	}

}
