package com.Spring_Security.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SigninController {

    @GetMapping("/signin")
    public String signin (){
        return "/login.html" ;
    }
}
