package com.dut.service;

import com.dut.dto.PcGroupDto;
import com.dut.entity.PcGroup;
import com.dut.mapper.PcGroupMapper;
import com.dut.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PcGroupService {
    @Autowired
    private PcGroupMapper pcGroupMapper;


    public void save(PcGroupDto pcGroupDto) {
        if(pcGroupDto.getId() == null) {
            // 新增分组
            PcGroup pcGroup = new PcGroup();
            pcGroup.setName(pcGroupDto.getName());
            pcGroupMapper.insert(pcGroup);
        } else {
            // 更新分组
            PcGroup pcGroup = CopyUtil.copy(pcGroupDto, PcGroup.class);
            pcGroupMapper.updateByPrimaryKey(pcGroup);
        }
    }
}
