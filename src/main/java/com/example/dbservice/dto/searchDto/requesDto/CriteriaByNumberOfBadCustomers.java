package com.example.dbservice.dto.searchDto.requesDto;

import com.example.dbservice.dto.searchDto.answerDto.CriteriaResultDto;
import com.example.dbservice.dto.searchDto.answerDto.UserDto;
import com.example.dbservice.entity.Customer;
import com.example.dbservice.repository.CustomerRepository;
import com.example.dbservice.service.Converter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonAutoDetect
public class CriteriaByNumberOfBadCustomers extends Criteria {
    public int badCustomers;

    public CriteriaByNumberOfBadCustomers() {
    }

    public CriteriaByNumberOfBadCustomers(int badCustomers) {
        this.badCustomers = badCustomers;
    }
    // TODO проверить
    public CriteriaResultDto getCriteriaResult(CustomerRepository customerRepository) {

        List<Object[]> list = customerRepository.findBadCustomer(PageRequest.of(0, badCustomers));

        List<Customer> customerList = new ArrayList<>();
        for (Object[] e : list) {
            Customer o = (Customer) e[0];
            customerList.add(o);
        }

        List<UserDto> userDtoList = Converter.convertListCustomerToListUserDto(customerList);
        return new CriteriaResultDto(this, userDtoList);
    }

    @Override
    public String toString() {
        return "CriteriaByNumberOfBadCustomers {" +
                "badCustomers = " + badCustomers +
                '}';
    }
}
