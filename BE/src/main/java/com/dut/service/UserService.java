package com.dut.service;


import com.dut.dto.PageDto;
import com.dut.dto.UserDto;
import com.dut.entity.User;
import com.dut.entity.UserExample;
import com.dut.mapper.UserMapper;
import com.dut.util.CopyUtil;
import com.dut.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户分页展示
     * @param pageDto
     */
    public void list(PageDto<User> pageDto) {
        int page = pageDto.getPage();
        int size = pageDto.getSize();
        if(size == -1){
            pageDto.setList(userMapper.selectByExample(new UserExample()));
            pageDto.setTotal(userMapper.countByExample(new UserExample()));
            return ;
        }
        PageHelper.startPage(page, size);
        UserExample userExample = new UserExample();
        List<User> userList = userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo = new PageInfo<>(userList); // 将结果进行封装
        pageDto.setTotal(pageInfo.getTotal());
        pageDto.setList(userList);
    }

    /**
     * 用户保存
     * @param userDto
     */
    public void save(UserDto userDto) {
        User user = CopyUtil.copy(userDto, User.class);
        System.out.println(user);
        user.setPassword(MD5Util.MD5(userDto.getPassword()));
        if(userDto.getId() == null) {
            // 新增
            userMapper.insert(user);
        } else {
//            System.out.println(user);
//            user.setId((int)userDto.getId());
            userMapper.updateByPrimaryKey(user);
        }
    }

    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

}
