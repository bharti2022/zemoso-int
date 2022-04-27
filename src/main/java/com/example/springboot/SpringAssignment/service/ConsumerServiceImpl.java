package com.example.springboot.SpringAssignment.service;

import com.example.springboot.SpringAssignment.dao.ConsumerRepository;
import com.example.springboot.SpringAssignment.entity.Consumers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        }else {
            throw new RuntimeException("didnot found consumer==============>"+theId);
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

//    @Override
//    public List<Consumers> searchBy(String theName) {
//        return null;
//    }

    @Override
    public List<Consumers> searchByName(String theName) {
       List<Consumers> results= null;
       if(theName!=null && (theName.trim().length()>0)){
          // results = consumerRepository.findByConsumerName(theName);
           results = consumerRepository.findByConsumerNameLike("%"+theName+"%");
           System.out.println(results);
       }
       else{
           results = findAll();
           System.out.println(results);
       }
        return results;
    }
}
