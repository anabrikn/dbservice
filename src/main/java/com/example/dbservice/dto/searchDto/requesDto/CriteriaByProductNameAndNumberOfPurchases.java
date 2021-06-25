package com.example.dbservice.dto.searchDto.requesDto;

import com.example.dbservice.dto.searchDto.answerDto.CriteriaResultDto;
import com.example.dbservice.dto.searchDto.answerDto.UserDto;
import com.example.dbservice.entity.Customer;
import com.example.dbservice.repository.CustomerRepository;
import com.example.dbservice.service.Converter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect
public class CriteriaByProductNameAndNumberOfPurchases extends Criteria {
    public String productName;
    public long minTimes;

    public CriteriaByProductNameAndNumberOfPurchases() {
    }

    public CriteriaByProductNameAndNumberOfPurchases(String productName, long minTimes) {
        this.productName = productName;
        this.minTimes = minTimes;
    }

    // TODO проверить
    public CriteriaResultDto getCriteriaResult(CustomerRepository customerRepository) {
        List<Customer> list = customerRepository.findCustomersByPurchaseCount(productName, minTimes);
        List<UserDto> userDtoList = Converter.convertListCustomerToListUserDto(list);
        return new CriteriaResultDto(this, userDtoList);
    }

    @Override
    public String toString() {
        return "CriteriaByProductNameAndNumberOfPurchases{" +
                "productName = '" + productName + '\'' +
                ", minTimes = " + minTimes +
                '}';
    }
}
