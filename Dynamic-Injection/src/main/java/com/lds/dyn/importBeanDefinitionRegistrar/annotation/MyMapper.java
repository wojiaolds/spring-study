package com.lds.dyn.importBeanDefinitionRegistrar.annotation;

import java.lang.annotation.*;

/**
 * @Author: lds
 * @Date: 2019/7/16 9:27
 */
@Documented
@Inherited
@Retention ( RetentionPolicy.RUNTIME)
@Target ({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface MyMapper { }
