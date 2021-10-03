package com.dsumtsov.spring.testing.dao;

import com.dsumtsov.spring.testing.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityDAO extends CrudRepository<City, Long> {
    City findByName(String name);
}
