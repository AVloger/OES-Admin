package com.dut.communication;

import io.netty.channel.Channel;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

/**
 * 给每一个IP绑定一个channel
 */

public class IpMap {
    private HashMap<String, Channel> ipMap = new HashMap<>();
    private static IpMap instance;

    @Override
    public String toString() {
        return "IpMap{" +
                "ipMap=" + ipMap +
                '}';
    }

    public static IpMap getInstance() {
        if (instance == null) {
            instance = new IpMap();
        }
        return instance;
    }

    private IpMap() {}

    /**
     * 增加ip
     */
    public void addIp(String ip, Channel channel){
        this.ipMap.put(ip, channel);
    }

    /**
     * 根据ip获取channel
     */
    public void deleteByIp(String ip) {
        this.ipMap.remove(ip);
    }

    /**
     * 根据ip 获得channel
     */
    public Channel getChannelByIp(String ip){
        return this.ipMap.get(ip);
    }
    /**
     * 移除IP
     */
    public void deleteByChannel(Channel channel){
        for (Map.Entry<String, Channel> entry : ipMap.entrySet()) {
            if(entry.getValue() == channel) {
                ipMap.remove(entry.getKey());
            }
        }
    }


}
