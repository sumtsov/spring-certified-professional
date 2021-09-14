package com.dsumtsov.application.testing.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest // loads the complete Application Context
@AutoConfigureMockMvc
public class CityControllerMockMvcFullTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void saveCitiesTest() throws Exception {
        mvc.perform(
                post("/api/v1/cities")
                        .content("{ \"name\": \"Los Angeles\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        mvc.perform(
                post("/api/v1/cities")
                        .content("{ \"name\": \"New York\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        String jsonResponse = mvc.perform(get("/api/v1/cities"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(jsonResponse)
                .contains("{\"id\":1,\"name\":\"Los Angeles\"}")
                .contains("{\"id\":2,\"name\":\"New York\"}");
    }
}
