package com.example.task.service;

import com.example.task.dao.dto.CityDto;
import com.example.task.dao.entity.CityEntity;
import com.example.task.dao.mapper.CityMapper;
import com.example.task.repo.CityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 15:14:52
 */

@Service
public class CityService {

    private final FileReadService fileReadService;
    private final CityMapper cityMapper;
    private final CityRepository cityRepository;

    public CityService(FileReadService fileReadService,
                       CityMapper cityMapper,
                       CityRepository cityRepository) {
        this.fileReadService = fileReadService;
        this.cityMapper = cityMapper;
        this.cityRepository = cityRepository;
    }

    @Transactional
    public List<CityEntity> loadingToDB() {
        return cityRepository.saveAll(cityMapper.listDtoToEntity(fileReadService.readBothTypes()));
    }

    public List<CityDto> getBothTypes(){
       return new LinkedList<>(fileReadService.readBothTypes());
    }

    public List<Integer> sortedIntegerList() {
        List<Integer> list = new LinkedList<>(fileReadService.readIntegerList());
        Collections.sort(list);
        return list;
    }

    public List<String> sortedStringList() {
        List<String> list = new LinkedList<>(fileReadService.readStringList());
        Collections.sort(list);
        return list;
    }

}
