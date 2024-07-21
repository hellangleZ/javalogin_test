package com.example.passkeylogindemo.controller;

import com.example.passkeylogindemo.model.User;
import com.example.passkeylogindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * 用户控制器类，处理注册和登录请求。
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // 首页路径映射
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 登录页面路径映射
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 登录请求处理
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<User> userOptional = userService.findUserByUsernameAndPassword(username, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("message", "用户 " + username + " 登录成功。");
        } else {
            model.addAttribute("message", "用户名或密码错误。");
        }
        return "login";
    }

    // 注册请求处理
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            userService.registerUser(username, password);
            model.addAttribute("message", "用户 " + username + " 注册成功。");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            model.addAttribute("message", "用户注册失败。");
        }
        return "login";
    }
}
