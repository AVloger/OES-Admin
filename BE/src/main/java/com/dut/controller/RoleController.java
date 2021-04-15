package com.dut.controller;

import com.dut.dto.ResponseDto;
import com.dut.entity.RoleExample;
import com.dut.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色 控制器
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有的角色
     */
    @GetMapping("/list")
    public ResponseDto roleList() {
        RoleExample role = new RoleExample();
        return ResponseDto.ok(roleMapper.selectByExample(role));
    }

}
