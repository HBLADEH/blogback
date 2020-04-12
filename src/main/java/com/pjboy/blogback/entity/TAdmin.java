package com.pjboy.blogback.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * (TAdmin)表实体类
 *
 * @author makejava
 * @since 2020-04-09 10:32:51
 */
@Data
@SuppressWarnings("serial")
public class TAdmin extends Model<TAdmin> {
  @TableId(type = IdType.AUTO)
    /**ID*/
    private Integer id;
    /**管理员用户名*/
    private String username;
    /**管理员密码*/
    private String password;
    /**管理员权限*/
    private String just;
    /**创建时间*/
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