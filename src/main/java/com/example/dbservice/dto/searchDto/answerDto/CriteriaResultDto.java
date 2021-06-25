package com.example.dbservice.dto.searchDto.answerDto;

import com.example.dbservice.dto.searchDto.requesDto.Criteria;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonAutoDetect
public class CriteriaResultDto {
    public Criteria criteria;
    @JsonProperty("results")
    List<UserDto> userDto;
    //public UserDto[] userDto;

    public CriteriaResultDto() {
    }

    public CriteriaResultDto(Criteria criteria, List<UserDto> userDto) {
        this.criteria = criteria;
        this.userDto = userDto;
    }
}
