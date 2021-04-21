package com.dut.controller;

import com.dut.dto.PageDto;
import com.dut.dto.ResponseDto;
import com.dut.dto.UserDto;

import com.dut.entity.UserExample;
import com.dut.exception.CustomException;
import com.dut.mapper.UserMapper;
import com.dut.service.UserService;
import com.dut.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理-控制器
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


    /**
     * 查询所有用户
     */
    @GetMapping("/list")
    public ResponseDto allUser() {

        UserExample user = new UserExample();
        return ResponseDto.ok(userMapper.selectByExample(user));
    }

    /**
     * 分页查询 用户列表
     * 先用postman测试
     */
    @PostMapping("/pageUser")
    public ResponseDto pageList(@RequestBody PageDto pageDto, HttpServletRequest request){
        ResponseDto response = new ResponseDto();
        userService.list(pageDto);
        return response.ok(pageDto);

    }

    /**
     * 根据id删除用户
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable int id) {
        ResponseDto responseDto = new ResponseDto();
        userService.delete(id);
        return responseDto.ok();
    }



    /**
     * 保存用户
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody UserDto userDto) {
        // 进行简单验证
        if(StringUtils.isEmpty(userDto.getName())) {
            throw new CustomException("用户名不能为空");
        }
        if(StringUtils.isEmpty(userDto.getPassword())) {
            throw new CustomException("密码不能为空");
        }
        if(StringUtils.isEmpty(userDto.getPhone())) {
            throw new CustomException("联系方式不能为空");
        }
        ResponseDto responseDto = new ResponseDto();
        userService.save(userDto);
        return responseDto.ok(userDto);
    }


    /**
     * 重置密码
     */
    @PostMapping("/save-password")
    public ResponseDto editPassword(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        // 校验
        if(StringUtils.isEmpty(userDto.getPassword())){
            throw new CustomException("密码不能为空");
        }
        if (MD5Util.MD5(userDto.getPassword()).equals(userMapper.selectByPrimaryKey(userDto.getId()).getPassword())) {
            throw new CustomException("密码和原密码相同");
        }

        userService.savePassword(userDto);
        return ResponseDto.ok();
    }


}
