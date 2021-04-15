package com.dut.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloController {

//    @Autowired
//    private sysCaseMapper sysCaseMapper;

    @GetMapping("/test")
    public String test(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getMaxInactiveInterval());
        return "{\"session时长\":\""+session.getMaxInactiveInterval()+"\"}";
    }

    @GetMapping("/case")
    public String test1() throws ParseException {
//        Date now = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String time = sdf.format(now);
//        sysCase sysCase = new sysCase();
//        sysCase.setCreateTime(time);
//        sysCaseMapper.insert(sysCase);

//        String time1 = sysCaseMapper.selectByPrimaryKey(4).getCreateTime();
//        String time2 = sysCaseMapper.selectByPrimaryKey(6).getCreateTime();
//        System.out.println(time1+"\t"+time2);
//        Date date1 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(time1);
//        Date date2 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(time2);
//        System.out.println(date1+"\t"+date2);
//        long diff = date2.getTime()-date1.getTime();
//        System.out.println(diff/1000);// 秒数
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", "wjw");
//        jsonObject.put("age", 22);
//        jsonObject.put("sex", "男");
//        jsonObject.put("school", "商职");
//        jsonObject.put("plugin", new Integer[]{1,2,3,34});
//        String jsonStr = JSONObject.toJSONString(jsonObject);
//        System.out.println(jsonStr);
//        System.out.println(JSONObject.toJSON(jsonObject));
        return "0";
    }
}
