package com.example.sort_csv_task.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class City {
    @Id
    private Integer id;

    @CsvBindByName(column = "city_code")
    private Integer code;

    @CsvBindByName(column = "city")
    private String name;

    public City(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
