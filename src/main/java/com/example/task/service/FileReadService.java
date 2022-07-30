package com.example.task.service;

import com.example.task.dao.dto.CityDto;
import com.example.task.enums.CsvHeaderEnum;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 13:04:02
 */

@Component
public class FileReadService {

    @Value("${file-path}")
    private String filePath;

    public List<Integer> readIntegerList() {
        List<Integer> list = new ArrayList<>();
        Iterable<CSVRecord> records = getCsvRecord();
        if (records == null) {
            return list;
        }
        for (CSVRecord record : records) {
            list.add(Integer.valueOf(record.get(CsvHeaderEnum.CITY_CODE.getValue())));
        }
        return list;
    }

    public List<String> readStringList() {
        List<String> list = new ArrayList<>();
        Iterable<CSVRecord> records = getCsvRecord();
        if (records == null) {
            return list;
        }
        for (CSVRecord record : records) {
            list.add(record.get(CsvHeaderEnum.CITY.getValue()));
        }
        return list;
    }

    protected List<CityDto> readBothTypes() {
        List<CityDto> list = new ArrayList<>();
        Iterable<CSVRecord> records = getCsvRecord();
        if (records == null) {
            return list;
        }
        for (CSVRecord record : records) {
            list.add(new CityDto(Integer.valueOf(record.get(CsvHeaderEnum.CITY_CODE.getValue())),
                    record.get(CsvHeaderEnum.CITY.getValue())));
        }
        return list;
    }

    private Iterable<CSVRecord> getCsvRecord() {
        Iterable<CSVRecord> records = null;
        try {
            Reader in = new FileReader(filePath);
            records = CSVFormat.DEFAULT.withHeader(CsvHeaderEnum.CITY_CODE.getValue(), CsvHeaderEnum.CITY.getValue()).withFirstRecordAsHeader().parse(in);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return records;
    }

}
