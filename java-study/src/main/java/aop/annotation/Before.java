package aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: lds
 * @Date: 2019/7/23 13:54
 */
@Retention ( RetentionPolicy.RUNTIME)
@Target ( ElementType.METHOD)
public @interface Before {
	String value() default "";
}
