package test;

import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/20 15:15
 */
public class Demo3 {
	
	public static void main(String...argc){
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			
			System.out.println(Integer.parseInt (str.substring (2),16));
		}
	}
}
