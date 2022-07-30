package com.example.task.controller;

import com.example.task.dao.dto.CityDto;
import com.example.task.dao.entity.CityEntity;
import com.example.task.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.task.cons.ProjectEndpoints.*;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 13:15:34
 */

@RestController
@RequestMapping(API_TYPE)
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /** point a */
    @GetMapping(INTEGER)
    public ResponseEntity<List<Integer>> getIntegerType() {
        return ResponseEntity.ok(cityService.sortedIntegerList());
    }
    /** point b */
    @GetMapping(STRING)
    public ResponseEntity<List<String>> getStringType() {
        return ResponseEntity.ok(cityService.sortedStringList());
    }
    /** point d */
    @GetMapping(BOTH)
    public ResponseEntity<List<CityDto>> getBothType() {
        return ResponseEntity.ok(cityService.getBothTypes());
    }
    /** point f */
    @GetMapping(DATABASE)
    public ResponseEntity<List<CityEntity>> getDatabase() {
        return ResponseEntity.ok(cityService.loadingToDB());
    }


}
