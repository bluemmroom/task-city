package com.example.task.dao.mapper;

import com.example.task.dao.dto.CityDto;
import com.example.task.dao.entity.CityEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 15:30:08
 */

@Component
public class CityMapper {

    public List<CityEntity> listDtoToEntity(List<CityDto> dto) {
        return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    private CityEntity dtoToEntity(CityDto dto) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCityCode(dto.getCityCode());
        cityEntity.setCity(dto.getCity());
        return cityEntity;
    }
}
