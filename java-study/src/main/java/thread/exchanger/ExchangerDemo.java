package thread.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @Author: lds
 * @Date: 2019/8/1 16:47
 */
public class ExchangerDemo {
	
	public static void main ( String... argv ) {
		
		Exchanger <List <Integer>> exchanger = new Exchanger <> ();
		
		new Thread (() -> {
			List <Integer> list = new ArrayList <> ();
			list.add (1);
			list.add (2);
			try {
				list = exchanger.exchange (list);
				System.out.println ("thread1" + list);
			} catch ( Exception e ) {
				System.out.println (e);
			}
		}).start ();
		
		new Thread (() -> {
			List <Integer> list = new ArrayList <> ();
			list.add (3);
			list.add (4);
			try {
				list = exchanger.exchange (list);
				System.out.println ("thread2" + list);
			} catch ( Exception e ) {
				System.out.println (e);
			}
		}).start ();
	}
}
