package com.Spring_Security.Controllers;
import com.Spring_Security.DTOS.UserDto;
import com.Spring_Security.Entities.User;
import com.Spring_Security.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServices userServices ;


//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{name}")
    public ResponseEntity<User> getUserByName (@PathVariable("name") String name ){
         try {
             User user = userServices.getUserByName(name) ;
             return new ResponseEntity<>( user , HttpStatus.FOUND) ;
         } catch (Exception e ){
             return new ResponseEntity<>( null , HttpStatus.NOT_FOUND) ;
         }
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers ( ){
        try {
            List<User> user = userServices.getAllUsers() ;
            return new ResponseEntity<>( user , HttpStatus.FOUND) ;
        } catch ( Exception e ){
            return new ResponseEntity<>( null , HttpStatus.NOT_FOUND) ;
        }
    }


    @PostMapping("/add")
    public ResponseEntity<String> addNewUser (@RequestBody UserDto userDto ){
        try {
            String str  = userServices.addNewUser(userDto) ;
            return new ResponseEntity<>(str , HttpStatus.FOUND) ;
        } catch ( Exception e ) {
            return new ResponseEntity<>( e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }
}
