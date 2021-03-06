package com.pjboy.blogback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pjboy.blogback.entity.TAdmin;

import java.util.List;

/**
 * (TAdmin)表服务接口
 *
 * @author makejava
 * @since 2020-04-09 10:32:52
 */
public interface TAdminService extends IService<TAdmin> {
  TAdmin selectByUsername(String username);
  TAdmin selectByUsernameAndPassword(String username, String password);
}