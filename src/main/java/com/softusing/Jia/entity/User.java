package com.softusing.Jia.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;

}
