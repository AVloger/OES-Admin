package com.dut.controller;

import com.dut.dto.PcDto;
import com.dut.dto.ResponseDto;
import com.dut.mapper.PCMapper;
import com.dut.service.PcService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public ResponseDto save(@RequestBody PcDto pcDto){
        ResponseDto responseDto = new ResponseDto();
        pcService.save(pcDto);
        return responseDto.ok();
    }
}
