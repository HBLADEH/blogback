package com.pjboy.blogback.authorization.model;

import lombok.Data;

/**
 * @program: blogback
 * @description: Token 的 Model 类
 * @author: BLADE
 * @create: 2020-04-15 09:46
 **/
@Data

public class TokenModel {

  // 用户 id
  private long id;

  // 随机生成的 token
  private String token;

  public TokenModel(long id, String token) {
    this.id = id;
    this.token = token;
  }
}
