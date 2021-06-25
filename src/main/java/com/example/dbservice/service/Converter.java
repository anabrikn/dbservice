package com.example.dbservice.service;

import com.example.dbservice.dto.searchDto.answerDto.UserDto;
import com.example.dbservice.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    // TODO создать метод для конвертации customer в UserDto (сразу массивом?)

    public static UserDto convertCustomerToUserDto(Customer customer) {
        UserDto u = new UserDto(customer.getLastName(), customer.getFirstName());
        return u;
    }

    public static List<UserDto> convertListCustomerToListUserDto(List<Customer> customer) {
        List<UserDto> resultList = customer.stream()
                .map(Converter::convertCustomerToUserDto) // new UserDto(e.getLastName(), e.getFirstName())
                .collect(Collectors.toList());


        return resultList;
    }
}
/*
        List<UserDto> converted = new ArrayList<>();
        UserDto u;
        for (Customer c : customer) {
            u = convertCustomerToUserDto(c);
            converted.add(u);
        }
         */