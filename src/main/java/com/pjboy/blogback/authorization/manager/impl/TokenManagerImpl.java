package com.pjboy.blogback.authorization.manager.impl;

import com.pjboy.blogback.authorization.model.TokenModel;
import com.pjboy.blogback.config.Constants;
import com.pjboy.blogback.authorization.manager.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: blogback
 * @description:
 * @author: BLADE
 * @create: 2020-04-15 13:53
 **/
@Component
public class TokenManagerImpl implements TokenManager {

  private RedisTemplate<Long, String> redis;

  @Autowired
  public void setRedis(@Qualifier("redisTemplate") RedisTemplate redis) {
    this.redis = redis;
    //泛型设置成Long后必须更改对应的序列化方案
    redis.setKeySerializer(new JdkSerializationRedisSerializer());
  }

  @Override
  public TokenModel createToken(long userId) {
    // 使用 UUID 作为源 token
    String token = UUID.randomUUID().toString().replace("-", "");
    TokenModel model = new TokenModel(userId, token);
    // 存储至 redis 并设置过期时间
    redis.boundValueOps(userId).set(token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
    return model;
  }

  @Override
  public TokenModel getToken(String authentication) {
    if (authentication == null || authentication.length() == 0) {
      return null;
    }
    String[] param = authentication.split("_");
    if (param.length != 2) {
      return null;
    }
    // 使用 userId 和源 token 简单拼成的 token, 可以增加加密措施
    long userId = Long.parseLong(param[0]);
    String token = param[1];
    return new TokenModel(userId, token);
  }

  /**
  * @Description: 校验 Token
  * @Param: [model] token
  * @return: boolean
  * @Author: BLADE
  * @Date: 2020/4/21 0021
  */
  @Override
  public boolean checkToken(TokenModel model) {
    if (model == null) return  false;
    String token = redis.boundValueOps(model.getId()).get();
    if (token == null || !token.equals(model.getToken())) {
      return false;
    }
    redis.boundValueOps(model.getId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
    return true;
  }

  /**
  * @Description: 删除 token
  * @Param: [userid] 用户 id
  * @return: void
  * @Author: BLADE
  * @Date: 2020/4/21 0021
  */
  @Override
  public void deleteToken(long userId) {
    redis.delete(userId);
  }
}
