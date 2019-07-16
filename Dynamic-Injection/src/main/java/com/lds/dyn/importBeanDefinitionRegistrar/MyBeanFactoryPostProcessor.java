package com.lds.dyn.importBeanDefinitionRegistrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Author: lds
 * @Date: 2019/7/16 11:32
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	
	/**
	 * bean还没有实例化，此时bean刚被解析成BeanDefinition对象
	 * @param beanFactory
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory (
		ConfigurableListableBeanFactory beanFactory ) throws BeansException {
		
	}
}
