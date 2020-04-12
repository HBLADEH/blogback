package com.pjboy.blogback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjboy.blogback.dao.TAdminDao;
import com.pjboy.blogback.entity.TAdmin;
import com.pjboy.blogback.service.TAdminService;
import org.springframework.stereotype.Service;

/**
 * (TAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 10:32:53
 */
@Service("tAdminService")
public class TAdminServiceImpl extends ServiceImpl<TAdminDao, TAdmin> implements TAdminService {

}