package aop;

import aop.annotation.Aspect;
import aop.annotation.PointCut;

/**
 * @Author: lds
 * @Date: 2019/7/23 11:33
 */
//@Aspect
public class TestAspect extends AbsMethodAdvance {
	/**
	 *全类名 方法名
	 */
	@PointCut ("aop.Test_doSomeThing")
	public void testAspect(){
	
	}
	
	
	@Override
	public void doBefore() {
		System.out.println("do before");
	}
	
	@Override
	public void doAfter() {
		System.out.println("do after");
	}
}

