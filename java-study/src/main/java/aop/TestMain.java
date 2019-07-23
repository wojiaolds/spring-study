package aop;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lds
 * @Date: 2019/7/23 11:44
 */
public class TestMain {
	
	public static void main(String[] args){
		//模拟容器初始化
		MyApplicationContext1 applicationContext = new MyApplicationContext1();
		ConcurrentHashMap<String,Object> proxyBeanMap = MyApplicationContext1.proxyBeanMap;
		//生成代理对象，默认为该类名的小写
		Test test =(Test)proxyBeanMap.get("test");
		test.doSomeThing();
		System.out.println("------------");
		test.doWithNotProxy();
	}

}
