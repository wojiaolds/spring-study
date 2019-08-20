import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: lds
 * @Date: 2019/8/20 9:22
 */
public class StringTest {
	
	public static void main ( String[] args ) {
		//官方推荐使用split拆分字符串
		String nameStr="Harry James Potter";
		//"\\s"表示空格
		String[] nameStrArray=nameStr.split("\\s");
		//也可以来" "来进行拆分,这种方法要注意中间只能有一个空格，如果有两个空格则不能正常拆分，最后得到的仍是原有字符串
		//String[] nameStrArray=nameStr.split(" ");
		System.out.println (Arrays.toString (nameStrArray));
		
		StringTokenizer stringTokenizer = new StringTokenizer ("a=123|b=edf","|");
		while (stringTokenizer.hasMoreTokens ()){
			System.out.println (stringTokenizer.nextToken ());
		}
		
	}
}
