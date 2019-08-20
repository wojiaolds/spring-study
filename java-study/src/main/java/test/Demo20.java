package test;

import java.util.Arrays;

/**
 * 数组的循环移位
 * @Author: lds
 * @Date: 2019/8/20 11:11
 */
public class Demo20 {
	public static void main(String[] args) {
		String[] data = {"a","b","c","d"};
		System.out.println(Arrays.toString(getChildren(data, 2)));
		
	}
	public static String[] getChildren(String[] data,int index){
		String[] resData = new String[data.length];
		for(int i = 0;i<resData.length;i++) {
			if(i<index) resData[i] = data[resData.length-index+i];
			else resData[i] = data[i-index];
		}
		return resData;
		
	}
	
}
