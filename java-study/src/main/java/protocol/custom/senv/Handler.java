package protocol.custom.senv;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 *      自定义的senv协议处理器。
 *      由于senv协议的格式符合标准的URL格式：
 *          protocol://username@hostname:port/path/filename?query#fragment
 *      因此，这个实现类只需实现父类中的openConnection()方法即可。否则，需重写父类方法
 *      protected void parseURL(URL u, String spec, int start, int limit)，
 *      来重新正确的设置URL的各个属性值，例如:host,port,query等。
 *
 * @Author: lds
 * @Date: 2019/8/26 11:24
 */
public class Handler extends URLStreamHandler {
	
	/**
	 * 当URL根据协议找到该处理器并调用openConnection()方法后，
	 * 返回负责处理该协议连接的连接器
	 * @param u
	 * @return
	 * @throws IOException
	 */
	@Override
	protected URLConnection openConnection ( URL u ) throws IOException {
		
		return new SenvURLConnection(u);
	}
}
