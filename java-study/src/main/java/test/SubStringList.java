package test;

import java.util.HashSet;
import java.util.LinkedHashSet;
//查找一个字符串的子字符串集
public class SubStringList {

    public static void main(String[] args) {

        HashSet<String> set = new LinkedHashSet<>();
        String str = "dcewf";

        for(int i = 1;i < str.length();i++){
            for(int j= 0; j< str.length()-i+1;j++){
                set.add(str.substring(j,j+i));
            }
        }
        set.forEach(System.out::println);
    }
}
