package com.dut.controller;

import com.dut.dto.ResponseDto;
import com.dut.entity.RoleExample;
import com.dut.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制器
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获取所有角色列表
     */
    @GetMapping("/list")
    public ResponseDto getRoleList() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto.ok(roleMapper.selectByExample(new RoleExample()));
    }

}
