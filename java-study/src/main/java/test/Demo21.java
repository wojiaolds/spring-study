package test;

/**
 * 输入一个字符，将字符转换为小写，将其对应的ASCII值加5后，输出结果
 * @Author: lds
 * @Date: 2019/8/20 11:44
 */
public class Demo21 {
	public static void main(String[] args) {
		System.out.println(parseChar('X'));
	}
	public static char parseChar(char ch) {
		char resCh = 'a';
		resCh = (char)(Character.toLowerCase(ch) + 5);
		if(resCh > 'z') {
			resCh = (char)(resCh - 26);
		}
		return resCh;
	}

}
