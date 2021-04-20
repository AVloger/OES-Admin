package com.dut.interceptor;

import com.alibaba.fastjson.JSON;
import com.dut.dto.ResponseDto;
import com.dut.exception.CustomException;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果是options则结束请求
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        // 从请求头中获取token
        String token = request.getHeader("token");
//        System.out.println(token);
        // 获取请求路径
        String path = request.getServletPath();
        // 图形验证码、登录、退出登录放行
//        System.out.println(path);
        if (path.contains("/admin/login") ||
                path.contains("/admin/kaptcha") ||
                path.contains("/admin/logout") ||
                path.contains("/swagger") ||
                path.contains("/api-docs")) return true;
        // 请求必须携带token
        if (token == null) throw new CustomException("token为空，请求被拦截");
//        System.out.println("token:"+token);
//        System.out.println(request.getSession().getAttribute("token"));
        if (!token.equals(request.getSession().getAttribute("token"))) throw new CustomException("token无效，请求被拦截");
        // TODO:权限认证
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    //返回错误信息
    private static void setReturn(HttpServletResponse response, int status, String msg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        //UTF-8编码
        httpResponse.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String json = JSON.toJSONString(ResponseDto.error(msg));
        httpResponse.getWriter().print(json);
    }

}
