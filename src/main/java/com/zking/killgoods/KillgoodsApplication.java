package com.zking.killgoods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zking.killgoods.mapper")
public class KillgoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KillgoodsApplication.class, args);
    }

}
