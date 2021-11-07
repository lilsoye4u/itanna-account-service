package com.ebipay.controller;

import com.ebipay.model.Status;
import com.ebipay.model.UserAccountDTO;
import com.ebipay.model.UserLoginDTO;
import com.ebipay.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@EnableAutoConfiguration
public class AccountServiceController {

    @Autowired
    IUserAccountService userService;

    @GetMapping("/")
    public String index(){
        return "Hello from Account Service " + LocalDateTime.now();
    }

    @PostMapping("/signup")
    public Status signup(@RequestBody UserAccountDTO userAccount){
        return userService.createUserAccount(userAccount);
    }

    @PostMapping("login")
    public Status login(@RequestBody UserLoginDTO userAccount){
        return userService.authenticate(userAccount);
    }
}
