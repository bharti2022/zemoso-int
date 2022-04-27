package com.example.springboot.SpringAssignment.dao;

import com.example.springboot.SpringAssignment.entity.Consumers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumers,Integer> {
//    @Query("select * from consumer_details where consumerName like ?1%")
    List<Consumers> findByConsumerNameLike(String theName);

}
