package com.dut.controller;

import com.dut.dto.ResponseDto;
import com.dut.mapper.PCMapper;
import com.dut.service.PcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 计算机控制器
 */
@RestController
@RequestMapping("/admin/pc")
public class PcController {
    @Autowired
    private PcService pcService;

    @GetMapping("/list/{groupId}")
    public ResponseDto list(@PathVariable int groupId) {
        ResponseDto responseDto = new ResponseDto();
        return responseDto.ok(pcService.list(groupId));
    }
}
