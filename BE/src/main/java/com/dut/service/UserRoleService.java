package com.dut.service;

import com.dut.dto.UserRoleDto;
import com.dut.entity.Role;
import com.dut.entity.UserRole;
import com.dut.entity.UserRoleExample;
import com.dut.mapper.UserRoleMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 根据用户id获取角色列表
     * @param userId
     * @return
     */
    public List<Integer> getRolesByUserId(int userId) {
        List<Integer> result = new ArrayList<>();
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);
        List<UserRole> list = userRoleMapper.selectByExample(userRoleExample);
        for (UserRole userRole : list) {
            result.add(userRole.getRoleId());
        }
        return result;
    }


    public void saveRoles(UserRoleDto userRoleDto) {
        // 获取用户id
        int userId = userRoleDto.getUserId();
        // 获取改变之后的角色列表
        List<Integer> roleList = userRoleDto.getRoleList();
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);
        // 已经存在的userRole 列表
        List<UserRole> list = userRoleMapper.selectByExample(userRoleExample);
        // 先删
        for (UserRole userRole : list) {
            if (!roleList.contains(userRole.getRoleId())) {
                // 说明不需要这个角色了
                userRoleMapper.deleteByPrimaryKey(userRole.getId());
            } else {
                // 如果有重复的
                roleList.remove(userRole.getRoleId());
            }
        }
        // 添加新的角色
        for (Integer roleId : roleList) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        }
    }
}
