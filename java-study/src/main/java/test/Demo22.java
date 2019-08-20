package test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: lds
 * @Date: 2019/8/20 18:01
 */
public class Demo22 {
	
	public static void main ( String[] args ) {
		
		int[][] arr = { { 4, 3, 32, 5 }, { 1, 2, 3, 4 }, { 9, 6, 5, 4 } };
		int[][] arr2 = arrRandomReverse (arr);
		for ( int i = 0 ; i < arr2.length ; i++ ) {
			for ( int j = 0 ; j < arr2[i].length ; j++ ) {
				System.out.print (arr2[i][j] + " ");
			}
			System.out.println ();
		}
		
		for ( int i = 0 ; i < arr2.length ; i++ ) {
			
			System.out.println (Arrays.toString (arr2[i]));
		}
	}
	
	public static int[][] arrRandomReverse ( int[][] arr ) {
		
		int[][] resArr = new int[arr.length][];
		for ( int i = 0 ; i < arr.length ; i++ ) {
			resArr[arr.length - 1 - i] = arr[i];
		}
		Random r = new Random ();
		for ( int i = 0 ; i < resArr.length ; i++ ) {
			for ( int j = 0 ; j < resArr[i].length ; j++ ) {
				int p = r.nextInt (resArr[i].length);
				int tmp;
				tmp = resArr[i][j];
				resArr[i][j] = resArr[i][p];
				resArr[i][p] = tmp;
			}
		}
		return resArr;
		
	}
	
}
