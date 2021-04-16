package com.dut.service;

import com.dut.dto.PcDto;
import com.dut.entity.PC;
import com.dut.entity.PCExample;
import com.dut.mapper.PCMapper;
import com.dut.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcService {
    @Autowired
    private PCMapper pcMapper;

    public List<PC> list(int groupId) {
        PCExample pcExample = new PCExample();
        pcExample.createCriteria().andGroupIdEqualTo(groupId);
        List<PC> pcList = pcMapper.selectByExample(pcExample);
        return pcList;

    }

    public void save(PcDto pcDto) {
        PC pc = CopyUtil.copy(pcDto, PC.class);
        if (pc.getId() == null){
            // 新增
            pcMapper.insert(pc);
        } else {
            // 更新
            pcMapper.updateByPrimaryKey(pc);
        }
    }
}
