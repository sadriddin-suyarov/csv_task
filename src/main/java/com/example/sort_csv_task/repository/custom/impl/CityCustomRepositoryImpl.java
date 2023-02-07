package com.example.sort_csv_task.repository.custom.impl;

import com.example.sort_csv_task.domain.City;
import com.example.sort_csv_task.repository.custom.CityCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CityCustomRepositoryImpl implements CityCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<String> getSortedStringDataCustom() {
        String queryStr = "SELECT T.NAME FROM CITY T ORDER BY T.NAME";
        List<String> resultList;
        try {
            Query query = em.createNativeQuery(queryStr);
            resultList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            resultList = new ArrayList<>();
        }
        return resultList;
    }

    @Override
    public List<Integer> getSortedNumericDataCustom() {
        String queryStr = "SELECT T.CODE FROM CITY T ORDER BY T.CODE";
        List<Integer> resultList;
        try {
            Query query = em.createNativeQuery(queryStr);
            resultList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            resultList = new ArrayList<>();
        }
        return resultList;
    }

    @Override
    public List<City> getCitySortedByStringDataCustom() {
        String queryStr = "SELECT * FROM CITY T ORDER BY T.NAME";
        List<City> resultList;
        try {
            Query query = em.createNativeQuery(queryStr, City.class);
            resultList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            resultList = new ArrayList<>();
        }
        return resultList;
    }

    @Override
    public List<City> getCitySortedByNumericDataCustom() {
        String queryStr = "SELECT * FROM CITY T ORDER BY T.CODE";
        List<City> resultList;
        try {
            Query query = em.createNativeQuery(queryStr, City.class);
            resultList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            resultList = new ArrayList<>();
        }
        return resultList;
    }
}
