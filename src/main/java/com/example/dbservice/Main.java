package com.example.dbservice;

import com.example.dbservice.service.Operation;
import com.example.dbservice.service.ProcessingService;
import com.example.dbservice.service.SearchCriteriaService;
import com.example.dbservice.service.StatCriteriaService;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, ProcessingService> serviceMap = new HashMap<>();

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new RuntimeException("Вы ввели неверное количество аргументов. Введите 3 аргумента: search input.json output.json");
        }

        Operation operation = getOperation(args);
        initServiceMap();

        try {
            serviceMap.get(operation.name()).startService(args[1], args[2]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Operation getOperation(String[] args) {
        Operation operation;
        try {
            operation = Operation.of(args[0]);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Введите search или stat");
        }
        return operation;
    }

    private static void initServiceMap() {
        serviceMap.put("SEARCH", new SearchCriteriaService());
        serviceMap.put("STAT", new StatCriteriaService());
    }
}