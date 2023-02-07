package com.example.sort_csv_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvTaskApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(CsvTaskApplication.class, args);
        Thread.sleep(20000);
    }

}
