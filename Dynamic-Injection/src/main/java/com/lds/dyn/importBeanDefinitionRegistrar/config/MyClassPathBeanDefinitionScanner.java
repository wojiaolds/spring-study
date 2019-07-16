package com.lds.dyn.importBeanDefinitionRegistrar.config;


import com.lds.dyn.importBeanDefinitionRegistrar.annotation.MyMapper;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @Author: lds
 * @Date: 2019/7/16 9:46
 */
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
	
	
	
	public MyClassPathBeanDefinitionScanner (
		BeanDefinitionRegistry registry, boolean useDefaultFilters ) {
		
		super (registry, useDefaultFilters);
	}
	
	public void registerFilters () {
		
		addIncludeFilter (new AnnotationTypeFilter (MyMapper.class));
	}
	
	@Override
	protected Set <BeanDefinitionHolder> doScan ( String... basePackages ) {
		
		return super.doScan (basePackages);
	}
}
