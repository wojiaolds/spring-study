package com.lds.dyn.importSelector.config;

import com.lds.dyn.importSelector.bean.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lds
 * @Date: 2019/7/16 18:01
 */
@Configuration
public  class StaticConfig {
	
	/**
	 * Object result = factoryMethod.invoke(factoryBean, args);
	 * 静态的factoryBean=null  这是与非静态的唯一区别
	 * @return
	 */
	@Bean
	public static Order order(){
		return new Order ();
	}
	
	
}
