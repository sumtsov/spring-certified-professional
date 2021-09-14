package com.dsumtsov.application.testing.dao;

import com.dsumtsov.application.testing.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityDAO extends CrudRepository<City, Long> {
    City findByName(String name);
}
