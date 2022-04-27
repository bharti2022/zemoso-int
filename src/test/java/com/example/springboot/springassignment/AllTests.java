package com.example.springboot.springassignment;

import com.example.springboot.springassignment.dao.ConsumerRepository;
import com.example.springboot.springassignment.entity.Consumers;
import com.example.springboot.springassignment.service.ConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllTests {
    @Autowired
    private ConsumerService consumerService;

    @MockBean
    private ConsumerRepository consumerRepository;
    Consumers consumer = new Consumers(1, "pardeep kumar", "omkar", "pawan@gmail.com", "sec-3 faridabad house no21", "2022-03-26", "2022-04-26", 2900, 3000, 100, 2, 0, 200, 1);


    @Test
    public void getConsumersTest(){
        List<Consumers> consumersList=new ArrayList<>(Arrays.asList(consumer));
        when(consumerRepository.findAll()).thenReturn(consumersList);
        assertEquals(1,consumerService.findAll().size());

        List<Consumers> result=consumerService.findAll();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getConsumerName()).isEqualTo(consumer.getConsumerName());



    }

    @Test
    public void getConsumerById(){
        when(consumerRepository.findById(1)).thenReturn(Optional.of(consumer));
        assertEquals(consumer,consumerService.findById(consumer.getId()));
    }
   @Test
   public void deleteConsumerTest(){
        consumerRepository.delete(consumer);
        consumerService.deleteById(consumer.getId());
        verify(consumerRepository,times(1)).deleteById(consumer.getId());
   }
   @Test
    public void save(){
        consumerService.save(consumer);
        verify(consumerRepository, Mockito.times(1)).save(consumer);
   }

}
