package com.pjboy.blogback.dto;


import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (TBlog)表实体类
 *
 * @author makejava
 * @since 2020-04-09 17:12:30
 */
@Data
@SuppressWarnings("serial")
public class TBlogDTO implements Serializable {
  
    /**ID*/
    private Integer id;
    /**标题*/
    private String title;
    /**封面*/
    private String coverpic;
    /**点击量*/
    private Integer hits;
    /**内容*/
    private String content;
    /**新闻事件*/
    private Date newstime;
    /**添加事件*/
    private Date createtime;


}