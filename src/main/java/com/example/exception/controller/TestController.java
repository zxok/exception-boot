package com.example.exception.controller;

import com.example.exception.common.ResponseEntity;
import com.example.exception.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Pattern;
import javax.xml.transform.Result;

/**
 * @program: exception
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-11-05 19:53
 **/
@RestController
public class TestController {

    @Resource
    TestService service;

    @GetMapping("/test")
    public ResponseEntity<Object> test(@DecimalMax("2") int id) {
        return service.login(id);
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@Pattern(regexp = "^[A-Z]{2}$", message = "格式有误") String username, String password) {
        Result result;
        return ResponseEntity.error(222,username,password);
    }

    @PostMapping("register")
    public ResponseEntity<Object> register(String username, String password) {

        return null;
    }

}
