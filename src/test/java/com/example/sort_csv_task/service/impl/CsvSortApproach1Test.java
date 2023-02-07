package com.example.sort_csv_task.service.impl;

import com.example.sort_csv_task.ListUtil;
import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.service.CsvSortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CsvSortApproach1Test {

    @Autowired
    @Qualifier("csvSortApproach1")
    CsvSortService service;

    @Test
    void sortStringData() {
        List<String> list = service.sortStringData();
        assertTrue(list.size() > 0);
        ListUtil.printList(list);
    }

    @Test
    void sortNumericData() {
        List<Integer> list = service.sortNumericData();
        assertTrue(list.size() > 0);
        ListUtil.printList(list);
    }

    @Test
    void sortCityByStringData() {
        List<City> list = service.sortCityByStringData();
        assertTrue(list.size() > 0);
        ListUtil.printList(list);
    }

    @Test
    void sortCityByNumericData() {
        List<City> list = service.sortCityByNumericData();
        assertTrue(list.size() > 0);
        ListUtil.printList(list);
    }
}