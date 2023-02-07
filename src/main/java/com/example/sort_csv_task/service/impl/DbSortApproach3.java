package com.example.sort_csv_task.service.impl;

import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.repository.CityRepository;
import com.example.sort_csv_task.service.CsvSortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DbSortApproach3 implements CsvSortService {
    private final CityRepository cityRepository;
    @Override
    public List<String> sortStringData() {
        List<City> list = cityRepository.findAll();
        return list.stream()
                .map(City::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> sortNumericData() {
        List<City> list = cityRepository.findAll();
        return list.stream()
                .map(City::getCode)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<City> sortCityByStringData() {
        List<City> list = cityRepository.findAll();
        return list.stream()
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<City> sortCityByNumericData() {
        List<City> list = cityRepository.findAll();
        return list.stream()
                .sorted(Comparator.comparing(City::getCode))
                .collect(Collectors.toList());
    }
}
