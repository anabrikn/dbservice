package com.example.dbservice.service;

import com.example.dbservice.dto.searchDto.requesDto.Criteria;
import com.example.dbservice.dto.searchDto.requesDto.CriteriaWrapperDto;
import com.example.dbservice.dto.searchDto.answerDto.CriteriaResultDto;
import com.example.dbservice.dto.searchDto.answerDto.SearchAnswerDto;
import com.example.dbservice.repository.CustomerRepository;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCriteriaService implements ProcessingService {
    ClassPathXmlApplicationContext context;
    CustomerRepository customerRepository;

    String inputFile;
    String outputFile;


    @Override
    public void startService(String input, String output) throws Exception {
        this.inputFile = input;
        this.outputFile = output;

        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        customerRepository = context.getBean(CustomerRepository.class);

        List<Criteria> criterias = deserializationJson();

        List<CriteriaResultDto> criteriaResultDtoList = criterias.stream().map(e -> e.getCriteriaResult(customerRepository)).collect(Collectors.toList());

        serializationJson(new SearchAnswerDto(criteriaResultDtoList));
    }


    private List<Criteria> deserializationJson() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            CriteriaWrapperDto wrapper = mapper.readValue(Paths.get(inputFile).toFile(), CriteriaWrapperDto.class);
            List<Criteria> criteriaList = wrapper.criterias;
            return criteriaList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void serializationJson(SearchAnswerDto answerDto) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get(outputFile).toFile(), answerDto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}