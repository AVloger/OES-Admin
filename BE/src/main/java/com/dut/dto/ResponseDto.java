package com.dut.dto;

import lombok.Data;

/**
 * 返回结果封装
 */
@Data
public class ResponseDto {
    /**
     * 业务上的成功或者失败
     */
    private boolean success = true;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private Object content;


    /**
     * 请求成功
     */
    public static ResponseDto ok(Object content) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(200);
        responseDto.setContent(content);
        return responseDto;
    }
    public static ResponseDto ok() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(200);
        return responseDto;
    }

    /**
     * 请求失败
     */
    public static ResponseDto error() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setSuccess(false);
        responseDto.setCode(500);
        return responseDto;
    }
}
