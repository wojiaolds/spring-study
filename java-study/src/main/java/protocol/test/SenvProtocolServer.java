package protocol.test;

import org.apache.commons.lang3.StringUtils;
import utils.SystemUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;

/**
 *   处理Senv协议的服务器
 *    1.接收客户端请求
 *    2.发送响应结果
 * @Author: lds
 * @Date: 2019/8/26 11:46
 */
public class SenvProtocolServer {
	
//	private static final Logger logger = Logger.getLogger(SenvProtocolServer.class);
	
	/** Senv协议的请求参数标识 */
	public static final String REQUEST_PARAM_MARK = "pro=";
	
	/** Senv协议服务的默认端口号 */
	private static final int DEFAULT_PORT = 9527;
	
	/** 服务器的IP或主机名 */
	private String host;
	
	/** 绑定了Senv协议服务的端口号 */
	private int port = 9527;
	
	/** 当前就绪的服务端通道 */
	private ServerSocketChannel serverChannel;
	
	/** 当前就绪的客户端通道 */
	private SocketChannel clientChannel;
	
	/** 服务端的事件注册器 */
	private Selector selector;
	
	/**
	 * <p>启动Senv协议服务器</p>
	 * @author <a href="mailto:code727@gmail.com">Daniele</a>
	 * @throws IOException
	 * @since AppDemo1.0.0
	 */
	public void start() throws IOException {
		
		serverChannel = ServerSocketChannel.open();
		
		if (port < 1 || port > 65535)
			port = DEFAULT_PORT;
		
		if (StringUtils.isNotBlank (host)) {
			serverChannel.socket().bind(new InetSocketAddress (InetAddress.getByName(host), port));
			System.out.println ("Start server " + host + ":" + port);
		} else {
			serverChannel.socket().bind(new InetSocketAddress(port));
			System.out.println ("Start server on port " + port);
		}
		//非阻塞
		serverChannel.configureBlocking(false);
		selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		handle();
	}
	
	/**
	 * <p>处理Senv协议请求</p>
	 * @author <a href="mailto:code727@gmail.com">Daniele</a>
	 * @throws IOException
	 * @since AppDemo1.0.0
	 */
	protected void handle() throws IOException {
		while (true) {
			selector.select();
			Iterator<SelectionKey> keySetIterator = selector.selectedKeys().iterator();
			SelectionKey cuurentKey = null;
			while (keySetIterator.hasNext()) {
				// 获取当前就绪通道的键对象
				cuurentKey = keySetIterator.next();
				// 避免同一个就绪通道被重复处理
				keySetIterator.remove();
				try {
					if (cuurentKey.isAcceptable()) {
						serverChannel = (ServerSocketChannel) cuurentKey.channel();
						clientChannel = serverChannel.accept();
						if (clientChannel != null) {
							System.out.println("Receive request from "
										+ clientChannel.socket().getInetAddress().getHostAddress() + ":"
										+ clientChannel.socket().getLocalPort());
							clientChannel.configureBlocking(false);
							clientChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
						}
					} else {
						clientChannel = (SocketChannel) cuurentKey.channel();
						if (cuurentKey.isReadable())
							writeResponse();
					}
				} catch (IOException e) {
					if (clientChannel != null && clientChannel.isOpen())
						try {
                            /*
                             *  为防止服务端在读写客户端信息时，客户端由于某种原因被意外关闭引起服务端也被强制关闭的情况发生。
                             *  需在catch块中也需要对客户端的通道做关闭处理， 从而防止服务端也被强制关闭的严重问题。
                             *  另外，对就绪通道的读写过程需单独的在一个try...catch块中。
                             */
							clientChannel.close();
						} catch (IOException ioe) {
							ioe.printStackTrace();
						}
				}
			}
		}
	}
	
	/**
	 * <p>读取客户端请求</p>
	 * @author <a href="mailto:code727@gmail.com">Daniele</a>
	 * @return
	 * @throws IOException
	 * @throws
	 * @since AppDemo1.0.0
	 */
	protected String readRequest() throws IOException {
		StringBuffer request = new StringBuffer();
		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (clientChannel.read(buffer) > 0) {
			buffer.flip();
			request.append(decoder.decode(buffer).toString());
			buffer.clear();
		}
		return request.toString();
	}
	
	/**
	 * <p>向客户端返回响应结果</p>
	 * @author <a href="mailto:code727@gmail.com">Daniele</a>
	 * @throws IOException
	 * @since AppDemo1.0.0
	 */
	protected void writeResponse() throws IOException {
		String request = readRequest();
		System.out.println ("request: "+request);
		int start = -1;
		// 如果发送的请求为"?"或请求中无指定的参数时，则查询所有的系统环境属性
		if ("?".equals(request) ||
			(start = request.toLowerCase().indexOf(REQUEST_PARAM_MARK)) < 0) {
			clientChannel.write(ByteBuffer.wrap(SystemUtils.formatSystemProperties ().getBytes ()));
		} else {
			// 获取请求参数值
			System.out.println ("start:"+start);
			String queryValueString = request.substring(start + REQUEST_PARAM_MARK.length());
			System.out.println (queryValueString);
			if (StringUtils.isBlank (queryValueString))
				clientChannel.write(ByteBuffer.wrap(SystemUtils.formatSystemProperties().getBytes()));
			else {
				int index = queryValueString.indexOf("&");
				if (index > -1)
                    /*
                     *  如果请求参数值里出现了"&"字符，
                     *  则说明这个字符后面的内容则认为是其它一些请求参数的内容，
                     *  因此不对这部分内容作处理
                     */
					queryValueString = queryValueString.substring(0, index);
				clientChannel.write(ByteBuffer.wrap(SystemUtils.formatSystemProperties(queryValueString.split(",")).getBytes()));
			}
		}
        /*
         *  响应内容被发送出去之后添加换行标识，
         *  目的是让客户端的BufferedReader对象调用readLine()方法后能将当前行的内容读取出来
         */
		clientChannel.write(ByteBuffer.wrap("\n".getBytes()));
        
        /*
         *  发送完响应信息后马上关闭与客户端之间的通道。
         *  目的在于让客户端读取完这些响应之后，就立即释放掉资源，从而让读操作不会一直处于阻塞状态
         */
		clientChannel.close();
	}
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public static void main(String[] args) {
		SenvProtocolServer server = new SenvProtocolServer();
		server.setHost("192.168.188.116");
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
