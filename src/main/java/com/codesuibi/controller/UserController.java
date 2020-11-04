package com.codesuibi.controller;


import com.codesuibi.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {



    //生成验证码
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //1.获取随机数据
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.将数字放入session
        session.setAttribute("code", code);
        //3.生成验证码图片
        VerifyCodeUtils.outputImage(220, 60, response.getOutputStream(), code);
    }

}
