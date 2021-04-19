package com.dut.controller;

import com.dut.dto.LoginUserDto;
import com.dut.dto.ResponseDto;
import com.dut.entity.User;
import com.dut.entity.UserExample;
import com.dut.mapper.UserMapper;
import com.dut.util.MD5Util;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * 登录控制器
 */
@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginUserDto loginUserDto, HttpServletRequest request, HttpServletResponse response) {
        ResponseDto responseDto = new ResponseDto();
        String name = loginUserDto.getName();
        String password = loginUserDto.getPassword();
//        String imageCode = loginUserDto.getImageCode();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(name);
        List<User> userList = userMapper.selectByExample(userExample);
        // 查找该用户
        // 从session中取出验证码
//        System.out.println("登录验证码为:"+request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
        if(!loginUserDto.getImageCode().equals(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
            return ResponseDto.error("验证码错误");
        } if(userList.size() == 0) {
            return ResponseDto.error("该用户不存在");
        } if(userList.size()!=0 && !userList.get(0).getPassword().equals(MD5Util.MD5(password))) {
            return ResponseDto.error("密码错误");
        }
        // 登录成功后 移除验证码
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 设置token
        String token = String.valueOf(UUID.randomUUID());
        request.getSession().setAttribute("token",token);
//        response.setHeader("token", token);
        loginUserDto.setToken(token);
        return ResponseDto.ok(loginUserDto);
    }


    /**
     * 退出登录
     */
    @GetMapping("/logout")
    public ResponseDto logout(HttpServletRequest request) {
        // 从请求中获取token
        String token = request.getHeader("token");
        System.out.println(token);
        return ResponseDto.ok();
    }
}

