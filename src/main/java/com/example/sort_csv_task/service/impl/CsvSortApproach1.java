package com.example.sort_csv_task.service.impl;

import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.service.CsvSortService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvSortApproach1 implements CsvSortService {

    private List<String[]> loadedData = new ArrayList<>();

    @PostConstruct
    void loadData() throws IOException, CsvException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("myFile0.csv");
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        CSVReader csvReader = new CSVReaderBuilder(reader).build();
        loadedData = csvReader.readAll();
        loadedData = loadedData.subList(1, loadedData.size());
    }
    @Override
    public List<String> sortStringData() {
        return loadedData.stream()
                .map(stringArr -> stringArr[1])
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> sortNumericData() {
        return loadedData.stream()
                .map(stringArr -> stringArr[0])
                .map(Integer::valueOf)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<City> sortCityByStringData() {
        return loadedData.stream()
                .map(stringArr -> new City(Integer.valueOf(stringArr[0]), stringArr[1]))
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<City> sortCityByNumericData() {
        return loadedData.stream()
                .map(stringArr -> new City(Integer.valueOf(stringArr[0]), stringArr[1]))
                .sorted(Comparator.comparing(City::getCode))
                .collect(Collectors.toList());
    }
}
