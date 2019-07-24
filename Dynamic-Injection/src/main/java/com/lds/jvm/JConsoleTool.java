package com.lds.jvm;

/**
 * @Author: lds
 * @Date: 2019/7/18 14:51
 */

import java.util.ArrayList;
import java.util.List;

/**
 *  设置虚拟机参数：
 *  -Xms100M -Xmx100m -XX:+UseSerialGC -XX:+PrintGCDetails
 *
 * 	-XX:+UseSerialGC  支持使用串行收集器。默认不开启。
 *   -XX:+PrintGCDetails  (打印GC的详细信息)
 */
public class JConsoleTool {
	
	static class OOMObject {
		public byte[] placeholder = new byte[64 * 1024];
	}
	
	public static void fillHeap(int num) throws InterruptedException {
		Thread.sleep(20000); //先运行程序，在执行监控
		List<OOMObject> list = new ArrayList<OOMObject> ();
		for (int i = 0; i < num; i++) {
			// 稍作延时，令监视曲线的变化更加明显
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}
	
	public static void main(String[] args) throws Exception {
		fillHeap(1000);
		while(true){
			//让其一直运行着
		}
	}
}

