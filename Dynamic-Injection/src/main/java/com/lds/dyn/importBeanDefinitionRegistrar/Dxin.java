package com.lds.dyn.importBeanDefinitionRegistrar;

/**
 * @Author: lds
 * @Date: 2019/7/19 14:41
 */
public class Dxin implements IMessage {
	
	private String protocol;
	
	public Dxin(String protocol){
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