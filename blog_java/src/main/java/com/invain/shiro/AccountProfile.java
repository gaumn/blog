package com.invain.shiro;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {

    private int id;

    private String username;

    private String avatar;

    private String email;

}
