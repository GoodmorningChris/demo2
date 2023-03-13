package com.example.demo.model;

import lombok.Data;

@Data
public class PeoAndCom {
    private String Domains;
    private Integer Contributors;

    public PeoAndCom(String domains, Integer contributors) {
        Domains = domains;
        Contributors = contributors;
    }
}
