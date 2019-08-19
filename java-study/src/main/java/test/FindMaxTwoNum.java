package test;

import java.util.Arrays;

/**
 * @Author: lds
 * @Date: 2019/8/19 15:30
 */
public class FindMaxTwoNum {
	public static void main(String[] args) {
		
		int[] array = { 1, 2, 5, 9, 84, 3, 2 };
		System.out.println ("数组" + Arrays.toString (array) + "里面最大的2个数为：");
		findMaxTwoNum (array);
	}

	public static void findMaxTwoNum(int[] array) {
		int[] result = {0,0};
		for(int i = 0 ;i<array.length;i++) {
			if(i == 2) break;
			result[i] = array[i];
			for(int j = i+1;j<array.length;j++) {
				if(array[j] != result[0] && result[i]<array[j]) {
					result[i] = array[j];
				}
			}
		
		}
		
		System.out.println(result[0]+"、"+result[1]);
	}

}
