package com.lkq.dao;

import com.lkq.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FindByDao extends JpaRepository<UserJpa,Integer> {


    List<UserJpa> findByName(String name);

    List<UserJpa> findByNameAndAddress(String name ,String address);

    List<UserJpa> findByNameLike(String name);

    List<UserJpa> findByNameContaining(String name);

    List<UserJpa> findByBirGreaterThan(Date bir);

    List<UserJpa> findByNameLikeAndBirGreaterThan(String Name, Date bir);

    List<UserJpa> findByBirLessThan(Date bir);

    List<UserJpa> findByIdIn(List<Integer> ids);

    List<UserJpa> findByBirGreaterThanEqual(Date bir);








}
