package com.example.dbservice.dto.searchDto.requesDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect
public class CriteriaWrapperDto {
    public List<Criteria> criterias;
}
