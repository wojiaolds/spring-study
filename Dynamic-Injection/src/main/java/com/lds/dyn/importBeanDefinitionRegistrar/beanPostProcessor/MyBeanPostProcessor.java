package com.lds.dyn.importBeanDefinitionRegistrar.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/7/16 11:33
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization ( Object bean, String beanName )
	throws BeansException {
		System.out.println ("---"+beanName+"----");
		return bean;

	}
	
	@Override
	public Object postProcessAfterInitialization ( Object bean, String beanName )
	throws BeansException {
		
		return bean;
	}
}
