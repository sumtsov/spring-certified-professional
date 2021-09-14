package com.dsumtsov.application.testing.controller;

import com.dsumtsov.application.testing.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class) // enables JUnit 4, not needed for JUnit 5
@SpringBootTest // loads the complete Application Context
@AutoConfigureMockMvc
public class CustomerControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

    @Test
    public void getCustomerTest() throws Exception {

        when(customerService.getName()).thenReturn("Test");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers"))
                .andReturn();

        assertEquals("Test", mvcResult.getResponse().getContentAsString());
    }
}
