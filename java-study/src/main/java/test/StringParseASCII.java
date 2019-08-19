package test;

/**
 * @Author: lds
 * @Date: 2019/8/19 15:19
 */
public class StringParseASCII {
	
	public static void main(String[] args) {
		System.out.print(stringParseASCII("abx"));
	}
	
	public static String stringParseASCII(String str){
		StringBuffer result = new StringBuffer();
		char tmp;
		for(int i = 0;i<str.length();i++){
			tmp = (char)(str.charAt(i)+5);
			if(tmp > 'z') {
				result.append((char)('a'+(tmp-'z')));
			}else {
				result.append(tmp);
			}
		}
		
		return result.toString();
	}

}
