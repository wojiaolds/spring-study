package cglib;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @Author: lds
 * @Date: 2019/7/23 10:08
 */




/**
 * 我们使用MethodInterceptor为request方法实现了对request请求进行控制的逻辑
 　　然后我们现在通过Enhancer为目标对象动态生成一个子类，
 	将RequestCallback的横切逻辑附加到该子类中
 */
public class Client {
	
	public static void main(String[] args) {
		
		Enhancer enhancer = new Enhancer ();
		
		//设置父类
		
		enhancer.setSuperclass(Requestable.class);
		
		//设置Callback
		
		enhancer.setCallback(new RequestCallback());
		

		
		Requestable proxy = (Requestable) enhancer.create();
		
		proxy.request();

	
		
	}

}
