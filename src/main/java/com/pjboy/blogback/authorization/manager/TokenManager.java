package com.pjboy.blogback.authorization.manager;


import com.pjboy.blogback.authorization.model.TokenModel;

/**
 * 对 Token 进行操作的接口
 */
public interface TokenManager {

  /**
  * @Description: 根据指定的用户 id 和登录时间,创建一个 Token
  * @Param: 用户 id, 登录时间
  * @return: com.pjboy.blogback.model.TokenModel
  * @Author: BLADE
  * @Date: 2020/4/15 0015
  */
  public TokenModel createToken(long userId);

  /**
  * @Description: 检查 Token 是否有效
  * @Param: Token 模型
  * @return: boolean
  * @Author: BLADE
  * @Date: 2020/4/15 0015
  */
  public boolean checkToken(TokenModel model);

  /**
  * @Description: 把获取倒的 Token 字符串转换成 Token模型
  * @Param: Token 字符串
  * @return: com.pjboy.blogback.model.TokenModel
  * @Author: BLADE
  * @Date: 2020/4/15 0015
  */
  public TokenModel getToken(String token);

  /**
  * @Description: 根据 userId 删除指定 Token
  * @Param: 用户 Id
  * @return: void
  * @Author: BLADE
  * @Date: 2020/4/15 0015
  */
  public void deleteToken(long userId);
}
