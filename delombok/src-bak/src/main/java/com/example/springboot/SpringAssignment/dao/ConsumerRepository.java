package com.example.springboot.SpringAssignment.dao;

import com.example.springboot.SpringAssignment.entity.Consumers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumers,Integer> {
    List<Consumers> findByConsumerName(String theName);

}
