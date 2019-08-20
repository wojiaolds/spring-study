package test;

import java.util.Scanner;

/**
 * @Author: lds
 * @Date: 2019/8/20 16:19
 */
public class Demo7 {
	
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			String s=scanner.nextLine();
			int len=s.length();
			
			int []arr1=new int[10];
			for(int i=len-1;i>=0;i--){
				if(arr1[s.charAt(i)-48]==0){
					System.out.print(s.charAt(i)-48);
					arr1[s.charAt(i)-48]++;
				}
			}
			
			char[] ch = new char[10];
			for(int i = len-1;i>=0;i--){
				if(ch[s.charAt(i)-48] == s.charAt(i)) continue;
				System.out.print(s.charAt(i)-48);
				ch[s.charAt(i)-48] = s.charAt(i);
				
				
			}
		}
	}
}
