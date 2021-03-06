package aop;

import aop.annotation.*;

import java.lang.reflect.Method;

/**
 * @Author: lds
 * @Date: 2019/7/23 13:57
 */
@Aspect
public class MyAspect {
	
	/**
	 *全类名 方法名
	 */
	@PointCut ("aop.Test_doSomeThing")
	public void pointCut(){
	
	}
	
	@PointCut ("@annotation(aop.annotation.LogAnnotation)")
	public void pointCut1(){
	
	}
	
	
	@Before("pointCut")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("pointCut do before");
	}
	
	@After("pointCut")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("pointCut do after");
	}
	
	@Before("pointCut1")
	public void doBefore1(JoinPoint joinPoint) {
		
		LogAnnotation logAnnotation = joinPoint.getMethod ().getAnnotation (LogAnnotation.class);
		System.out.println(logAnnotation.des ());
		System.out.println("pointCut1 do before");
	}
	
	@After("pointCut1")
	public void doAfter1(JoinPoint joinPoint) {
		LogAnnotation logAnnotation = joinPoint.getMethod ().getAnnotation (LogAnnotation.class);
		System.out.println(logAnnotation.des ());
		System.out.println("pointCut1 do after");
	}
}
