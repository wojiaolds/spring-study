package test;

import map.HashMapTest;

import java.util.HashMap;
import java.util.Map;

public class TrunNumber {
    static HashMap<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("yi", "1");
        hashMap.put("er", "2");
        hashMap.put("san", "3");
        hashMap.put("si", "4");
        hashMap.put("wu", "5");
        hashMap.put("liu", "6");
        hashMap.put("qi", "7");
        hashMap.put("ba", "8");
        hashMap.put("jiu", "9");
    }

    public static void main(String[] args) {


        String str = "yiersansan";
        System.out.println(str);
        System.out.println(trunNumber(str));



    }

    public static String trunNumber(String data) {

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            data = data.replaceAll(entry.getKey(), entry.getValue());
        }

        return data;

    }
}
