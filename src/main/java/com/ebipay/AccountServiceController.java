package com.ebipay;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@EnableAutoConfiguration
public class AccountServiceController {

    @GetMapping("/")
    public String index(){
        return "Hello from Account Service " + LocalDateTime.now();
    }
}
