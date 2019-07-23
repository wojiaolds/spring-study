package aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: lds
 * @Date: 2019/7/23 11:31
 */
@Retention ( RetentionPolicy.RUNTIME)//保留时间长短
@Target (value = { ElementType.METHOD}) //使用范围 方法
public @interface PointCut {
	
	/**
	 * 全类名_方法名
	 * @return
	 */
	String value();
}
