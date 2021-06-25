package com.example.dbservice.dto.searchDto.answerDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect
public class SearchAnswerDto {
    public String type = "search";
    public List<CriteriaResultDto> results;

    public SearchAnswerDto() {
    }

    public SearchAnswerDto(List<CriteriaResultDto> results) {
        this.results = results;
    }
}
