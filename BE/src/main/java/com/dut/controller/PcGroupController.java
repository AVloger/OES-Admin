package com.dut.controller;

import com.dut.dto.PcGroupDto;
import com.dut.dto.ResponseDto;
import com.dut.entity.PcGroupExample;
import com.dut.mapper.PcGroupMapper;
import com.dut.service.PcGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 计算机组名
 */
@RestController
@RequestMapping("/admin/group")
public class PcGroupController {
    @Autowired
    private PcGroupMapper pcGroupMapper;
    @Autowired
    private PcGroupService pcGroupService;

    /**
     * 展示所有的组
     * @return
     */
    @GetMapping("/list")
    public ResponseDto list() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto.ok(pcGroupMapper.selectByExample(new PcGroupExample()));
    }

    /**
     * 新增/保存
     * @return
     */
    @PostMapping("save")
    public ResponseDto save(@RequestBody PcGroupDto pcGroupDto) {
        ResponseDto responseDto = new ResponseDto();
        pcGroupService.save(pcGroupDto);
        return responseDto.ok();
    }
}
