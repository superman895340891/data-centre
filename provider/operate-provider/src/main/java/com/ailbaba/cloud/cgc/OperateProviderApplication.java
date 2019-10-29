package com.ailbaba.cloud.cgc;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ailbaba.cloud.cgc.mapping")
@EnableDistributedTransaction
public class OperateProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperateProviderApplication.class, args);
    }

}
