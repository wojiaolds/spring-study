package io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.utils.Calculator;

import java.io.UnsupportedEncodingException;

/**
 * Handles a server-side channel.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

	/**
	 * �յ��ͻ�����Ϣ
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
		ByteBuf in = (ByteBuf) msg;
		byte[] req = new byte[in.readableBytes()];
		in.readBytes(req);
		String body = new String(req,"utf-8");
		System.out.println("�յ��ͻ�����Ϣ:"+body);
		String calrResult = null;
		try{
			calrResult = Calculator.Instance.cal(body).toString();
		}catch(Exception e){
			calrResult = "����ı��ʽ��" + e.getMessage();
		}
		ctx.write(Unpooled.copiedBuffer(calrResult.getBytes()));
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	/**
	 * �쳣����
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}