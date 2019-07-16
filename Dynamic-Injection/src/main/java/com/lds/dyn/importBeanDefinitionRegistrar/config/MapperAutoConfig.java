package com.lds.dyn.importBeanDefinitionRegistrar.config;

import com.lds.dyn.importBeanDefinitionRegistrar.annotation.MyMapperScan;
import com.lds.dyn.importBeanDefinitionRegistrar.beanPostProcessor.MyBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: lds
 * @Date: 2019/7/16 10:01
 */
@Configuration
@ComponentScan
@ComponentScan("com.lds.dyn.importBeanDefinitionRegistrar.beanPostProcessor")  //对应的类需要有@Component注解
//@Import ( MyBeanPostProcessor.class)  //对应的类不需要需要有@Component注解
@MyMapperScan("com.lds.dyn.importBeanDefinitionRegistrar")
public class MapperAutoConfig { }
