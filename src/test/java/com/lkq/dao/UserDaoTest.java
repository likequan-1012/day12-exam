package com.lkq.dao;

import com.lkq.entity.UserJpa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void tset01(){
       /* UserJpa userJpa = new UserJpa();
        userJpa.setName("张三");
        userJpa.setSex("男");



        userDao.saveAndFlush(userJpa);*/

        /*Optional<UserJpa> byId = userDao.findById(1);

        UserJpa userJpa = byId.get();

        userJpa.setAddress("上海");

        userJpa.setLivefrom("伊拉克");

        userDao.saveAndFlush(userJpa);*/




       /* List<UserJpa> all = userDao.findAll();

        all.forEach(list->{

            System.out.println(list);
        });*/


        userDao.deleteById(1);
    }
}