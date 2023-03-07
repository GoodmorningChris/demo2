package com.example.demo.model;

import lombok.Data;

@Data
public class TensorFlow {
    private String domain;
    private Integer contributions;
    private Integer contributors;

    public TensorFlow(String domain, Integer contributions, Integer contributors) {
        this.domain = domain;
        this.contributions = contributions;
        this.contributors = contributors;
    }
}
