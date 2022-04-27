package com.example.springboot.SpringAssignment.service;

import com.example.springboot.SpringAssignment.entity.Consumers;

import java.util.List;

public interface ConsumerService {
    public List<Consumers> findAll();

    public Consumers findById(int theId);

    public void save(Consumers consumers);

    public void deleteById(int theId);

    List<Consumers> searchByName(String theName);

}
