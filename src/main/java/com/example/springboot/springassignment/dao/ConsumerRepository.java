package com.example.springboot.springassignment.dao;

import com.example.springboot.springassignment.entity.Consumers;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumers,Integer> {

}
