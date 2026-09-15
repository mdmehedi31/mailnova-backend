package com.mailnova.core.entity;


import jakarta.persistence.*;

@MappedSuperclass
public class AbstractIdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
