package com.example.task.dao.dto;

import lombok.*;

import java.util.Comparator;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 13:02:44
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CityDto implements Comparable<CityDto> {

    private Integer cityCode;

    private String city;

    @Override
    public int compareTo(CityDto o) {
        return Comparator.comparing(CityDto::getCityCode)
                .thenComparing(CityDto::getCity)
                .compare(this, o);
    }
}
