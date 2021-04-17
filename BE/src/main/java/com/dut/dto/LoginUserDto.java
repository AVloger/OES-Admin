package com.dut.dto;

import lombok.Data;

@Data
public class LoginUserDto {
    // 用户id
    private int id;
    // 用户名
    private String name;
    // 密码
    private String password;
    // 验证码
    private String imageCode;
    // token
    private String token;

}
