package com.lds.dyn.importSelector.config;

import com.lds.dyn.importSelector.annotation.EnableSpringStudy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: lds
 * @Date: 2019/7/16 14:22
 */
@Configuration //表明此类是配置类
@ComponentScan  //不配置扫描包会默认扫描自己所在的包
@PropertySource ("classpath:application.properties") // 读取application.properties
@EnableSpringStudy
public class MainConfig { }
