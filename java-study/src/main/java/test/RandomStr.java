package test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: lds
 * @Date: 2019/8/19 15:56
 */
public class RandomStr {
	public static void main(String[] args) {
		Set<String> setStr = new TreeSet<> ();
		for(int i = 0 ;i<50;i++) {
			setStr.add(randomStr(new Random ().nextInt(7) + 4));
		}
		
		int count = 1;
		for(String i:setStr){
			
			System.out.print(String.format ("%-11s",i));
			if(count%4 == 0) {
				System.out.println();
			}
			count++;
		}
	}
	/**
	 * @param strLen:随机字符串的长度
	 */
	public static String randomStr(int strLen) {
		char[] str = new char[strLen];
		int i = 0;
		while(i<strLen) {
			int f = (int)(Math.random()*3);
//			System.out.println ("f: "+f);
			if(f == 0) {
				str[i] = (char)('a' + Math.random()*26);
			}else if(f == 1) {
				str[i] = (char)('A' + Math.random()*26);
			}else {
				str[i] = (char)('0' + Math.random()*10);
			}
			i++;
		}
		
		return new String(str);
	}

}
