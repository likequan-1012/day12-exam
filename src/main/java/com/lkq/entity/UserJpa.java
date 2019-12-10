package com.lkq.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Table(name = "t_user")
@Entity
public class UserJpa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "bir")
    private Date bir;
    @Column(name = "sex")
    private String sex;
    @Column(name = "address")
    private String address;
    @Column(name = "livefrom")
    private String livefrom;
}
