package com.harris.harris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan(basePackages = "com.harris.harris.dao.mapper")
public class HarrisApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(HarrisApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
