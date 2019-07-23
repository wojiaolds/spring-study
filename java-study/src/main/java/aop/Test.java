package aop;

import aop.annotation.LogAnnotation;

/**
 * @Author: lds
 * @Date: 2019/7/23 11:49
 */
public class Test {
	public void doSomeThing(){
		System.out.println("do some thing...");
	}
	
	@LogAnnotation
	public void doWithNotProxy(){
		System.out.println("do some thing with not proxy");
	}
}
