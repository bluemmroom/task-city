package com.example.task.dao.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 13:02:55
 */

@Getter
@Setter
@Entity(name = "city")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cityCode;

    private String city;
}
