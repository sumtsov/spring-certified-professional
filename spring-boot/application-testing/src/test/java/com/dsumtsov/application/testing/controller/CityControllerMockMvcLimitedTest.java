package com.dsumtsov.application.testing.controller;

import com.dsumtsov.application.testing.model.City;
import com.dsumtsov.application.testing.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
// only CityController bean is created in Application Context
// and MockMvc is configured
// if no classes is specified, it will create ApplicationContext that contains only web components
// and omits any other components
public class CityControllerMockMvcLimitedTest {

    @Autowired
    private MockMvc mvc;
    // in this test setup cityDAO is not created on Application Context startup,
    // but CityController needs it, so we create a mock
    @MockBean
    private CityService cityService;

    @Test
    public void saveCityTest() throws Exception {
        mvc.perform(
                post("/api/v1/cities")
                        .content("{ \"name\": \"Los Angeles\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        verify(cityService).save(new City(null, "Los Angeles"));
    }

    @Test
    public void getCitiesTest() throws Exception {
        when(cityService.findAll())
                .thenReturn(Arrays.asList(
                        new City(1L, "Los Angeles"),
                        new City(2L, "New York")
                ));

        String jsonResponse = mvc.perform(get("/api/v1/cities"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(jsonResponse)
                .contains("{\"id\":1,\"name\":\"Los Angeles\"}")
                .contains("{\"id\":2,\"name\":\"New York\"}");
    }
}

