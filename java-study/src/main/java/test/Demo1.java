package test;

import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/20 13:48
 */
public class Demo1 {
	
	public static void main ( String... argc ) {
		System.out.println (String.format ("%-4s","3").replace(' ','0'));
		Scanner scan = new Scanner (System.in);
		String str = scan.nextLine ();
		
		char c = scan.nextLine ().charAt (0);
		int cnt = 0;
		char[] arr = str.toCharArray ();
		for ( char a : arr ) {
			System.out.println (toLowerCase (c));
			System.out.println (toLowerCase (a));
			if (toLowerCase (c) == toLowerCase (a)) {
				cnt++;
			}
		}
		System.out.println (cnt);
	}
	
	public static char toLowerCase ( char ch ) {
		
		if (ch >= 'A' && ch <= 'Z') {
			return ( char ) ( ch + 32 );
		} else {
			return ch;
		}
	}
}
