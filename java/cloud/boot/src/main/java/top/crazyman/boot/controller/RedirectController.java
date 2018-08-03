package top.crazyman.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/25
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@Controller
public class RedirectController {

    private final static String LOAN_SITE = "https://www.baidu.com";

    @RequestMapping("/api/redirect")
    public void loanRedirect(HttpServletResponse response) {
        try {
            response.sendRedirect(LOAN_SITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
