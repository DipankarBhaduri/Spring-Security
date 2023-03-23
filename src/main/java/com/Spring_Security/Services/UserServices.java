package com.Spring_Security.Services;
import com.Spring_Security.Converters.UserConverters;
import com.Spring_Security.DTOS.UserDto;
import com.Spring_Security.Entities.User;
import com.Spring_Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository ;

    public User getUserByName ( String name ) {
        List<User> userList = userRepository.findAll() ;
        User user = null ;

        for ( User user1 : userList ){
            if ( user1.getName().equals(name)){
                user = user1 ;
                break ;
            }
        }
        return user ;
    }


    public List<User> getAllUsers (){
        List < User > user2 = userRepository.findAll() ;
        return user2 ;
    }

    public String  addNewUser (UserDto userDto ){
        User user = UserConverters.convertUserDtoToUserEntity(userDto) ;
        userRepository.save(user) ;
        return userDto.getName()+" added successfully" ;
    }
}
