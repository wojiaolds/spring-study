package test;

import java.util.Scanner;

/**
 * 求质数因子
 * @Author: lds
 * @Date: 2019/8/20 15:29
 */
public class Demo4 {
	
	public static void main(String[] args) {
		Scanner str = new Scanner (System.in);
		long num = str.nextLong();
		String result = getResult(num);
		System.out.println(result);
	}
	
	public static String getResult(long num){
		int pum = 2;
		String result = "";
		while(num!=1){
			while(num%pum==0){
				num=num/pum;
				result = result + pum+" ";
			}
			pum++;
		}
		return result;
	}
}
