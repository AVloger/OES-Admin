package com.dut.communication;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import javax.xml.soap.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 聊天处理器ChannelInboundHandlerAdapter
 */
public class ChatHandler extends SimpleChannelInboundHandler<Object> {
    // 用于记录所有客户端的channel
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    // 生成ip-channel绑定
    public static IpMap ipMap = IpMap.getInstance();

    /**
     * 会话建立
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incomming = ctx.channel();
        String content = "[客户端] - " + incomming.remoteAddress() +  "在线\n";
        System.out.println(content);

        String ip = String.valueOf(ctx.channel().remoteAddress());
        this.ipMap.addIp(ip,ctx.channel());
        System.out.println(this.ipMap);
//        ctx.channel().writeAndFlush(new TextWebSocketFrame("success"));
    }

    /**
     * 会话结束
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        String content = "[客户端] - " + channel.remoteAddress() + "离线\n";
        System.out.println(content);
        // 清除离线用户 ？
        this.ipMap.deleteByChannel(channel);
    }

    /**
     * 捕获异常
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        String content = "[客户端] - " + channel.remoteAddress() + "发生异常\n";
        System.out.println(content);
        cause.printStackTrace();
        // 发生异常就关闭链接
        ctx.close();
    }

    /**
     * 每当从客户端收到新的客户端链接时，客户端的channel存入channelGroup列表中，
     * 并通知列表中其他客户端的channel
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 获取新连接通道
        Channel incomming = ctx.channel();
        String content = null;
        for ( Channel channel : channelGroup) {
            content = "[服务器] - " + incomming.remoteAddress() + "加入\n";
            channel.writeAndFlush(content);
        }
        // 加入channel
        channelGroup.add(incomming);
        System.out.println("增加链接");
    }

    /**
     * 每当从服务端收到客户端断开时，在channelGroup列表中移除channel，并通知列表中其他客户端的channel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incomming = ctx.channel();
        String content = null;
        for (Channel channel : channelGroup){
            content = "[服务器] - " + incomming.remoteAddress() + "离开\n";
            channel.writeAndFlush(content);
        }
        channelGroup.remove(incomming);
        System.out.println("断开链接");
    }


    /**
     * 获取客户端发送过来的消息，并将消息发送给其他客户端channel
     *
     * @param ctx
     * @param request
     * @throws Exception
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object request) throws Exception {
        // 如果是websocket请求
        // 如果是文件请求


        // 管理员向服务器发送指令
        if (request instanceof TextWebSocketFrame) {
            System.out.println(request);
            // 此处id是netty自动分配给每个对话现成的。id有两种 一种是长id 唯一 一种是短id，可能重复
            String channelId = ctx.channel().id().asLongText();
            // 读取消息
            String msg  = ((TextWebSocketFrame) request).text();
            // 绑定ip 和 channel
            // 定义每个上线的用户主动发送初始化信息过来，携带自己的ip，然后完成绑定 init:[ip]
            if (msg.indexOf("init") != -1){
//                String ip = String.valueOf(ctx.channel().remoteAddress());
//                this.ipMap.addIp(ip,ctx.channel());
//                ctx.channel().writeAndFlush(new TextWebSocketFrame("success"));
//                String ips[] = msg.split("@");
//                if("init".equals(ips[0])) {
//                    // 读取对方的ip
//
//                    this.ipMap.addIp(ips[1].trim(), ctx.channel());
//                    ctx.channel().writeAndFlush(new TextWebSocketFrame("success"));
//
//                }
            }
            // 发送消息给指定用户 消息模型 [meIp]:[toIp]:[msg]
            else  {
                String host = String.valueOf(ctx.channel().remoteAddress());
                System.out.println(msg);
//                System.out.println(JSONObject.parseObject(msg).getJSONArray("plugin"));
//                System.out.println(JSONObject.parseObject(msg).getInteger("taskId"));
//                System.out.println(JSONObject.parseObject(msg).getString("flag"));
//                System.out.println(JSONObject.parseObject(msg).getString("to"));
//                String message = "由[" + host + "]发送的消息:" + msg;
                this.ipMap.getChannelByIp(JSONObject.parseObject(msg).getString("to")).writeAndFlush(new TextWebSocketFrame((msg)));
            }
        } else if (request instanceof BinaryWebSocketFrame) {
            // 二进制文件
            BinaryWebSocketFrame img= (BinaryWebSocketFrame) request;
            System.out.println(img);
            ByteBuf byteBuf=img.content();
            try(FileOutputStream outputStream=new FileOutputStream("D:\\result")){
                byteBuf.readBytes(outputStream,byteBuf.capacity());
            }
            byteBuf.clear();

        } else {
            // 其他请求
            System.out.println(request);
        }
        // 如果是二进制文件请求

        System.out.println(this.ipMap);
    }

}
