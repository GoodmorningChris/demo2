package com.example.demo.model;

import lombok.Data;

@Data
public class People {
    private String name;
    private Integer contributions;

    public People(String name, Integer contributions) {
        this.name = name;
        this.contributions = contributions;
    }
}
