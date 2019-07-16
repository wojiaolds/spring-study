package com.lds.dyn.importBeanDefinitionRegistrar.config;


import com.lds.dyn.importBeanDefinitionRegistrar.annotation.MyMapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lds
 * @Date: 2019/7/16 9:29
 */
public class MapperAutoConfiguredMyBatisRegistrar
	implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, BeanFactoryAware
{
	
	private ResourceLoader resourceLoader;
	
	private BeanFactory beanFactory;
	
	@Override
	public void registerBeanDefinitions( AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		
		AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName()));
		List<String> basePackages = new ArrayList<> ();
		for (String pkg : annoAttrs.getStringArray("value")) {
			if (StringUtils.hasText(pkg)) {
				basePackages.add(pkg);
			}
		}
		
		MyClassPathBeanDefinitionScanner scanner = new MyClassPathBeanDefinitionScanner (registry, false);
		scanner.setResourceLoader(resourceLoader);
		scanner.registerFilters();
		scanner.doScan(StringUtils.toStringArray(basePackages));
		
	}
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	

	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
