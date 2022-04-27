package com.example.springboot.springassignment.service;

import com.example.springboot.springassignment.dao.ConsumerRepository;
import com.example.springboot.springassignment.entity.Consumers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;



@Service
public class ConsumerServiceImpl implements ConsumerService{

    private ConsumerRepository consumerRepository;
    @Autowired
   public ConsumerServiceImpl(ConsumerRepository consumerRepository){
       this.consumerRepository=consumerRepository;

   }

    @Override
    public List<Consumers> findAll() {
        return consumerRepository.findAll();
    }

    @Override
    public Consumers findById(int theId) {
        Optional<Consumers> result = consumerRepository.findById(theId);
        Consumers consumers = null;

        if(result.isPresent()){
            consumers=result.get();
        }
        return consumers;
    }

    @Override
    public void save(Consumers consumers) {
            consumerRepository.save(consumers);
    }

    @Override
    public void deleteById(int theId) {
        consumerRepository.deleteById(theId);
    }



}
