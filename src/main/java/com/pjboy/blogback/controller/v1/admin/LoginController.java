package com.pjboy.blogback.controller.v1.admin;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.pjboy.blogback.annotation.ApiVersion;
import com.pjboy.blogback.authorization.model.TokenModel;
import com.pjboy.blogback.entity.TAdmin;
import com.pjboy.blogback.service.TAdminService;
import com.pjboy.blogback.authorization.manager.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @program: blogback
 * @description: 登录控制层
 * @author: BLADE
 * @create: 2020-04-21 14:31
 **/
@ApiVersion(1)
@RestController
@RequestMapping("{version}/Login")
public class LoginController extends ApiController {

  @Autowired
  TAdminService tAdminService;

  @Autowired
  private TokenManager tokenManager;

  /**
  * @Description: 登录验证,判断用户名密码是否正确,正确就给予 token
  * @Param: [username, password]
  * @return: com.baomidou.mybatisplus.extension.api.R
  * @Author: BLADE
  * @Date: 2020/4/22 0022
  */
  @PostMapping
  public R login(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password) {
    Assert.notNull(username, "username can not be null");
    Assert.notNull(password, "password can not be null");
    TAdmin tAdmin = tAdminService.selectByUsername(username);
    if (tAdmin == null || !tAdmin.getPassword().equals(password)) {
      // 用户名或密码错误
      return failed("用户名或密码错误");
    }
    TokenModel model = tokenManager.createToken(tAdmin.getId());
    return success(model);
  }

  @GetMapping
  public R test() {
    return success("123123");
  }

  /**
  * @Description: 登出账号,销毁 token
  * @Param: [admin]
  * @return: com.baomidou.mybatisplus.extension.api.R
  * @Author: BLADE
  * @Date: 2020/4/22 0022
  */
  @DeleteMapping
  public R logout (TAdmin admin) {
    tokenManager.deleteToken(admin.getId());
    return success("成功删除 token");
  }
}
