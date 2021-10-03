package com.dsumtsov.application.testing.service;

import com.dsumtsov.application.testing.dao.CityDAO;
import com.dsumtsov.application.testing.model.City;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityDAO cityDAO;

    public List<City> findAll() {
        return Lists.newArrayList(cityDAO.findAll());
    }

    public City find(String name) {
        return cityDAO.findByName(name);
    }

    public void save(City city) {
        cityDAO.save(city);
    }
}
