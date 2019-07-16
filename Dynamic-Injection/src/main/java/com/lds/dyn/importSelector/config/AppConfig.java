package com.lds.dyn.importSelector.config;

import com.lds.dyn.importSelector.bean.StudentBean;
import com.lds.dyn.importSelector.bean.User;
import com.lds.dyn.importSelector.bean.configTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lds
 * @Date: 2019/7/16 14:20
 */
@Configuration
public class AppConfig {
	
	@Bean
	public StudentBean studentBean() {
		StudentBean studentBean = new StudentBean();
		studentBean.setId(19);
		studentBean.setName("admin");
		return studentBean;
	}
	
	/**
	 * @Bean注入的类是普通类  类上的@Configuration注解不会生效
	 * @return
	 */
	@Bean
	public configTest configTest(){
		return new configTest ();
	}
}
