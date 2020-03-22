package com.xhx.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService{

    @Autowired
    private AuthService authService;

    public String getUser(){
        List<String> auth = authService.getAuth();
        return "aaa";
    }
    public String getTemp(){
        return "bbb";
    }
}
