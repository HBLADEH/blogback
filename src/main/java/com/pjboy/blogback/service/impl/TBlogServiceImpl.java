package com.pjboy.blogback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjboy.blogback.dao.TBlogDao;
import com.pjboy.blogback.entity.TBlog;
import com.pjboy.blogback.service.TBlogService;
import org.springframework.stereotype.Service;

/**
 * (TBlog)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 17:12:30
 */
@Service("tBlogService")
public class TBlogServiceImpl extends ServiceImpl<TBlogDao, TBlog> implements TBlogService {

}