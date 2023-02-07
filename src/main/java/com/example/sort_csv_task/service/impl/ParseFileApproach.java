package com.example.sort_csv_task.service.impl;

import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.service.CsvSortService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ParseFileApproach implements CsvSortService {

    private List<String> loadedData = new ArrayList<>();

    @PostConstruct
    void loadData() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("myFile0.csv");
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        while (reader.ready()) {
            loadedData.add(reader.readLine());
        }
        loadedData = loadedData.subList(1, loadedData.size());
    }

    @Override
    public List<String> sortStringData() {
        List<String> stringList = new ArrayList<>();
        for (String element : loadedData) {
            stringList.add(element.split(",")[1]);
        }
        Collections.sort(stringList);
        return stringList;
    }

    @Override
    public List<Integer> sortNumericData() {
        List<Integer> numericList = new ArrayList<>();
        for (String element : loadedData) {
            numericList.add(Integer.valueOf(element.split(",")[0]));
        }
        Collections.sort(numericList);
        return numericList;
    }

    @Override
    public List<City> sortCityByStringData() {
        List<City> cityList = new ArrayList<>();
        for (String s : loadedData) {
            cityList.add(new City(Integer.valueOf(s.split(",")[0]), s.split(",")[1]));
        }
        cityList.sort(Comparator.comparing(City::getName));
        return cityList;
    }

    @Override
    public List<City> sortCityByNumericData() {
        List<City> cityList = new ArrayList<>();
        for (String s : loadedData) {
            cityList.add(new City(Integer.valueOf(s.split(",")[0]), s.split(",")[1]));
        }
        cityList.sort(Comparator.comparing(City::getCode));
        return cityList;
    }
}
