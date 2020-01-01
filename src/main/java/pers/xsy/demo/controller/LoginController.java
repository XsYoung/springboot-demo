package pers.xsy.demo.controller;


import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Administrator
 */
@Controller
public class LoginController {

    @RequestMapping("/loginPage")
    public String hello() {
        return "/login";
    }

    public static void main(String[] args) {
        Map map = Maps.newHashMap();
        System.out.printf("%#x",15);
        System.out.println();
        boolean flag = false;
        if (!flag) {

        }
    }
}
