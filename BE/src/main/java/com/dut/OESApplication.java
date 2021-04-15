package com.dut;

import com.alibaba.druid.support.http.StatViewServlet;
import com.dut.communication.WebsocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication()
public class OESApplication {
    public static void main(String[] args) {
        SpringApplication.run(OESApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  项目 启动成功   ლ(´ڡ`ლ)ﾞ  \n");
        // 开启netty服务
        new WebsocketServer().run();
//        while(true) {
//            try {
//                Thread.sleep(1000);
//                System.out.println("加密狗");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
