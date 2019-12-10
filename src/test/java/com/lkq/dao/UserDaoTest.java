package com.lkq.dao;

import com.alibaba.fastjson.JSON;
import com.lkq.entity.UserJpa;
import com.lkq.service.QueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

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

    @Autowired
    private FindByDao findByDao;

    @Test
    public void tset02(){


       /*
       *通过名称查询
        List<UserJpa> 张三 = findByDao.findByName("张三");
        System.out.println(JSON.toJSONString(张三));*/


       /*
        *联合查询
        List<UserJpa> byNameAndAddress = findByDao.findByNameAndAddress("王三", "三河");
        System.out.println(JSON.toJSONString(byNameAndAddress));*/

       /*
       *模糊查询
       List<UserJpa> 三 = findByDao.findByNameLike("%三%");
        System.out.println(JSON.toJSONString(三));
        List<UserJpa> 三 = findByDao.findByNameContaining("三");
        */

        /*
        *大于查询
        List<UserJpa> byBirGreaterThan = findByDao.findByBirGreaterThan(new Date());
        System.out.println(byBirGreaterThan.size());*/


        /*
        *大于等于查询
        List<UserJpa> byBirGreaterThanEqual = findByDao.findByBirGreaterThanEqual(new Date());
        System.out.println(byBirGreaterThanEqual.size());*/




        /*
        *条件模糊查询
        * List<UserJpa> byNameLikeAndBirGreaterThan = findByDao.findByNameLikeAndBirGreaterThan("%张三%", new Date());
        byNameLikeAndBirGreaterThan.forEach(a->{
            Date bir = a.getBir();
            System.out.println(a);
        });*/
    }

    @Test
    public void Tsest03(){
       /*
        *批量操作
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<UserJpa> byIdIn = findByDao.findByIdIn(list);
        System.out.println(byIdIn);*/


        /*
        *分页+排序
        PageRequest of = PageRequest.of(0, 2, Sort.by(Sort.Order.desc("bir")));
        Page<UserJpa> all = findByDao.findAll(of);
        System.out.println(all.getContent());*/

    }

    @Autowired
    private QueryDao queryDao;

    @Test
    public void Test04(){
        /*List<UserJpa> list = queryDao.getUserList(2, "三");

        System.out.println(list);*/

        /*List<UserJpa> 张三 = queryDao.getList("张三", 2);
        System.out.println(张三);*/

        /*
        *分页
        UserJpa userJpa = new UserJpa();
        userJpa.setId(2);
        userJpa.setName("张三");
        List<UserJpa> user = queryDao.getUser(userJpa);
        System.out.println(user);

        PageRequest of = PageRequest.of(0, 2);
        queryDao.getListPage(userJpa,of);*/

        /**
         * 修改
         */
        queryDao.updateUser("吕欣卓",2);

        /**
         * 删除
         */
        queryDao.deleteUser(1);
    }

    @Autowired
    private EntityManager entityManager;
    @Test
    public void Test05(){
        UserJpa userJpa = new UserJpa();
        userJpa.setId(2);
        userJpa.setName("王");
        userJpa.setBir(new Date());

        String sql = "select * from t_user where 1=1";

        String count="select count(1) from t_user t where 1=1";

        String str = "";

        if (userJpa.getId()!=null){
            str=str+" and id >"+userJpa.getId();
        }

        if (userJpa.getName()!=null&&!"".equals(userJpa.getName())){
            str=str+" and name like '%"+userJpa.getName()+"%'";
        }

        Query nativeQuery = entityManager.createNativeQuery(sql + str,UserJpa.class);
        List<UserJpa> resultList = nativeQuery.getResultList();
        resultList.forEach(System.out::println);
        System.out.println(resultList.toString());
    }

    @Autowired
    private  QueryService queryService;

    @Test
    public void Test06(){
        queryService.insertUser("李小龙");
    }

}