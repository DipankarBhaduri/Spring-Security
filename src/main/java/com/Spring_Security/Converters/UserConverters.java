package com.Spring_Security.Converters;

import com.Spring_Security.DTOS.UserDto;
import com.Spring_Security.Entities.User;

public class UserConverters {
    public static User convertUserDtoToUserEntity (UserDto userDto){
        User user = User.builder()
                .name(userDto.getName())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build();

        return user ;
    }
}
