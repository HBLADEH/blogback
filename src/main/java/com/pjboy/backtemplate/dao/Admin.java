package com.pjboy.backtemplate.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_admin")
public class Admin {
  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false,length = 32)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false,length = 32)
  private String just;

  @Column(nullable = false)
  private Date createtime;
}
