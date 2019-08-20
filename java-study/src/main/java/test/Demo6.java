package test;

import java.util.*;

/**
 * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * @Author: lds
 * @Date: 2019/8/20 15:47
 */
public class Demo6 {
	
	public static void main(String[] args) {
		Scanner str = new Scanner(System.in);
		SortedMap<Integer,Integer> map = new TreeMap<>();
		int n = Integer.parseInt(str.nextLine());
		for (int i = 0;i<n;i++){
			String[] mid = str.nextLine().split("\\s+");
			addPare(map,mid);
		}
		System.out.println(mapToString(map));
	}
	
	private static String mapToString(SortedMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for(SortedMap.Entry<Integer,Integer>e:map.entrySet()){
			builder.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
		}
		return builder.toString();
	}
	
	private static void addPare(SortedMap<Integer, Integer> map, String[] mid) {
		// TODO Auto-generated method stub
		int key = Integer.parseInt(mid[0]);
		int value = Integer.parseInt(mid[1]);
		if(map.containsKey(key)){
			map.put(key, map.get(key) + value);
		}else{
			map.put(key, value);
		}
	}
}
