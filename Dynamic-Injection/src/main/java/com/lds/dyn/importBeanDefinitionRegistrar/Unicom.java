package com.lds.dyn.importBeanDefinitionRegistrar;

import javax.swing.*;

/**
 * @Author: lds
 * @Date: 2019/7/19 14:13
 */
public class Unicom implements IMessage {
	
	private String protocol;
	
	public Unicom(String protocol){
		this.protocol = protocol;
	}
	
	@Override
	public void send ( String phone, String txt ) {
		System.out.println("---"+this.getClass ().getName ()+"---");
		System.out.println ("phone:"+phone);
		System.out.println ("txt:"+txt);
		System.out.println ("protocol:"+this.protocol);
	}
}
