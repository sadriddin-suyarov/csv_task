package com.example.sort_csv_task.service.impl;

import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.service.CsvSortService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
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
public class CsvSortApproach2 implements CsvSortService {

    private List<City> loadedData = new ArrayList<>();

    @PostConstruct
    void loadData() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("myFile0.csv");
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        CSVReader csvReader = new CSVReaderBuilder(reader).build();
        loadedData = new CsvToBeanBuilder<City>(csvReader)
                .withType(City.class)
                .build()
                .parse();
        loadedData = loadedData.subList(1, loadedData.size());
    }
    @Override
    public List<String> sortStringData() {
        return loadedData.stream()
                .parallel()
                .map(City::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> sortNumericData() {
        return loadedData.stream()
                .parallel()
                .map(City::getCode)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<City> sortCityByStringData() {
        return loadedData.stream()
                .parallel()
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<City> sortCityByNumericData() {
        return loadedData.stream()
                .parallel()
                .sorted(Comparator.comparing(City::getCode))
                .collect(Collectors.toList());
    }
}
