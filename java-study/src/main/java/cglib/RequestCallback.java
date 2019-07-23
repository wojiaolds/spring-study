package cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: lds
 * @Date: 2019/7/23 10:04
 */




/**
 * 要对该类进行继承扩展，所以我们要使用CGLIB类库，实现一个net.sf.cglib.proxy.Callback，
 * 或者使用net.sf.cglib.proxy.MethodInterceptor（继承自Callback）
 */
public class RequestCallback implements MethodInterceptor {
	
	@Override
	public Object intercept (
		Object o, Method method, Object[] objects, MethodProxy methodProxy ) throws Throwable {
		
		if(method.getName().equals("request")) {
			
			System.out.println("你调用了request方法");
			
			return methodProxy.invokeSuper(o, objects);
			
		}
		
		return null;
	}
}
