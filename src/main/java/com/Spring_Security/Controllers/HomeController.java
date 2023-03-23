package com.Spring_Security.Controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HomeController {

    @GetMapping("/home")
    public static ResponseEntity<String> homePage (){
        return new ResponseEntity<>("Hey Welcome ! This is our Home page" , HttpStatus.FOUND) ;
    }

    @GetMapping("/login")
    public static ResponseEntity<String> login (){
        return new ResponseEntity<>("Hey Welcome !  Please use username and password for Login  " , HttpStatus.FOUND) ;
    }

    @GetMapping("/register")
    public static ResponseEntity<String> register (){
        return new ResponseEntity<>("Hey Welcome ! You are new in our page so please enter your name and password" , HttpStatus.FOUND) ;
    }
}
