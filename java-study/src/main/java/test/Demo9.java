package test;

import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/20 17:09
 */
public class Demo9 {
	
	public static void main ( String[] args ) {
		
		Scanner sc = new Scanner (System.in);
		String str = sc.nextLine ();
		String[] strArr = str.split (" ");
		for(int i=strArr.length-1;i>=0;i--){
			System.out.print (strArr[i]+" ");
		}
		
		
	}
}

