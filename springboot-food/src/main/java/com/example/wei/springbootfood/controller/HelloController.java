package com.example.wei.springbootfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        String username = "John"; // 假设这是动态获取的用户名
        model.addAttribute("username", username);
        return "hello"; // 这里返回的字符串是指向对应的 JSP 页面名称
    }
}