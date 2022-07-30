package com.example.task.repo;

import com.example.task.dao.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: @bluemmroom
 * Date: 30.07.2022
 * Time: 15:31:50
 */

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    @Query(value = "select city_code from city order by city_code", nativeQuery = true)
    List<Integer> findAllCityCode();

    @Query(value = "select city from city order by city", nativeQuery = true)
    List<String> findAllCity();
}
