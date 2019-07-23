package aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: lds
 * @Date: 2019/7/23 14:22
 */
public class MyMethodAdvance implements MethodInterceptor {
	
	/**
	 * 要被代理的对象
	 */
	private ArrayList<Object> targetObject = new ArrayList <> ();
	

	private ArrayList<Object> aspectMap = new ArrayList <> () ;
	private HashMap<String,String> methodToPoint = new HashMap <> () ;
	private HashMap<String,Object>  pointToClass = new HashMap <> () ;
	private HashMap<String,Method> before = new HashMap <> () ;
	private HashMap<String,Method> after = new HashMap <> () ;

	public MyMethodAdvance aspectMap(Object aspect){
		this.aspectMap.add (aspect);
		return this;
	}
	
	
	public MyMethodAdvance methodToPoint(String m,String p){
		this.methodToPoint.put (m,p);
		return this;
	}
	
	public MyMethodAdvance pointToClass(String p,Object c){
		this.pointToClass.put (p,c);
		return this;
	}
	public MyMethodAdvance before(String p,Method m){
		this.before.put (p,m);
		return this;
	}
	
	public MyMethodAdvance after(String p,Method m){
		this.after.put (p,m);
		return this;
	}
	
	public void createProxyObject(ArrayList<Object> target,HashMap<Object,Object>  allProxy){
		this.targetObject.addAll (target);
		for(Object o:target) {
			//该类用于生成代理对象
			Enhancer enhancer = new Enhancer ();
			//设置目标类为代理对象的父类
			enhancer.setSuperclass (o.getClass ());
			//设置回调用对象为本身
			enhancer.setCallback (this);
			Object object = enhancer.create ();
			allProxy.put (o,object);
		}
	
	}
	
	@Override
	public Object intercept( Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable{
		
		String methodName = method.getDeclaringClass().getName()+"."+method.getName();

		String point = methodToPoint.get(methodName);
		Object aspect = null;
		Method b = null;
		Method a = null;
		if(StringUtils.isNotEmpty (point)) {
			aspect = pointToClass.get(point);
			b = before.get(point);
			a = after.get(point);
		}

		
		if(b != null){
			b.invoke (aspect,new Object[] {new JoinPoint()});
		}
		
		//执行拦截的方法
		Object result = methodProxy.invokeSuper(proxy,args);
		
		if(a != null){
			a.invoke (aspect,new Object[] {new JoinPoint()});
		}
		return result;
	}
	
	
}
