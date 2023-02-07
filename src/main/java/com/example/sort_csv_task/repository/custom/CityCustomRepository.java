package com.example.sort_csv_task.repository.custom;

import com.example.sort_csv_task.domain.City;

import java.util.List;

public interface CityCustomRepository {

    List<String> getSortedStringDataCustom();
    List<Integer> getSortedNumericDataCustom();
    List<City> getCitySortedByStringDataCustom();
    List<City> getCitySortedByNumericDataCustom();

}
