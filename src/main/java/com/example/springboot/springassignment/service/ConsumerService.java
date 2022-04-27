package com.example.springboot.springassignment.service;

import com.example.springboot.springassignment.entity.Consumers;

import java.util.List;

public interface ConsumerService {
    public List<Consumers> findAll();

    public Consumers findById(int theId);

    public void save( Consumers consumers);

    public void deleteById(int theId);



}
