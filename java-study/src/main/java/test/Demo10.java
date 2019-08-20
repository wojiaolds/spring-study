package test;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/20 17:20
 */
public class Demo10 {
	public static void main ( String[] args ) {
		
		Scanner sc = new Scanner (System.in);
		int num = sc.nextInt ();
		sc.nextLine ();
		ArrayList<String> list = new ArrayList <> (num);
		while(num-- > 0){
			list.add (sc.nextLine ());
		}
		Collections.sort (list);
		list.forEach (System.out::println);
		
	}
}
