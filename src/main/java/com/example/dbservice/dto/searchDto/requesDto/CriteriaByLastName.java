package com.example.dbservice.dto.searchDto.requesDto;

import com.example.dbservice.dto.searchDto.answerDto.CriteriaResultDto;
import com.example.dbservice.dto.searchDto.answerDto.UserDto;
import com.example.dbservice.entity.Customer;
import com.example.dbservice.repository.CustomerRepository;
import com.example.dbservice.service.Converter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect
public class CriteriaByLastName extends Criteria {
    public String lastName;

    public CriteriaByLastName() {
    }

    public CriteriaByLastName(String lastName) {
        this.lastName = lastName;
    }

    // TODO проверить
    public CriteriaResultDto getCriteriaResult(CustomerRepository customerRepository) {
        List<Customer> list = customerRepository.findByLastName(lastName);
        List<UserDto> userDtoList = Converter.convertListCustomerToListUserDto(list);
        return new CriteriaResultDto(this, userDtoList);
    }

    @Override
    public String toString() {
        return "CriteriaByLastNameDto{" +
                "lastName = '" + lastName + '\'' +
                '}';
    }
}
