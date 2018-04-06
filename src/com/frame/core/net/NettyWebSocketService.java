package com.frame.core.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyWebSocketService {
	
	
	private static NettyWebSocketService instance=new NettyWebSocketService();
	
	private NettyWebSocketService()	{
		init();
	}
	
	public static NettyWebSocketService getInstance() {
		return instance;
	}
	
	private EventLoopGroup bossGroup=new NioEventLoopGroup();
	
	private EventLoopGroup workerGroup=new NioEventLoopGroup();
	
	private ServerBootstrap bootstrap=new ServerBootstrap();
	
	private void init() {
		ServerBootstrap group = bootstrap.group(bossGroup, workerGroup);
		group.channel(NioServerSocketChannel.class);
		group.childHandler(new MyChannelHandler());
	}
	
	
	
}
