package sjms;

/**
 * @Author: lds
 * @Date: 2019/8/13 16:20
 */
public class Singleton3 {
	
	private volatile static Singleton3 singleton = null;
	
	private Singleton3 (){}
	
	/**
	 * 通过这样修改以后，在运行过程中，除了第一次以外，
	 * 其他的调用只要访问 volatile 变量 sInst 一次，
	 * 这样能提高 25% 的性能（Wikipedia）。
	 * @return
	 */
	public static Singleton3 getInstance(){
		Singleton3 tmp = singleton;
		if (tmp == null) {
			synchronized(Singleton3.class) {
				tmp = singleton;
				if (tmp == null) {
					tmp = new Singleton3 ();
					singleton = tmp;
				}
			}
		}
		return tmp;
		
	}
}
