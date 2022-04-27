package com.example.springboot.SpringAssignment.controllerTest;

import com.example.springboot.SpringAssignment.controller.ConsumerController;
import com.example.springboot.SpringAssignment.dao.ConsumerRepository;
import com.example.springboot.SpringAssignment.entity.Consumers;
import com.example.springboot.SpringAssignment.service.ConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerControllerTest {
    @Mock
    private ConsumerService consumerService;

    @Mock
    private ConsumerRepository consumerRepository;
    private MockMvc mockMvc=null;

    Consumers consumers = new Consumers(2, "pardeep kumar", "omkar", "pawan@gmail.com", "sec-3 faridabad house no21", "2022-03-26", "2022-04-26", 2900, 3000, 100, 2, 0, 200, 1);

    @Test
    public void listConsumers() throws Exception {
        List<Consumers> consumersList = new ArrayList<>(Arrays.asList(consumers));
//        ConsumerController consumerController=new ConsumerController();
//        String response = consumerController.listConsumers();
          when(consumerService.findAll()).thenReturn(consumersList);
          mockMvc.perform(MockMvcRequestBuilders.get("/consumers/list-consumers").contentType(MediaType.ALL)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}

