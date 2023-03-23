package com.Spring_Security.DTOS;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String name ;
    private String password ;
    private String email ;
}
