package com.example.sort_csv_task.service.impl;

import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.repository.CityRepository;
import com.example.sort_csv_task.service.CsvSortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbSortApproach2 implements CsvSortService {
    private final CityRepository cityRepository;

    @Override
    public List<String> sortStringData() {
        return cityRepository.getSortedStringDataNative();
    }

    @Override
    public List<Integer> sortNumericData() {
        return cityRepository.getSortedNumericDataNative();
    }

    @Override
    public List<City> sortCityByStringData() {
        return cityRepository.getCitySortedByStringDataNative();
    }

    @Override
    public List<City> sortCityByNumericData() {
        return cityRepository.getCitySortedByNumericDataNative();
    }
}
