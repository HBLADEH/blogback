package com.pjboy.blogback.authorization.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/***
 *  api 版本控制注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {

  int value(); /* 版本号 */

}
