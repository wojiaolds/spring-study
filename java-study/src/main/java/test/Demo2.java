package test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: lds
 * @Date: 2019/8/20 14:05
 */
public class Demo2 {
	
	public static void main ( String... argc ) {
		
		System.out.println ("Input Param");
		Scanner scan = new Scanner (System.in);
		while (scan.hasNextInt ()) {
			int cnt = scan.nextInt ();
			System.out.println ("inputArray");
			TreeSet <Integer> set = new TreeSet <> ();
			while (cnt-- > 0) {
				set.add (scan.nextInt ());
			}
			for ( Integer i : set ) {
				System.out.println (i);
			}
		}
		
	}
}
