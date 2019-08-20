package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，
 * 输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整
 * @Author: lds
 * @Date: 2019/8/20 15:40
 */
public class Demo5 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		double d=scanner.nextDouble();
		String str = String.valueOf (d);
		char[] ch = str.toCharArray ();
		System.out.println (Arrays.toString (ch));
		System.out.println(getReturn(d));
	}
	
	public static int getReturn(double d) {
		int i=(int)d;
		return  (d-i)>=0.5?i+1:i;
	}
}
