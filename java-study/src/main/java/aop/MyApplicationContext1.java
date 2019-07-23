package aop;

import aop.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lds
 * @Date: 2019/7/23 14:04
 */
public class MyApplicationContext1 {

	private static HashMap<Object,Object> targetAndProy = new HashMap<>();
	private static ArrayList<Object> obj = new ArrayList <> ();
	/**
	 * 存放代理类的集合
	 */
	public static ConcurrentHashMap<String,Object> proxyBeanMap = new ConcurrentHashMap<String, Object>();
	static {
		initAopBeanMap("aop");
	}

	/**
	 * 初始化容器
	 * @param basePath
	 */
	public static void initAopBeanMap(String basePath){
		MyMethodAdvance myMethodAdvance = new MyMethodAdvance();
		try{
			Set<Class<?>> classSet = ClassUtil.getClassSet(basePath);
			for(Class clazz : classSet){
				if(clazz.isAnnotationPresent(Aspect.class)){
					Method[] methods = clazz.getDeclaredMethods ();
					for(Method method : methods){
						if(method.isAnnotationPresent(PointCut.class)){
							//找到切点
							PointCut pointCut = method.getAnnotation (PointCut.class);
							String pointCutStr = pointCut.value();
							if(pointCutStr.contains ("@annotation")) {
								String annotation = pointCutStr.substring(pointCutStr.indexOf("(") + 1, pointCutStr.indexOf(")"));
								Class an = Class.forName(annotation);

								System.out.println(annotation);
								for(Class cl : classSet) {

									if(!cl.isAnnotation() && !cl.isInterface() && !Modifier.isAbstract(cl.getModifiers()) ) {
										Method[] ms = cl.getDeclaredMethods();
										for (Method m : ms) {
											if (m.isAnnotationPresent(an)) {
												Object mAno = m.getAnnotation (an);
												Object o = ReflectionUtil.newInstance(clazz);
												String methodName = m.getDeclaringClass().getName() + "." + m.getName();
												Object targeObj = cl.newInstance();
												obj.add(targeObj);

												myMethodAdvance.aspectMap(o).methodToPoint(methodName, method.getName())
														.pointToClass(method.getName(), o).annotations(methodName,mAno);
											}
										}
									}

								}
//

							}else {

								//System.out.println("pointCutStr:" + pointCutStr);
								String[] pointCutArr = pointCutStr.split ("_");
								//被代理的类名
								String className = pointCutArr[0];
								//System.out.println("className:" + className);
								//被代理的方法名
								String methodName = pointCutArr[1];
								// System.out.println("methodName:" + methodName);

								//根据切点 创建被代理对象
								Object targeObj = ReflectionUtil.newInstance (className);
								obj.add (targeObj);

								Object o = ReflectionUtil.newInstance (clazz);
								
								myMethodAdvance.aspectMap (o).methodToPoint (className+"."+methodName, method.getName ())
									.pointToClass (method.getName (), o);
							}
							
							
						}else if(method.isAnnotationPresent(Before.class)){
							Before before = method.getAnnotation (Before.class);
							myMethodAdvance.before (before.value (),method);
						}
						else if(method.isAnnotationPresent(After.class)){
							After before = method.getAnnotation (After.class);
							myMethodAdvance.after (before.value (),method);
						}
					}
					
				}
			}
			if(!obj.isEmpty ()) {
				myMethodAdvance.createProxyObject (obj, targetAndProy);
				Iterator iterator = targetAndProy.entrySet ().iterator ();
				while (iterator.hasNext ()) {
					Map.Entry entry = (Map.Entry) iterator.next();
					Object key = entry.getKey();
					Object value = entry.getValue();
					System.out.println("key:" + key + "---" + "value:" + value);
					proxyBeanMap.put (key.getClass ().getSimpleName ().toLowerCase (),
										  value);
				
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
}
