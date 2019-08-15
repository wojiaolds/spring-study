package sjms;

/**
 * 延迟初始化，这里是利用了 Java 的语言特性，
 * 内部类只有在使用的时候，才会去加载，从而初始化内部静态变量
 * @Author: lds
 * @Date: 2019/8/13 16:28
 */

public class Foo {
	/**
	 * Helper换成具体要实例化的类
	 */
	//	private static class HelperHolder {
//		public static final Helper helper = new Helper();
//	}
//	public static Helper getHelper() {
//		return HelperHolder.helper;
//	}
}
