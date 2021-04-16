package com.dut.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserRoleDto {
    // 用户id
    private int userId;
    // 角色列表
    private List<Integer> roleList;
}
