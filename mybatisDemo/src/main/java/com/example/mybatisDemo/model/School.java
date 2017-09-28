package com.example.mybatisDemo.model;

import java.io.Serializable;

public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
 
    private long cityID;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCityID() {
        return this.cityID;
    }

    public void setCityID(long country) {
        this.cityID = country;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + getCityID();
    }

}
