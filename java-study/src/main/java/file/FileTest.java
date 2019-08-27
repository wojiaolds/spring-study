package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author: lds
 * @Date: 2019/8/23 9:18
 */
public class FileTest {
	
	public static void main ( String[] args ) {
		FileOutputStream fileInputStream = null;
		try {
			String s = "ABCDE";
			byte[] b = s.getBytes ();
			fileInputStream  = new FileOutputStream ("test.txt",true);
			fileInputStream.write (b);
			fileInputStream.flush ();
		} catch ( Exception e ) {
			System.out.println (e);
		}finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close ();
				}
			}catch ( Exception e ){
				System.out.print (e);
			}
			
		}
		
	}
}
