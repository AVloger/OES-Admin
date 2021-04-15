package com.dut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dut.dto.ResponseDto;
import org.springframework.web.bind.annotation.*;

/**
 * 通信测试类
 */
@RestController
@RequestMapping("/admin/communication")
public class CommunicationTestController {
    /**
     * 获取IP
     * @return
     */
    @RequestMapping("/connect/{ip}")
    public ResponseDto connectServer(@PathVariable String ip) {
        ResponseDto responseDto = new ResponseDto();
        // 获取需要建立见解通信的ip

        return responseDto.ok();
    }
    /**
     * 接收管理员发送的信号，并且转化
     */
    @RequestMapping("/getMsg")
        public ResponseDto getMsg(@RequestBody Object msg){
        JSONObject json = (JSONObject) JSONObject.toJSON(msg);
        System.out.println(json.get("msg"));
        ResponseDto responseDto = new ResponseDto();
        return responseDto.ok();
    }
}
