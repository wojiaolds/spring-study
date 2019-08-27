package protocol.factory;

import protocol.custom.senv.Handler;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * @Author: lds
 * @Date: 2019/8/26 11:44
 */
public class CustomProtocolFactory implements URLStreamHandlerFactory {
	
	@Override
	public URLStreamHandler createURLStreamHandler ( String protocol ) {
		
		if ("senv".equalsIgnoreCase(protocol))
			return new Handler ();
		return null;
	}
}
