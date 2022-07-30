package com.example.task.enums;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 13:47:05
 */

public enum CsvHeaderEnum {
    CITY_CODE("city_code"),
    CITY("city");

    private String value;

    public String getValue() {
        return value;
    }

    CsvHeaderEnum(String value) {
        this.value = value;
    }
}
