package com.dut.exception.handler;

import com.dut.dto.ResponseDto;
import com.dut.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public ResponseDto exceptionHandler(HttpServletResponse response, HttpServletRequest request, Exception e) {
        if (e instanceof CustomException){
            System.out.println("怎么样");
            return ResponseDto.error(((CustomException) e).getMsg());
        } else {
            return ResponseDto.error();
        }
    }
}
