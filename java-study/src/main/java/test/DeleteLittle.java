package test;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class DeleteLittle {
    public static void main(String[] args) {
        
        String str = "asdasda";
        System.out.println(deleteLittle(str));
    }
    public static String deleteLittle(String str) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] ch = str.toCharArray();
        for(int i = 0;i<ch.length;i++) {
            if(!map.containsKey(ch[i])){
                map.put(ch[i], 1);
            }else {
                map.put(ch[i], map.get(ch[i])+1);
            }
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry<Character,Integer>::getValue));
        int cnt = list.get(0).getValue();
        Set<Character> set = new HashSet<>();
        for (Map.Entry<Character,Integer> entry:list) {
            if(entry.getValue() == cnt){
                set.add(entry.getKey());
            }
        }

        for(Character character: set){
            str = str.replaceAll(character.toString(),"");
        }
        return str;

    }

}
