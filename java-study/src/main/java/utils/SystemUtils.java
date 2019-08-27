package utils;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: lds
 * @Date: 2019/8/26 11:55
 */
public class SystemUtils {
	
	private static Properties properties = null;
	
	static {
		properties = System.getProperties();
	}
	
	/**
	 * <p>返回格式化后的所有系统属性信息</p>
	 * @author <a href="mailto:code727@gmail.com">Daniele</a>
	 * @return
	 * @since AppDemo1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static String formatSystemProperties() {
		StringBuffer formatResult = new StringBuffer();
		Enumeration<String> names = (Enumeration<String>) properties.propertyNames();
		Set<String> set = properties.stringPropertyNames ();
		String[] str = new String[set.size ()];
		set.toArray (str);
		return formatSystemProperties(str);
//		while (names.hasMoreElements()) {
//			String name = names.nextElement();
//			formatResult.append(name).append("=")
//				.append(properties.getProperty(name)).append("\n");
//		}
//		int length = 0;
//		return (length = formatResult.length()) > 0 ?
//			formatResult.substring(0, length - 1) : "";
	
	
	}
	
	/**
	 * <p>返回格式化后的所有指定的系统属性信息</p>
	 * @author <a href="mailto:code727@gmail.com">Daniele</a>
	 * @param propertyKeys
	 * @return
	 * @since AppDemo1.0.0
	 */
	public static String formatSystemProperties(String[] propertyKeys) {
		StringBuffer formatResult = new StringBuffer();
		if (propertyKeys != null && propertyKeys.length > 0) {
			for (String key : propertyKeys)
				formatResult.append(key).append("=")
					.append(properties.getProperty(key)).append("\n");
		}
		int length = 0;
		return (length = formatResult.length()) > 0 ?
			formatResult.substring(0, length - 1) : "";
	}
	
}
