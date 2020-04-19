package com.huifer.baseweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
@MapperScan("com.huifer.baseweb.mapper")
public class BaseWebApplication {

  private static ApplicationContext context;

  public static void main(String[] args) {
    context = SpringApplication.run(BaseWebApplication.class, args);
  }

}
