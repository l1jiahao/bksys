package com.t6.bksys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String account;
    private String password;
    private String role_type;
}
