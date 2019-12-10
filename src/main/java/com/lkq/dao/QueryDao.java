package com.lkq.dao;

import com.lkq.entity.UserJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QueryDao extends JpaRepository<UserJpa, Integer> {

    @Query(value = "select * from t_user where id = ? and name like concat('%',?,'%')",nativeQuery = true)
    List<UserJpa> getUserList(Integer id,String name);

    @Query(value = "select * from t_user where id= :id and name like concat('%',:name,'%')",nativeQuery = true)
    List<UserJpa> getList(@Param("name")String name,@Param("id") Integer id);

    @Query(value = "select * from t_user where id= :#{#UserJpa.id} and name like CONCAT('%',:#{#UserJpa.name},'%')",nativeQuery = true)
    List<UserJpa> getUser(@Param("UserJpa") UserJpa UserJpa);

    //测试query查询的分页
    @Query(value = "select * from user where id= :#{#UserJpa.id} and name like CONCAT('%',:#{#UserJpa.userName},'%')",nativeQuery = true)
    Page<UserJpa> getListPage(@Param("UserJpa") UserJpa UserJpa, Pageable pageable);

    //测试query的更新操作
    @Query(value = "update t_user set name=? where id=?",nativeQuery = true)
    @Modifying
    @Transactional
    void updateUser(String name,Integer id);

    @Modifying
    @Transactional
    @Query(value = "insert into t_user  set name = ?",nativeQuery = true)
    void insertUser(String name);

    @Query(value = "delete from t_user where id=?",nativeQuery = true)
    @Modifying
    @Transactional
    void deleteUser(Integer id);

}
