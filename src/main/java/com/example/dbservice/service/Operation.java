package com.example.dbservice.service;

import java.util.Locale;

public enum Operation {
    SEARCH, STAT;

    public static Operation of(String input) {
        return Operation.valueOf(input.toUpperCase(Locale.ROOT));
    }
}