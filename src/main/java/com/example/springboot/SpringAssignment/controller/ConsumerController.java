package com.example.springboot.SpringAssignment.controller;

import com.example.springboot.SpringAssignment.entity.Consumers;
//import com.example.springboot.SpringAssignment.exceptions.ConsumerNotFoundException;
import com.example.springboot.SpringAssignment.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/consumers")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    public ConsumerController(){

    }
    public ConsumerController(ConsumerService consumerService){
        this.consumerService=consumerService;
    }

    //add mapping for list of consumers
    @GetMapping("/list")
    public String listConsumers(Model theModel){
        List<Consumers> theConsumers = consumerService.findAll();
        theModel.addAttribute("consumers",theConsumers);
        return "/consumers/list-consumers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Consumers theConsumers = new Consumers();

            theModel.addAttribute("consumers", theConsumers);

        return "/consumers/consumer-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("consumers") Consumers consumers, BindingResult bindingResult) {

          if(bindingResult.hasErrors()){

              System.out.println(bindingResult.toString());
              return "redirect:/consumers/showFormForUpdate?consumerId="+consumers.getId();
          }
        else {
              // save the employee
              System.out.println(bindingResult);
              consumerService.save(consumers);
              return "redirect:/consumers/list";
          }
              // use a redirect to prevent duplicate submissions
//               consumerService.save(consumers);
//              return "redirect:/consumers/list";

          }



    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("consumerId") int theId,
                                    Model theModel) {

        // get the consumer from the service
        Consumers consumers = consumerService.findById(theId);
//        if(consumers==null){
//            throw new ConsumerNotFoundException("Consumer is not found in data"+theId);
//        }
//        // set consumer as a model attribute to pre-populate the form
        theModel.addAttribute("consumers", consumers);

        // send over to our form
        return "/consumers/consumer-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("consumerId") int theId){
        Consumers consumers = consumerService.findById(theId);
//        if (consumers == null) {
//
//            throw new ConsumerNotFoundException("Consumer is not present in data" +theId);
//
//        }
//        consumerService.deleteById(theId);
        return "redirect:/consumers/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam("consumerName") String theName,
                         Model theModel) {

        // delete the employee
        List<Consumers> consumers = consumerService.searchByName(theName);

        if(consumers==null){

            return "/consumers/list-consumers";
        }
        else {
            // add to the spring model
            theModel.addAttribute("consumers", consumers);

            // send to /employees/list
            return "/consumers/list-consumers";
        }


    }


}
