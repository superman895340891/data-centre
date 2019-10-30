package com.ailbaba.cloud.cgc;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.ailbaba.cloud.cgc")
@EnableDiscoveryClient
@MapperScan("com.ailbaba.cloud.cgc.mapping")
@EnableDubbo(scanBasePackages = "com.ailbaba.cloud.cgc")
public class UserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }

}
