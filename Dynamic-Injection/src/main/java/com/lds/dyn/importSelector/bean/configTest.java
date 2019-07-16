package com.lds.dyn.importSelector.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lds
 * @Date: 2019/7/16 17:59
 */
@Configuration
public class configTest {
	
	@Bean
	public User user(){
		return new User ();
	}
}
