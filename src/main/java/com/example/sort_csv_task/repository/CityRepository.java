package com.example.sort_csv_task.repository;

import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.repository.custom.CityCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer>, CityCustomRepository {

    @Query(value = "SELECT T.NAME FROM CITY T ORDER BY T.NAME", nativeQuery = true)
    List<String> getSortedStringDataNative();

    @Query(value = "SELECT T.CODE FROM CITY T ORDER BY T.CODE", nativeQuery = true)
    List<Integer> getSortedNumericDataNative();

    @Query(value = "SELECT * FROM CITY T ORDER BY T.NAME", nativeQuery = true)
    List<City> getCitySortedByStringDataNative();

    @Query(value = "SELECT * FROM CITY T ORDER BY T.CODE", nativeQuery = true)
    List<City> getCitySortedByNumericDataNative();
}
