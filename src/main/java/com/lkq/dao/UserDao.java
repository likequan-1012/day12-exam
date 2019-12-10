package com.lkq.dao;

import com.lkq.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;


interface UserDao extends JpaRepository<UserJpa,Integer> {

}
