package com.lds.dyn.importBeanDefinitionRegistrar.annotation;


import com.lds.dyn.importBeanDefinitionRegistrar.config.MapperAutoConfiguredMyBatisRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: lds
 * @Date: 2019/7/16 10:22
 */
@Retention ( RetentionPolicy.RUNTIME)
@Target ( ElementType.TYPE)
@Documented
@Import(MapperAutoConfiguredMyBatisRegistrar.class)
public @interface MyMapperScan {
	
	
	String[] value() default {};
}
