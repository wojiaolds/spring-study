package com.lds.dyn.importBeanDefinitionRegistrar;

import com.lds.dyn.importBeanDefinitionRegistrar.annotation.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/7/16 9:29
 */
@MyMapper
public class CountryMapper {
	
	@Autowired
	private StuMapper stuMapper;
	
	public void print(){
		stuMapper.print ();
	}
	
	
}
