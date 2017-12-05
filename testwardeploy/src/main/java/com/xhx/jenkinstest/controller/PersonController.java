package com.xhx.jenkinstest.controller;

import com.xhx.jenkinstest.entity.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhaixing
 * @date 2017/12/5 20:00
 */
@RestController
public class PersonController {

    @RequestMapping(value = "/getPerson")
    public Person getPerson(String id){
        return new Person("111","小明","男",18);
    }
}
