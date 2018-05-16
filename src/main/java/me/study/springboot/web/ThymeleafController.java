package me.study.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://test.study.com");
        return "index";
    }

    @RequestMapping("/hello1")
    public String hello() {
        return "hello1";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}