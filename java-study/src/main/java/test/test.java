package test;

import java.util.*;

public class test {


    public static HashMap<Character,Integer> getCharCount(String str) {
        HashMap<Character,Integer> map = new HashMap<> ();

        char[] arr = str.toCharArray();
        for(int i = 0;i<str.length();i++) {
            if(arr[i] >= 'a' && arr[i]<='z' || arr[i] >='A' && arr[i]<='Z' ) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], new Integer(1));
                } else {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
            }

        }

        return map;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character,Integer> map = getCharCount(str);
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,Comparator.comparingInt(Map.Entry<Character,Integer>::getValue).reversed());
//        Collections.sort(list, (o1,o2)-> o2.getValue() - o1.getValue());
        for (Map.Entry<Character,Integer> entry:list) {
            System.out.print(entry.getKey()+":"+entry.getValue()+";");
        }


    }
}
