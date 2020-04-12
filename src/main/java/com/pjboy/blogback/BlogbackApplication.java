package com.pjboy.blogback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pjboy.blogback.dao")
public class BlogbackApplication {
  public static void main(String[] args) {
    SpringApplication.run(BlogbackApplication.class, args);
  }
}
