package com.pjboy.blogback.controller.v1;

import com.pjboy.blogback.annotation.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: blogback
 * @description: 测试用接口
 * @author: BLADE
 * @create: 2020-04-17 20:21
 **/
@ApiVersion(1)
@RestController
@RequestMapping("{version}/Test")
public class TestController {
  @GetMapping("/hello")
  public String test() {
    return "hello world";
  }
}
