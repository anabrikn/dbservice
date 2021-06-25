package com.example.dbservice.service;

import com.example.dbservice.repository.CustomerRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StatCriteriaService implements ProcessingService {
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

    }
}
