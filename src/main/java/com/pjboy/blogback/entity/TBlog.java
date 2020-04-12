package com.pjboy.blogback.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (TBlog)表实体类
 *
 * @author makejava
 * @since 2020-04-09 17:12:30
 */
@Data
@SuppressWarnings("serial")
public class TBlog extends Model<TBlog> {
  @TableId(type = IdType.AUTO)
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


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }