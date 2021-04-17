package com.dut.controller;

import com.dut.dto.LoginUserDto;
import com.dut.dto.ResponseDto;
import com.dut.entity.User;
import com.dut.entity.UserExample;
import com.dut.mapper.UserMapper;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 登录控制器
 */
@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginUserDto loginUserDto, HttpServletRequest request) {
        ResponseDto responseDto = new ResponseDto();
        String name = loginUserDto.getName();
        String password = loginUserDto.getPassword();
        String imageCode = loginUserDto.getImageCode();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        List<User> userList = userMapper.selectByExample(userExample);
        // 查找该用户
        // 从session中取出验证码
        if(!loginUserDto.getImageCode().equals(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
            return ResponseDto.error("验证码错误");
        } if(userList.size() == 0) {
            return ResponseDto.error("该用户不存在");
        } if(userList.size()!=0 && !userList.get(0).getPassword().equals(password)) {
            return ResponseDto.error("密码错误");
        }
            return ResponseDto.ok();

    }
}

