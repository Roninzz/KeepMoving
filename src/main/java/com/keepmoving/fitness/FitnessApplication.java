package com.keepmoving.fitness;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// service层使用声明式事务@Transactional
@EnableTransactionManagement
// 开启servlet相关的注解
@ServletComponentScan
// mapper注解
@MapperScan(value = "com.keepmoving.fitness.mapper")
public class FitnessApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessApplication.class, args);
    }

}
