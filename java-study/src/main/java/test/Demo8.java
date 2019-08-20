package test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/20 16:49
 */
public class Demo8 {
	public static void main(String...argc){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		HashSet<Character> set = new HashSet <> ();
		char[] chars= str.toCharArray ();
		for(char c: chars){
			set.add (c);
		}
		System.out.println (set.size ());
		
	}
}
