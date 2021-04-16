package com.dut.controller;

import com.dut.dto.ResponseDto;
import com.dut.dto.UserRoleDto;
import com.dut.entity.UserRole;
import com.dut.mapper.UserRoleMapper;
import com.dut.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

/**
 * 用户-角色 控制器
 */
@RestController
@RequestMapping("/admin/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 根据用户id 获取他的所有角色
     * @param userId
     * @return
     */
    @GetMapping("/roleList/{userId}")
    public ResponseDto getRolesByUserId(@PathVariable int userId) {
        ResponseDto responseDto = new ResponseDto();
        return responseDto.ok(userRoleService.getRolesByUserId(userId));
    }

    /**
     *
     */
    @PostMapping("/saveRoles")
    public ResponseDto saveRoles(@RequestBody UserRoleDto userRoleDto) {
        ResponseDto responseDto = new ResponseDto();
        userRoleService.saveRoles(userRoleDto);
        return responseDto.ok();
    }
}
