package test;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/19 14:51
 */
public class CountAvg {

	public static void main(String...argc){
		
		Scanner scanner = new Scanner (System.in);
		System.out.println ("请输入元素个数：");
		
		int len = scanner.nextInt ();
		ArrayList<Integer> array = new ArrayList <> (len);
		int sum = 0;
		System.out.println ("请输入每个元素：");
		for(int i = 0; i< len ; i++){
			int tmp = scanner.nextInt ();
			array.add (tmp);
			sum += tmp;
		}
		array.forEach (System.out::print);
		System.out.println (sum);
		System.out.println (sum/len);
		int avg = sum/len;
		int gCount=0,lCount=0;
		for ( Integer a:array ) {
			if(a > avg) gCount++;
			if(a < avg) lCount++;
		}
		
	
		System.out.println (gCount);
		System.out.println (lCount);
	
		
	}
}
