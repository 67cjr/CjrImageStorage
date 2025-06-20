package com.cjr.cjrimagestoragebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.cjr.cjrimagestoragebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class CjrImageStorageBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjrImageStorageBackendApplication.class, args);
    }

}
