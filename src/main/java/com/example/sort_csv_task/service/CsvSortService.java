package com.example.sort_csv_task.service;

import com.example.sort_csv_task.domain.City;

import java.util.List;

public interface CsvSortService {
    List<String> sortStringData();

    List<Integer> sortNumericData();

    List<City> sortCityByStringData();

    List<City> sortCityByNumericData();
}
