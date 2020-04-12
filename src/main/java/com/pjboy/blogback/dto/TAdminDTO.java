package com.pjboy.blogback.dto;


import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (TAdmin)表实体类
 *
 * @author makejava
 * @since 2020-04-09 10:32:53
 */
@Data
@SuppressWarnings("serial")
public class TAdminDTO implements Serializable {
  
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


}