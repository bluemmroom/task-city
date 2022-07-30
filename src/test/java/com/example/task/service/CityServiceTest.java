package com.example.task.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CityServiceTest {

    @Autowired
    private CityService cityService;
    @Autowired
    private FileReadService fileReadService;

    @Test
    void getBothTypes() {
        Integer actualSize = cityService.getBothTypes().size();
        Integer expectedSize = 50000;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void sortedIntegerList() {
        List<Integer> actualList = cityService.sortedIntegerList();
        List<Integer> expectedList = fileReadService.readIntegerList();

        Integer actualMinInteger = actualList.get(0);
        Integer expectedMinInteger = Collections.min(expectedList);
        assertEquals(expectedMinInteger, actualMinInteger);

        Integer actualMaxInteger = actualList.get(actualList.size() - 1);
        Integer expectedMaxInteger = Collections.max(fileReadService.readIntegerList());
        assertEquals(expectedMaxInteger, actualMaxInteger);
    }

    @Test
    void sortedStringList() {
        List<String> actualList = cityService.sortedStringList();
        List<String> expectedList = fileReadService.readStringList();

        String actualMinString = actualList.get(0);
        String expectedMinString = Collections.min(expectedList);
        assertEquals(expectedMinString, actualMinString);

        String actualMaxString = actualList.get(actualList.size() - 1);
        String expectedMaxString = Collections.max(expectedList);
        assertEquals(expectedMaxString, actualMaxString);
    }
}