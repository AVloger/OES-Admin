package com.dut.controller;

import com.dut.dto.ResponseDto;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 图形验证码控制器
 */
@RestController
@RequestMapping("/admin/kaptcha")
public class KaptchaController {
    @Resource(name = "kaptchaProducer")
    private Producer kaptchaProducer;
    @Resource(name = "kaptchaProducerMath")
    private Producer kaptchaProducerMath;

    // 验证码类型
    @Value("${oes.kaptchaType}")
    private String kaptchaType;

    /**
     * 生成验证码
     * @param request
     * @return
     */
    @GetMapping("/getImageCode")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseDto responseDto = new ResponseDto();
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        BufferedImage image = null;
        String kaptchaStr = null;
        String code = null;
        // 生成验证码
        if("math".equals(kaptchaType)) {
            // 数学验证码
            String kaptchaText = kaptchaProducerMath.createText();
            kaptchaStr = kaptchaText.substring(0, kaptchaText.indexOf("@"));
//            System.out.println(kaptchaStr);
            code = kaptchaText.substring(kaptchaText.indexOf("@")+1);
            image = kaptchaProducerMath.createImage(kaptchaStr);
            ImageIO.write(image, "jpg", jpegOutputStream);
        } else if ("char".equals(kaptchaType)){
            // 字符验证码
            String kaptchaText = kaptchaProducer.createText();

        }
//         返回Image
        byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
