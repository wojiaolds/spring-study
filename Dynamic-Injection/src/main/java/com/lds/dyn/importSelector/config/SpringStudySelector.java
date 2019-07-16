package com.lds.dyn.importSelector.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportSelector接口是spring中导入外部配置的核心接口,也就是可以导入其他jar包的里的配置类
 * @Author: lds
 * @Date: 2019/7/16 14:15
 */
public class SpringStudySelector implements ImportSelector, BeanFactoryAware {
	private BeanFactory beanFactory;
	
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		importingClassMetadata.getAnnotationTypes().forEach(System.out::println);
		System.out.println(beanFactory);
		return new String[]{};
//		return new String[]{AppConfig.class.getName()};
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
