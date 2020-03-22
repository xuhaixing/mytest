package com.xhx.springmvc.controller;

import com.xhx.springmvc.service.AuthService;
import com.xhx.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    public DemoController(){
        System.out.println("xxxxxxxxxx加载了");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test(){
        return "test";
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService);
        System.out.println(authService);
    }
}
