package protocol.test;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *   *    Senv协议请求的客户端，主要功能分为：
 *    1.在创建第一次创建URL对象之前，添加对自定义协议的支持
 *    2.发送请求
 *    3.展示响应数据
 * @Author: lds
 * @Date: 2019/8/26 11:53
 */
public class SenvProtocolClient {
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			// 配置协议处理器查找规则一
			System.out.println (System.getProperty("java.protocol.handler.pkgs"));
			if (StringUtils.isBlank (System.getProperty("java.protocol.handler.pkgs"))) {
				// 设置各个协议包所在的父包路径
				System.setProperty("java.protocol.handler.pkgs", "protocol.custom");
			}
            /*
                         * 配置协议处理器查找规则二
                         * 这种方式在整个应用范围之内只能被执行一次。
                         * 如果多于一次则会出现"java.lang.Error: factory already defined"这样的错误。但不会受规则一的限制.
                         */
			//          URL.setURLStreamHandlerFactory(new CustomProtocolFactory());
			
			URL url = new URL("senv://192.168.188.116:9527/");
			reader = new BufferedReader(new InputStreamReader (url.openConnection().getInputStream()));
			String result = "";
			while ((result = reader.readLine()) != null)
				System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
