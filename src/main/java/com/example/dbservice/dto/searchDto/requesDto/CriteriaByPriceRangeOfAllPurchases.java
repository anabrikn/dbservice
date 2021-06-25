package com.example.dbservice.dto.searchDto.requesDto;

import com.example.dbservice.dto.searchDto.answerDto.CriteriaResultDto;
import com.example.dbservice.dto.searchDto.answerDto.UserDto;
import com.example.dbservice.entity.Customer;
import com.example.dbservice.repository.CustomerRepository;
import com.example.dbservice.service.Converter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect
public class CriteriaByPriceRangeOfAllPurchases extends Criteria {
    public long minExpenses;
    public long maxExpenses;

    public CriteriaByPriceRangeOfAllPurchases() {
    }

    public CriteriaByPriceRangeOfAllPurchases(long minExpenses, long maxExpenses) {
        this.minExpenses = minExpenses;
        this.maxExpenses = maxExpenses;
    }

    // TODO проверить
    public CriteriaResultDto getCriteriaResult(CustomerRepository customerRepository) {
        List<Customer> list = customerRepository.findByExpense(minExpenses, maxExpenses);
        List<UserDto> userDtoList = Converter.convertListCustomerToListUserDto(list);
        return new CriteriaResultDto(this, userDtoList);
    }

    @Override
    public String toString() {
        return "CriteriaByPriceRangeOfAllPurchases {" +
                "minExpenses = " + minExpenses +
                ", maxExpenses = " + maxExpenses +
                '}';
    }
}
