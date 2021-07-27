package com.security.security_configurations.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private String roles;
    private boolean active;
}
