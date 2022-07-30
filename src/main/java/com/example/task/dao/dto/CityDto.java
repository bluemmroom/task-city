package com.example.task.dao.dto;

import lombok.*;

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
public class CityDto {

    private Integer cityCode;

    private String city;
}
