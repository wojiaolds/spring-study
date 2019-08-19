package test;

/**
 * @Author: lds
 * @Date: 2019/8/19 17:29
 */
public class TwoBigNumberAdd {
	
	public static void main ( String[] args ) {
		String s1 = "1234567867";
		String s2 = "324254354654";
		add(s1,s2);
	}
	public static String add(String str1,String str2){
		if(str1 == null)
			return str2;
		if(str2 == null)
			return str1;
		StringBuffer s1 = new StringBuffer(str1).reverse();
		StringBuffer s2 = new StringBuffer(str2).reverse();
		StringBuffer res = new StringBuffer();
		int len1 = s1.length();
		int len2 = s2.length();
		int len;
		if(len1 < len2) {
			len = len2;
			int count = len2 - len1;
			while(count-- > 0)
				s1.append('0');
		} else {
			len = len1;
			int count = len1 - len2;
			while(count-- > 0)
				s2.append('0');
		}
		int overflow = 0;
		int num;
		for(int i = 0; i < len; i++) {
			num = s1.charAt(i) - '0' + s2.charAt(i) - '0' + overflow;
			if(num >= 10) {
				overflow = 1;
				num -= 10;
			} else {
				overflow = 0;
			}
			res.append(String.valueOf(num));
		}
		if(overflow == 1)
			res.append(1);
		
		return res.reverse().toString();
	}
}
