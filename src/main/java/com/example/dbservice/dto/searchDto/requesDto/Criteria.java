package com.example.dbservice.dto.searchDto.requesDto;

import com.example.dbservice.dto.searchDto.answerDto.CriteriaResultDto;
import com.example.dbservice.repository.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;

@JsonSubTypes( {@Type(CriteriaByLastName.class),
        @Type(CriteriaByProductNameAndNumberOfPurchases.class),
        @Type(CriteriaByPriceRangeOfAllPurchases.class),
        @Type(CriteriaByNumberOfBadCustomers.class)})
@JsonTypeInfo(use=DEDUCTION)
public abstract class Criteria {

    public abstract CriteriaResultDto getCriteriaResult(CustomerRepository customerRepository);

}
