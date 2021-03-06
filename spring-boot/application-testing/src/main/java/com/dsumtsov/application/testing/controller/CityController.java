package com.dsumtsov.application.testing.controller;

import com.dsumtsov.application.testing.dao.CityDAO;
import com.dsumtsov.application.testing.model.City;
import com.dsumtsov.application.testing.service.CityService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/cities",
        produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> getCities() {
        return cityService.findAll();
    }

    @PostMapping
    public void saveCity(@RequestBody City city) {
        cityService.save(city);
    }
}
