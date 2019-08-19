package test;

import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/19 17:10
 */
public class LastWordLong {
	
	public static void main ( String[] args ) {
		
		Scanner scanner = new Scanner (System.in);
		String str = scanner.nextLine ();
		boolean flg = true;
		int cnt = 0;
		for ( int i = str.length ()-1 ; i >= 0  ; i-- ) {
			if(flg && str.charAt (i) == ' '){
				continue;
			}else if(str.charAt (i) != ' '){
				flg = false;
				cnt++;
			}else {
				break;
			}
		}
		System.out.println (cnt);
		scanner.close ();
		
		
		
	}
}
