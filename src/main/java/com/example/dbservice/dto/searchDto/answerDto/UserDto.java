package com.example.dbservice.dto.searchDto.answerDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class UserDto {
    public String lastName;
    public String firstName;


    public UserDto() {
    }

    public UserDto(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
