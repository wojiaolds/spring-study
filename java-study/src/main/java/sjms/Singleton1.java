package sjms;

/**
 * 饿汉式
 * 优点：没有加锁，执行效率会提高。
   缺点：类加载时就初始化，浪费内存。
 * @Author: lds
 * @Date: 2019/8/13 16:05
 */
public class Singleton1 {
	private static Singleton1 instance = new Singleton1();
	private Singleton1 (){}
	public static Singleton1 getInstance() {
		return instance;
	}
}
