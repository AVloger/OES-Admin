package com.dut.communication;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.Socket;

/**
 * websocket 后台服务器
 */

public class WebsocketServer {
    public void run() {
        // 创建主从线程组
        EventLoopGroup main = new NioEventLoopGroup();
        EventLoopGroup sub = new NioEventLoopGroup();

        try {
            // 创建服务器类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(main, sub)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // get channel
                            ChannelPipeline pipeline = ch.pipeline();
                            // add handler base http codec 解码器
                            pipeline.addLast(new HttpServerCodec());
                            // 对http message进行聚合处理，聚合成request或者response
                            pipeline.addLast(new HttpObjectAggregator(65536));
                            // 在http有一些数据流产生，有大有小，我们对其进行处理，使用netty对大数据流读写提供支持
                            pipeline.addLast(new ChunkedWriteHandler());
                            /**
                             * 本handler会帮你处理一些繁重复杂的事情，
                             * 会帮你处理握手动作：handshaking（close、ping、pong）ping+pong=心跳
                             * 对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同
                             *
                             */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                            /**
                             * 自定义handler
                             */
                            pipeline.addLast(new ChatHandler());
//                            pipeline.addLast(new WebSocketServerHandler());
                        }
                    });


            ChannelFuture future = serverBootstrap.bind(8088).sync();
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            main.shutdownGracefully();
            sub.shutdownGracefully();
        }
    }
}
