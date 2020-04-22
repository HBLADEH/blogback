package com.pjboy.blogback.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjboy.blogback.dao.TAdminDao;
import com.pjboy.blogback.entity.TAdmin;
import com.pjboy.blogback.service.TAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 10:32:53
 */
@Service("tAdminService")
public class TAdminServiceImpl extends ServiceImpl<TAdminDao, TAdmin> implements TAdminService {

  /**
   * 服务对象
   */
  @Resource
  private TAdminDao tAdminDao;

  public TAdmin selectByUsername(String username) {
    QueryWrapper<TAdmin> tAdminQueryWrapper = new QueryWrapper<TAdmin>();

    tAdminQueryWrapper.eq("username", username);

    return tAdminDao.selectOne(tAdminQueryWrapper);
  }

  @Override
  public TAdmin selectByUsernameAndPassword(String username, String password) {

    QueryWrapper<TAdmin> tAdminQueryWrapper = new QueryWrapper<TAdmin>();

    tAdminQueryWrapper.eq("username", username);
    tAdminQueryWrapper.eq("password", password);

    return tAdminDao.selectOne(tAdminQueryWrapper);
  }
}