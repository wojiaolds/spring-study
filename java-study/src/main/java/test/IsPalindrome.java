package test;

import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/19 15:48
 */
public class IsPalindrome {
	public static void main(String[] args) {
		System.out.print("请输入一个回文数字：");
		Scanner console  = new Scanner(System.in);
		String numStr = console.nextLine();
		if(isPalindrome(numStr)) {
			System.out.println(numStr+"是回文数字！");
		}else{
			System.out.println(numStr+"不是回文数字！");
		}
		
	}
	
	public static boolean isPalindrome(String str){
		boolean result = false;
		for(int i = 0 ;i<=str.length()/2-1;i++) {
			if(str.charAt(i) == str.charAt(str.length()-1-i)) {
				result = true;
			}else {
				result = false;
			}
		}
		
		return result;
	}

}
