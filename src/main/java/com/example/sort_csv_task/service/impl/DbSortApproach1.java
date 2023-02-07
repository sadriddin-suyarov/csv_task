package com.example.sort_csv_task.service.impl;

import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.repository.CityRepository;
import com.example.sort_csv_task.service.CsvSortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbSortApproach1 implements CsvSortService {
    private final CityRepository cityRepository;

    @Override
    public List<String> sortStringData() {
        return cityRepository.getSortedStringDataCustom();
    }

    @Override
    public List<Integer> sortNumericData() {
        return cityRepository.getSortedNumericDataCustom();
    }

    @Override
    public List<City> sortCityByStringData() {
        return cityRepository.getCitySortedByStringDataCustom();
    }

    @Override
    public List<City> sortCityByNumericData() {
        return cityRepository.getCitySortedByNumericDataCustom();
    }
}
