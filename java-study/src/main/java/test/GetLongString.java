package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetLongString {

    public static void main(String[] args) {
        System.out.println("请输入一句话：");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        System.out.println("最长的单词为："+getLongString(str.trim()));
        console.close();
    }
    public static String getLongString(String str) {
        String[] wordStr = str.split("[ ,.0-9]");
        System.out.println(Arrays.toString(wordStr));
        int sum = 0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0;i<wordStr.length;i++) {
            if(sum<wordStr[i].length()) {
                sum = wordStr[i].length();
                result.add(wordStr[i]);
            }else if(sum==wordStr[i].length()){
                result.remove(result.size()-1);
                result.add(wordStr[i]);
            }
        }
        result.forEach(System.out::println);

        return result.get(result.size()-1);

    }

}
