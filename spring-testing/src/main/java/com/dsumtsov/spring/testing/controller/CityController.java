package com.dsumtsov.spring.testing.controller;

import com.dsumtsov.spring.testing.model.City;
import com.dsumtsov.spring.testing.service.CityService;
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
        return Lists.newArrayList(cityService.findAll());
    }

    @PostMapping
    public void saveCity(@RequestBody City city) {
        cityService.save(city);
    }
}
