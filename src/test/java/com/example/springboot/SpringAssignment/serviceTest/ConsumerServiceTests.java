package com.example.springboot.SpringAssignment.serviceTest;

import com.example.springboot.SpringAssignment.dao.ConsumerRepository;
import com.example.springboot.SpringAssignment.entity.Consumers;
import com.example.springboot.SpringAssignment.service.ConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerServiceTests {
    @Autowired
    private ConsumerService consumerService;

    @MockBean
    private ConsumerRepository consumerRepository;

    @Test
    public void getConsumersTest(){
        Consumers consumers = new Consumers(1, "pardeep kumar", "omkar", "pawan@gmail.com", "sec-3 faridabad house no21", "2022-03-26", "2022-04-26", 2900, 3000, 100, 2, 0, 200, 1);
        List<Consumers> consumersList=new ArrayList<>(Arrays.asList(consumers));
        when(consumerRepository.findAll()).thenReturn(consumersList);
        assertEquals(1,consumerService.findAll().size());
    }



    @Test
    public void getConsumerById(){
        Consumers consumer = new Consumers(1, "pardeep kumar", "omkar", "pawan@gmail.com", "sec-3 faridabad house no21", "2022-03-26", "2022-04-26", 2900, 3000, 100, 2, 0, 200, 1);
       // consumerRepository.save(consumer);
        when(consumerRepository.findById(1)).thenReturn(Optional.of(consumer));
        assertEquals(consumer,consumerService.findById(consumer.getId()));
    }
   @Test
   public void deleteConsumerTest(){
       Consumers consumers = new Consumers(2, "pardeep kumar", "omkar", "pawan@gmail.com", "sec-3 faridabad house no21", "2022-03-26", "2022-04-26", 2900, 3000, 100, 2, 0, 200, 1);
        consumerRepository.delete(consumers);
        consumerService.deleteById(consumers.getId());
        verify(consumerRepository,times(1)).deleteById(consumers.getId());
   }
//
//   @Test
//    public void saveConsumerTest(){
//       Consumers consumers = new Consumers(2, "pardeep kumar", "omkar", "pawan@gmail.com", "sec-3 faridabad house no21", "2022-03-26", "2022-04-26", 2900, 3000, 100, 2, 0, 200, 1);
//       when(consumerRepository.getById(2)).thenReturn(consumers);
//     //  assertEquals(consumers.getConsumerName(),consumerService.save(consumerRepository.findById(consumers.getId())).getConsumerName());
////            assertEquals(consumers.getConsumerName(),consumerService.save(consumers));
//   }

}