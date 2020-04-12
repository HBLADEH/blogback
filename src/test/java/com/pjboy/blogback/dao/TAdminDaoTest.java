package com.pjboy.blogback.dao;

import com.pjboy.blogback.dao.TAdminDao;
import com.pjboy.blogback.entity.TAdmin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TAdminDaoTest {

  @Autowired
  private TAdminDao tAdminDao;

  @Test
  public void testTAdmin() {
    System.out.println(("----- selectAll method test ------"));
    List<TAdmin> userList = tAdminDao.selectList(null);
    Assert.assertEquals(3, userList.size());
    userList.forEach(System.out::println);
  }
}