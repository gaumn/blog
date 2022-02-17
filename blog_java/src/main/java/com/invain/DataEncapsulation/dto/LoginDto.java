package com.invain.DataEncapsulation.dto;

import lombok.Data;


import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    private String nickName;

    private String password;
}
