package com.xhx.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService implements IService{

    @Autowired
    private UserService userService;

    public String getTest01(){
        String temp = userService.getTemp();
        return temp;
    }

    public List<String> getAuth(){
        return new ArrayList<>();
    }
}
